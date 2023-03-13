package natsufumij.common.bean;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

@Data
public class EntityM {
    private Date createTime;
    private Date updateTime;
    private Long creator;
    private Long updater;
}
