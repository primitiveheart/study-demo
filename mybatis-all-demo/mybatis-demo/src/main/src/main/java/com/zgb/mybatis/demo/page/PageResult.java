package com.zgb.mybatis.demo.page;

import java.util.List;

/**
 * 分页数据
 * 
 */
public class PageResult<T> {

    /**
     * 页码，从1开始
     */
    private int pageNum;
    /**
     * 页面大小
     */
    private int pageSize;
    /**
     * 总数
     */
    private long total;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 数据
     */
    private List<T> list;

    /**
     * 构造函数
     */
    public PageResult() {

    }

    /**
     * 构造函数
     * 
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @param total 总数
     * @param pages 总页数
     * @param list 数据
     */
    public PageResult(int pageNum, int pageSize, long total, int pages) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
