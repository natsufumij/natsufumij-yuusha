package hut.natsufumij.yuusha.userinfo.param.vo;

import lombok.Data;

import java.util.Date;

/**
 * 用户信息详情
 */
@Data
public class UserInfoSelfV {
    private Long id;
    private String userName;
    private String nickName;
    private Byte sex;
    private Date birthday;
    private String moto;
    private String address;
    private String phone;
    private String email;
    private Integer userState;
    private String avatar;
}
