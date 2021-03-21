
package com.zgb.mybatis.demo.page;

public class PageQuery {
    
    /**
     * 页码，从1开始
     */
    private Integer pageNum;
    /**
     * 页面大小
     */
    private Integer pageSize;
    /**
     * @return the pageNum
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * @param pageNum the pageNum to set
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * @return the pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
