package com.yinhao.model;

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
    private long total;
    /***
     * 总页数
     */
    private long totalPage;
    /***
     * 要显示的数据
     */
    private List<T> dataList;

    public int getPageSize() {
        return pageSize;
    }

    public PageInfo<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getCurPage() {
        return curPage;
    }

    public PageInfo<T> setCurPage(int curPage) {
        this.curPage = curPage;
        return this;
    }

    public long getTotal() {
        return total;
    }

    public PageInfo<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public PageInfo<T> setTotalPage(long totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public PageInfo<T> setDataList(List<T> dataList) {
        this.dataList = dataList;
        return this;
    }
}
