package natsufumij.yuusha.userinfo.param.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import hut.natsufumij.yuusha.userinfo.enums.UserSex;
import hut.natsufumij.yuusha.userinfo.enums.UserState;
import lombok.Data;

import java.util.Date;

/**
 * 用户信息详情
 */
@Data
public class UserInfoSelfV {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String userName;
    private String nickName;
    private UserSex sex;
    private Date birthday;
    private String moto;
    private String address;
    private String phone;
    private String email;
    private UserState userState;
    private String avatar;
}
