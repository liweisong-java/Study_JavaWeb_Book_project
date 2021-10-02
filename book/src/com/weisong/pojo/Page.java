package com.weisong.pojo;

import java.util.List;

/**
 * page是分页的模型对象
 * <T> 是具体的模块的javaBean类
 * @author 李伟松
 * @create 2021-10-02-14:47
 */
public class Page {

    public static final Integer PAGE_SIZE = 4;

    //当前页码
    private Integer pageNo;
    //总页码
    private Integer pageTotal;
    //当前页显示数量
    private Integer pageSize = PAGE_SIZE;
    //总记录数
    private Integer PageTotalCount;
    //当前页数据
    private List<Book> items;

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        PageTotalCount = pageTotalCount;
    }

    public void setItems(List<Book> items) {
        this.items = items;
    }

    public static Integer getPageSize() {
        return PAGE_SIZE;
    }

    public Integer getPageTotalCount() {
        return PageTotalCount;
    }

    public List<Book> getItems() {
        return items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", PageTotalCount=" + PageTotalCount +
                ", items=" + items +
                '}';
    }
}
