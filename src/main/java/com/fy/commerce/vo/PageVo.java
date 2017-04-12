package com.fy.commerce.vo;

import java.io.Serializable;

/**
 * Created by dell-pc on 2017/4/12.
 */
public class PageVo implements Serializable {

    private int currentPage;
    private int startPage;
    private int totalPage;
    private int pageSize;
    private int nextPage;
    private int previousPage;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int preciousPage) {
        this.previousPage = preciousPage;
    }
}
