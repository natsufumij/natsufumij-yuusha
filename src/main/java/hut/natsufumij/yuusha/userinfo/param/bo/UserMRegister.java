package hut.natsufumij.yuusha.userinfo.param.bo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class UserMRegister {
    @Email(message = "邮箱格式错误")
    private String email;
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "昵称不能为空")
    private String nickName;
    @NotBlank
    @Length(max = 30,message = "密码最多30位字")
    private String password;
    private Byte sex;
    @Past(message = "生日必须是过去的")
    private Date birthday;
    private String moto;
    private String address;
}
