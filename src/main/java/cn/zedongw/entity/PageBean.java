package cn.zedongw.entity;

import java.util.List;

/**
 * @Author ZeDongW
 * @ClassName PageBean
 * @Description 分页实体类
 * @Version 1.0
 * @date ：Created in 2019/6/20 0020 8:29
 * @modified By：
 */

public class PageBean<T> {

    private int currPage = 1; //当前页 默认为1

    private int pageCount = 5;  //每页显示记录数  默认为5

    private int totalCount; //查询总记录数

    private int totalPage; //总页数

    private List<T> pageData; //分页查询到的数据

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage() {
        if (totalCount % pageCount == 0){
            this.totalPage = totalCount/pageCount;
        } else {
            this.totalPage = totalCount/pageCount + 1;
        }
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public PageBean(int currPage, int pageCount, int totalCount, int totalPage, List<T> pageData) {
        this.currPage = currPage;
        this.pageCount = pageCount;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.pageData = pageData;
    }

    public PageBean() {
    }

}
