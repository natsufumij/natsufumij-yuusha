package hut.natsufumij.common.bean;

import lombok.Data;

import java.util.Date;

@Data
public class EntityM {
    private Date createTime;
    private Date updateTime;
    private Long creator;
    private Long updater;
}
