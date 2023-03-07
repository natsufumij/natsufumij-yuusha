package hut.natsufumij.yuusha.social.entity;

import java.util.Date;

public class YSocialInfo {
    private Long id;

    private String name;

    private Long manageId;

    private String moto;

    private Date createTime;

    private Long creator;

    private Date updateTime;

    private Long updater;

    private Byte socialState;

    private String avatar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getManageId() {
        return manageId;
    }

    public void setManageId(Long manageId) {
        this.manageId = manageId;
    }

    public String getMoto() {
        return moto;
    }

    public void setMoto(String moto) {
        this.moto = moto == null ? null : moto.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    public Byte getSocialState() {
        return socialState;
    }

    public void setSocialState(Byte socialState) {
        this.socialState = socialState;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }
}