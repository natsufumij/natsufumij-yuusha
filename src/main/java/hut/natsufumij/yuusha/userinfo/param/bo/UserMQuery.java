package hut.natsufumij.yuusha.userinfo.param.bo;

import hut.natsufumij.common.bean.QueryMBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserMQuery extends QueryMBase {
    private String userName;
    private String nickName;
}
