package hut.natsufumij.util.bean;

import com.github.pagehelper.PageHelper;
import lombok.Data;

@Data
public class PageableModel {
    private Integer pageNum;
    private Integer pageSize;

    public void startPage() {
        int pNum = pageNum == null ? 1 : pageNum;
        int pSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pNum, pSize);
    }
}
