package com.itratel.model;

import java.util.List;

/***
 * <p>封装的分页对象</p>
 * @author yinhao
 * @date 2019/12/17
 * @param <T>
 */
public class PageInfo<T> {
    /***
     * 每页显示多少条记录
     */
    private int pageSize;
    /***
     * 当前是第几页数据
     */
    private int curPage;
    /***
     * 一共多少条记录
     */
    private int total;
    /***
     * 总页数
     */
    private int totalPage;
    /***
     * 要显示的数据
     */
    private List<T> dataList;

    public PageInfo() {
    }

    public PageInfo(int pageSize, int curPage, int total, int totalPage, List<T> dataList) {
        this.pageSize = pageSize;
        this.curPage = curPage;
        this.total = total;
        this.totalPage = totalPage;
        this.dataList = dataList;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
