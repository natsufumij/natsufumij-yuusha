package natsufumij.yuusha.userinfo.param.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import hut.natsufumij.yuusha.userinfo.enums.UserSex;
import lombok.Data;

@Data
public class UserV {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String userName;
    private String nickName;
    private UserSex sex;
    private String avatar;
}
