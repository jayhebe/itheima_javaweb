package cn.mycloudway.pojo;

import java.util.List;

public class PageBean<T> {
    private int totalCount;
    private List<T> rows;

    public PageBean(int totalCount, List<T> rows) {
        this.totalCount = totalCount;
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
