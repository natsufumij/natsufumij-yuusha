package old;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Integer total = 0;
    private List<T> items;
    private Integer totalPage = 0;

    public Page() {
        items = new ArrayList<>();
    }

    public Page(Integer pageNum, Integer pageSize) {
        items = new ArrayList<>();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void calcTotalPage() {
        if (pageSize != 0) {
            totalPage = (int) Math.ceil((double) total / (double) pageSize);
        } else {
            totalPage = 0;
        }
    }
}
