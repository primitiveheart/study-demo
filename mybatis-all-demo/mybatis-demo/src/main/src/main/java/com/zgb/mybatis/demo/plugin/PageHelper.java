package com.zgb.mybatis.demo.plugin;

@SuppressWarnings("rawtypes")
public class PageHelper {


    private static final ThreadLocal<Page> PAGE_THREADLOCAL = new ThreadLocal<Page>();

    /**
     * 设置线程局部变量分页信息
     * 
     * @param page
     */
    public static void setPageThreadLocal(Page page) {
      PAGE_THREADLOCAL.set(page);
    }

    /**
     * 获取线程局部变量分页信息
     * 
     * @return
     */
    public static Page getPageThreadLocal() {
        return PAGE_THREADLOCAL.get();
    }

    /**
     * 清空线程局部变量分页信息
     */
    public static void pageThreadLocalClear() {
      PAGE_THREADLOCAL.remove();
    }

    /**
     * 设置分页参数
     * 
     * @param pageNum
     * @param pageSize
     */
    public static void startPage(Integer pageNum, Integer pageSize) {
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        setPageThreadLocal(page);
    }

}