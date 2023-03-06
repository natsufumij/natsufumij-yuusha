package hut.natsufumij.yuusha.userinfo.param.vo;

import lombok.Data;

import java.util.Date;

/**
 * 用户展示信息
 */
@Data
public class UserInfoV {
    private Long id;
    private String userName;
    private String nickName;
    private Byte sex;
    private Date birthday;
    private String moto;
    private String address;
    private String avatar;
}
