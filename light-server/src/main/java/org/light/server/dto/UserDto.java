package org.light.server.dto;

import org.light.server.entity.SysUser;
import org.light.server.enums.ThirdTypeEnum;
import org.light.server.enums.UserEnableEnum;
import org.light.server.enums.UserTypeEnum;

/**
 * 传输对象 - 用户信息
 */
public class UserDto {
    /**
     * 用户ID
     */
    private String id;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 用户类型 - 中文
     */
    private String userTypeNm;

    /**
     * 三方ID
     */
    private String thirdId;

    /**
     * 三方类型
     */
    private String thirdType;

    /**
     * 三方类型 - 中文
     */
    private String thirdTypeNm;

    /**
     * 用户状态
     */
    private Integer enable;

    /**
     * 用户状态 - 中文
     */
    private String enableNm;

    public UserDto() {
    }
    public UserDto(SysUser data) {
        this.id = data.getId().toString();
        this.nickName = data.getNickName();
        this.userType = data.getUserType();
        this.userTypeNm = UserTypeEnum.format(data.getUserType());
        this.thirdId = data.getThirdId();
        this.thirdType = data.getThirdType();
        this.thirdTypeNm = ThirdTypeEnum.format(data.getThirdType());
        this.enable = data.getEnable();
        this.enableNm = UserEnableEnum.format(data.getEnable());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserTypeNm() {
        return userTypeNm;
    }

    public void setUserTypeNm(String userTypeNm) {
        this.userTypeNm = userTypeNm;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public String getThirdType() {
        return thirdType;
    }

    public void setThirdType(String thirdType) {
        this.thirdType = thirdType;
    }

    public String getThirdTypeNm() {
        return thirdTypeNm;
    }

    public void setThirdTypeNm(String thirdTypeNm) {
        this.thirdTypeNm = thirdTypeNm;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getEnableNm() {
        return enableNm;
    }

    public void setEnableNm(String enableNm) {
        this.enableNm = enableNm;
    }
}
