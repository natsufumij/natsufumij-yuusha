package hut.natsufumij.common.resp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;

import java.util.List;

@Getter
public class PageV<T> {
    private final List<T> data;
    private final long totalItems;
    private final long totalPages;
    private final long pageSize;
    private final long pageIndex;
    public PageV(List<T> data){
        this.data=data;
        this.totalItems=data.size();
        this.totalPages=1;
        this.pageSize=data.size();
        this.pageIndex=1;
    }
    public PageV(IPage<T> page){
        this.data=page.getRecords();
        this.pageIndex=page.getCurrent();
        this.pageSize=page.getSize();
        this.totalPages=page.getPages();
        this.totalItems=page.getTotal();
    }
}
