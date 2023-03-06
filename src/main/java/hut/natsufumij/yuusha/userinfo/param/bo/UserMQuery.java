package hut.natsufumij.yuusha.userinfo.param.bo;

import hut.natsufumij.yuusha.util.bean.QueryMBase;

/**
 * 查询参数业务数据类
 */
public class UserMQuery extends QueryMBase {

    private String userName;
    private String nickName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
