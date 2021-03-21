package com.zgb.quartz.admin.task;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zgb.quartz.admin.pojo.entity.STimetask;
import com.zgb.quartz.admin.service.STimetaskService;
import com.zgb.quartz.admin.util.DataTablesUtil;
import com.zgb.quartz.common.constant.Const;
import com.zgb.quartz.common.pojo.vo.JsonResult;
import com.zgb.quartz.common.utils.DateUtil;
import com.zgb.quartz.common.utils.HttpConnectUtil;
import com.zgb.quartz.common.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.jvm.hotspot.debugger.Page;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时任务
 *
 * @author wison
 */
@Controller
@RequestMapping(value = "/task")
public class TimeTaskController extends BaseController {
  private static String JOB_URL = Const.QUARTZ_JOB_URL;
  /**
   * 所有计划中的任务列表
   */
  private static String ALL_JOB = JOB_URL + "/opt/getAllJob";
  /**
   * 所有正在运行的job
   */
  private static String RUNNING_JOB = JOB_URL + "/opt/getRunningJob";
  /**
   * 添加任务
   */
  private static String ADD_JOB = JOB_URL + "/opt/addJob";
  /**
   * 暂停一个job
   */
  private static String PAUSE_JOB = JOB_URL + "/opt/pauseJob";
  /**
   * 恢复一个job
   */
  private static String RESUME_JOB = JOB_URL + "/opt/resumeJob";
  /**
   * 删除一个job
   */
  private static String DELETE_JOB = JOB_URL + "/opt/deleteJob";
  /**
   * 立即执行job
   */
  private static String RUNA_JOB = JOB_URL + "/opt/runAJobNow";
  /**
   * 更新job时间表达式
   */
  private static String UPDATE_JOB = JOB_URL + "/opt/updateJobCron";

  private static final Logger logger = LoggerFactory.getLogger(TimeTaskController.class);
  @Autowired
  private STimetaskService stimetaskService;

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    DateFormat fmt = new SimpleDateFormat(DateUtil.STANDARD_DATE_FORMAT_STR);
    CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
    binder.registerCustomEditor(Date.class, dateEditor);
  }

  /**
   * 列表页面跳转
   *
   * @return
   */
  @RequestMapping(value = "/list")
  public ModelAndView userList(STimetask task) {
    ModelAndView mv = this.getModelAndView();
    mv.setViewName("system/timeTaskList");
    return mv;
  }

  /**
   * 列表
   *
   * @return
   */
  @RequestMapping(value = "/task_list")
  @ResponseBody
  public JsonResult taskList(DataTablesUtil dataTables, STimetask task, Page page, HttpSession session) {
    List<STimetask> list = stimetaskService.selectByPage(task, page);
    // 查询task的运行状态

    String result = HttpConnectUtil.httpRequest(RUNNING_JOB, Const.REQUEST_METHOD_POST, null);
    if (result != null) {
      JSONObject jsonResult = JSONObject.parseObject(result);
      Map<String, ScheduleJob> map = new HashMap<String, ScheduleJob>();
      if (jsonResult.get("code").equals("2000")) {
        JSONObject js = (JSONObject) jsonResult.get("data");
        JSONArray dataArray = (JSONArray) js.get("job");
        if (dataArray.size() > 0) {
          List<ScheduleJob> jobList = JSONArray.toList(dataArray, ScheduleJob.class);
          for (ScheduleJob job : jobList) {
            map.put(job.getJobId().toString(), job);
          }
        }
      }
      for (STimetask st : list) {
        if (map.containsKey(st.getId())) {
          st.setConcurrent(true);
        }
      }
    }
    // 查询task的计划状态
    String planResult = HttpConnectUtil.httpRequest(ALL_JOB, Const.REQUEST_METHOD_POST, null);
    if (planResult != null) {
      JSONObject jsonPlanResult = JSONObject.parseObject(planResult);
      Map<String, ScheduleJob> planMap = new HashMap<String, ScheduleJob>();
      if (jsonPlanResult.get("code").equals("2000")) {
        JSONObject js = (JSONObject) jsonPlanResult.get("data");
        JSONArray dataArray = (JSONArray) js.get("job");
        if (dataArray.size() > 0) {
          List<ScheduleJob> jobList = JSONArray.toList(dataArray, ScheduleJob.class);
          for (ScheduleJob job : jobList) {
            planMap.put(job.getJobId().toString(), job);
          }
        }
      }
      for (STimetask st : list) {
        if (planMap.containsKey(st.getId())) {
          String status = planMap.get(st.getId()).getJobStatus();
          st.setPlanStatus(status);
        }
      }
    }
    //返回dataTable所需数据
    dataTables = this.getDataTables(page, dataTables, list);
    return new JsonResult("2000", dataTables);
  }

  /**
   * 立即执行一次job
   * 用于测试任务是否正确
   *
   * @param id
   * @return
   */
  @RequestMapping(value = "/run_task2job")
  @ResponseBody
  public JsonResult run_task2job(String id) {
    //查询task
    STimetask stimetask = stimetaskService.selectByPrimaryKey(id);
    JsonConfig jsonConfig = new JsonConfig();
    jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
    JSONObject jsonArray = JSONObject.fromObject(stimetask, jsonConfig);
    String result = HttpConnectUtil.httpRequest(RUNA_JOB, Const.REQUEST_METHOD_POST, jsonArray.toString());
    logger.info(result);
    if (result == null) {
      return new JsonResult("5000", "定时项目未启动", null);
    } else {
      return new JsonResult("2000", null);
    }
  }

  /**
   * 添加job到计划列表
   *
   * @param id
   * @return
   */
  @RequestMapping(value = "/add_task2job")
  @ResponseBody
  public JsonResult add_task2job(String id) {
    //查询task
    STimetask stimetask = stimetaskService.selectByPrimaryKey(id);
    JsonConfig jsonConfig = new JsonConfig();
    jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
    JSONObject jsonArray = JSONObject.fromObject(stimetask, jsonConfig);
    String result = HttpConnectUtil.httpRequest(ADD_JOB, Const.REQUEST_METHOD_POST, jsonArray.toString());
    logger.info(result);
    if (result == null) {
      return new JsonResult("5000", "定时项目未启动", null);
    } else {
      return new JsonResult("2000", null);
    }

  }

  /**
   * 从计划列表中暂停job
   *
   * @param id
   * @return
   */
  @RequestMapping(value = "/stop_task2job")
  @ResponseBody
  public JsonResult stop_task2job(String id) {
    //查询task
    STimetask stimetask = stimetaskService.selectByPrimaryKey(id);
    JsonConfig jsonConfig = new JsonConfig();
    jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
    JSONObject jsonArray = JSONObject.fromObject(stimetask, jsonConfig);
    String result = HttpConnectUtil.httpRequest(PAUSE_JOB, Const.REQUEST_METHOD_POST, jsonArray.toString());
    logger.info(result);
    if (result == null) {
      return new JsonResult("5000", "定时项目未启动", null);
    } else {
      return new JsonResult("2000", null);
    }
  }

  /**
   * 从计划列表中移除job
   *
   * @param id
   * @return
   */
  @RequestMapping(value = "/remove_task2job")
  @ResponseBody
  public JsonResult remove_task2job(String id) {
    //查询task
    STimetask stimetask = stimetaskService.selectByPrimaryKey(id);
    JsonConfig jsonConfig = new JsonConfig();
    jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
    JSONObject jsonArray = JSONObject.fromObject(stimetask, jsonConfig);
    String result = HttpConnectUtil.httpRequest(DELETE_JOB, Const.REQUEST_METHOD_POST, jsonArray.toString());
    logger.info(result);
    if (result == null) {
      return new JsonResult("5000", "定时项目未启动", null);
    } else {
      return new JsonResult("2000", null);
    }
  }

  /**
   * 变更job状态
   *
   * @param id
   * @return
   */
  @RequestMapping(value = "/update_task")
  @ResponseBody
  public JsonResult update_task(String ids, String type) {
    //查询task
    String[] idArray = ids.split(",");
    Map<String, String> selectedIdMap = new HashMap<String, String>();
    List<String> idList = new ArrayList<String>();
    for (int i = 0; i < idArray.length; i++) {
      idList.add(idArray[i]);
    }
    int ret = stimetaskService.updatebyOperate(idList, type);
    if (ret > 0) {
      return new JsonResult(true);
    } else {
      return new JsonResult(false);
    }
  }

  /**
   * 删除job
   *
   * @param id
   * @return
   */
  @RequestMapping(value = "/delete_task")
  @ResponseBody
  public JsonResult delete_task(String ids) {
    //查询task
    String[] idArray = ids.split(",");
    Map<String, String> selectedIdMap = new HashMap<String, String>();
    List<String> idList = new ArrayList<String>();
    for (int i = 0; i < idArray.length; i++) {
      idList.add(idArray[i]);
    }
    int ret = stimetaskService.deleteByIds(idList);
    if (ret > 0) {
      return new JsonResult(true);
    } else {
      return new JsonResult(false);
    }
  }

  /**
   * 详情页面
   *
   * @return
   */
  @RequestMapping(value = "/task_detail")
  public ModelAndView detail(String id) {
    ModelAndView mv = this.getModelAndView();
    STimetask model = new STimetask();
    model = stimetaskService.selectByPrimaryKey(id);
    mv.addObject("model", model);
    mv.setViewName("system/timeTaskDetail");
    return mv;
  }

  /**
   * 解析cron
   *
   * @return
   */
  @RequestMapping(value = "/analysis_cron")
  @ResponseBody
  public JsonResult analysisCron(String cron) {
    try {
      Date date = new Date();
      String dateStr = DateUtil.formatStandardDatetime(date);
      List<String> dateList = CronUtil.cronAlgBuNums(cron, dateStr, 5);
      return new JsonResult("2000", dateList);
    } catch (Exception e) {
      e.printStackTrace();
      return new JsonResult("5000", null);
    }
  }

  /**
   * 验证名称是否存在
   *
   * @param id
   * @param groupName
   * @param name
   * @return
   */
  @RequestMapping(value = "/check_name")
  @ResponseBody
  public Boolean check_name(String id, String groupName, String name) {
    if (StringUtil.isEmpty(groupName, name)) {
      throw new BusinessException(Message.M4003);
    }
    STimetask task = new STimetask();
    task.setId(id);
    task.setGroupName(groupName);
    task.setName(name);
    STimetask queryTask = stimetaskService.checkName(task);
    if (queryTask != null) {
      logger.debug("组.任务名 exists,return false");
      return false;
    } else {
      logger.debug("组.任务名 not exists,return true");
      return true;
    }
  }

  /**
   * 保存
   *
   * @return
   */
  @RequestMapping(value = "/task_save")
  @ResponseBody
  public JsonResult userSave(STimetask task, HttpSession session) {
    //获取系统操作人员
    String longName = "admin";
    task.setModifyUserId(longName);
    try {
      int ret = stimetaskService.insertOrUpdateByUser(task, longName);
      if (ret > 0) {
        return new JsonResult("2000", task);
      } else {
        return new JsonResult("5000");
      }
    } catch (BusinessException e) {
      return new JsonResult("5001", e.getMessage(), null);
    }
  }

}