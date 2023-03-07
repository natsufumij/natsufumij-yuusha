package hut.natsufumij.yuusha.social.entity;

import java.util.Date;

public class YSocialMember {
    private Long id;

    private Long userId;

    private String nickName;

    private Byte role;

    private Date createTime;

    private Date updateTime;

    private String shogo;

    private String info;

    private Date registerTime;

    private Byte memeberState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getShogo() {
        return shogo;
    }

    public void setShogo(String shogo) {
        this.shogo = shogo == null ? null : shogo.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Byte getMemeberState() {
        return memeberState;
    }

    public void setMemeberState(Byte memeberState) {
        this.memeberState = memeberState;
    }
}