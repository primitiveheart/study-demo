package com.zgb.web.common.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zgb.web.common.CommonResponse;
import com.zgb.web.common.annotation.Response;
import org.springframework.context.MessageSource;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * 1.处理Controller中增加注解@Response方法的返回值，
 * 2.将Controller的方法返回值设置到一个CommonResponse对象，
 * 3.然后使用JSON方式序列化该CommonResponse对象
 * @author xmly
 */
public class ResponseReturnValueHandler implements HandlerMethodReturnValueHandler {
  private static final MediaType MEDIA_TYPE_APPLICATION = new MediaType("application");
  protected final List<MediaType> allSupportedMediaTypes;
  private final HttpMessageConverter<String> httpMessageConverter;
  private MediaType defaultSupportMediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
  private MessageSource messageSource;

  public ResponseReturnValueHandler(HttpMessageConverter<String> httpMessageConverter, MessageSource messageSource) {
    this.httpMessageConverter = httpMessageConverter;
    this.allSupportedMediaTypes = getAllSupportedMediaTypes(httpMessageConverter);
    this.messageSource = messageSource;
  }

  /**
   * Returns the media types supported by all provided message converters preserving their ordering
   * and further sorting by specificity via {@link MediaType#sortBySpecificity(List)}.
   */
  private static List<MediaType> getAllSupportedMediaTypes(HttpMessageConverter<String> messageConverter) {
    Set<MediaType> allSupportedMediaTypes = new LinkedHashSet<MediaType>();
    allSupportedMediaTypes.addAll(messageConverter.getSupportedMediaTypes());
    List<MediaType> result = new ArrayList<MediaType>(allSupportedMediaTypes);
    MediaType.sortBySpecificity(result);
    return Collections.unmodifiableList(result);
  }

  @Override
  public boolean supportsReturnType(MethodParameter returnType) {
    return (returnType.getMethodAnnotation(Response.class) != null);
  }

  protected void handleReturnValue(String returnValue, ServletServerHttpRequest inputMessage,
                                   ServletServerHttpResponse outputMessage) throws HttpMediaTypeNotAcceptableException, IOException {
    List<MediaType> acceptableMediaTypes = getAcceptableMediaTypes(inputMessage);
    List<MediaType> producibleMediaTypes = getProducibleMediaTypes(inputMessage.getServletRequest(), String.class);

    Set<MediaType> compatibleMediaTypes = new LinkedHashSet<MediaType>();
    for (MediaType a : acceptableMediaTypes) {
      for (MediaType p : producibleMediaTypes) {
        if (a.isCompatibleWith(p)) {
          compatibleMediaTypes.add(getMostSpecificMediaType(a, p));
        }
      }
    }
    if (compatibleMediaTypes.isEmpty()) {
      throw new HttpMediaTypeNotAcceptableException(allSupportedMediaTypes);
    }

    List<MediaType> mediaTypes = new ArrayList<MediaType>(compatibleMediaTypes);
    MediaType.sortBySpecificity(mediaTypes);

    MediaType selectedMediaType = null;
    for (MediaType mediaType : mediaTypes) {
      if (mediaType.isConcrete()) {
        selectedMediaType = mediaType;
        break;
      } else if (mediaType.equals(MediaType.ALL) || mediaType.equals(MEDIA_TYPE_APPLICATION)) {
        selectedMediaType = defaultSupportMediaType;
        break;
      } else if (mediaType.equals(MEDIA_TYPE_APPLICATION)) {
        selectedMediaType = MediaType.APPLICATION_OCTET_STREAM;
        break;
      }
    }

    if (selectedMediaType != null) {
      httpMessageConverter.write(returnValue, defaultSupportMediaType, outputMessage);
      return;
    }
    throw new HttpMediaTypeNotAcceptableException(allSupportedMediaTypes);
  }

  @Override
  public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
                                NativeWebRequest webRequest) throws HttpMediaTypeNotAcceptableException, IOException {
    mavContainer.setRequestHandled(true);
    CommonResponse commonResponse = null;
    if (returnValue instanceof CommonResponse) {
      commonResponse = (CommonResponse) returnValue;
      // if ret not equals to 0, should try to set value into msg
      if (commonResponse.getCode() != 0 && null == commonResponse.getMsg()) {
        String returnCode = String.valueOf(commonResponse.getCode());
        String msg = messageSource.getMessage(returnCode, null, "error", Locale.CHINA);
        commonResponse.setMsg(msg);
      }
    } else {
      // set returnValue into data
      commonResponse = CommonResponse.success(returnValue);
    }
    String result = JSON.toJSONString(commonResponse, SerializerFeature.DisableCircularReferenceDetect);
    ServletServerHttpResponse outputMessage = createOutputMessage(webRequest);
    ServletServerHttpRequest inputMessage = createInputMessage(webRequest);
    handleReturnValue(result, inputMessage, outputMessage);
  }

  /**
   * Creates a new {@link HttpOutputMessage} from the given {@link NativeWebRequest}.
   *
   * @param webRequest the web request to create an output message from
   * @return the output message
   */
  protected ServletServerHttpResponse createOutputMessage(NativeWebRequest webRequest) {
    HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
    return new ServletServerHttpResponse(response);
  }

  /**
   * Create a new {@link HttpInputMessage} from the given {@link NativeWebRequest}.
   *
   * @param webRequest the web request to create an input message from
   * @return the input message
   */
  protected ServletServerHttpRequest createInputMessage(NativeWebRequest webRequest) {
    HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
    return new ServletServerHttpRequest(servletRequest);
  }

  /**
   * Returns the media types that can be produced:
   * <ul>
   * <li>The producible media types specified in the request mappings, or
   * <li>Media types of configured converters that can write the specific return value, or
   * <li>{@link MediaType#ALL}
   * </ul>
   */
  @SuppressWarnings("unchecked")
  protected List<MediaType> getProducibleMediaTypes(HttpServletRequest request, Class<?> returnValueClass) {
    Set<MediaType> mediaTypes = (Set<MediaType>) request.getAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE);
    if (!CollectionUtils.isEmpty(mediaTypes)) {
      return new ArrayList<MediaType>(mediaTypes);
    } else if (!allSupportedMediaTypes.isEmpty()) {
      List<MediaType> result = new ArrayList<MediaType>();
      if (httpMessageConverter.canWrite(returnValueClass, null)) {
        result.addAll(httpMessageConverter.getSupportedMediaTypes());
      }
      return result;
    } else {
      return Collections.singletonList(MediaType.ALL);
    }
  }

  protected List<MediaType> getAcceptableMediaTypes(HttpInputMessage inputMessage) {
    List<MediaType> result = inputMessage.getHeaders().getAccept();
    return result.isEmpty() ? Collections.singletonList(MediaType.ALL) : result;
  }

  /**
   * Returns the more specific media type using the q-value of the first media type for both.
   */
  private MediaType getMostSpecificMediaType(MediaType type1, MediaType type2) {
    double quality = type1.getQualityValue();
    Map<String, String> params = Collections.singletonMap("q", String.valueOf(quality));
    MediaType t1 = new MediaType(type1, params);
    MediaType t2 = new MediaType(type2, params);
    return MediaType.SPECIFICITY_COMPARATOR.compare(t1, t2) <= 0 ? type1 : type2;
  }
}
