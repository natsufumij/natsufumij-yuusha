package hut.natsufumij.yuusha.social.param.bo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SocialMUpdate {
    @NotNull
    private Long id;
    @NotBlank
    @Length(max = 30)
    private String name;
    @Length(max = 255)
    private String moto;

    @Length(max = 255)
    private String avatar;
}
