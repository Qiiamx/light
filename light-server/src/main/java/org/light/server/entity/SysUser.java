package org.light.server.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import com.mybatisflex.core.activerecord.Model;

import java.io.Serial;


/**
 * 系统用户 实体类。
 *
 * @author 63443
 * @since 2025-04-17
 */
@Table("sys_user")
public class SysUser extends Model<SysUser> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String nickName;

    private Integer userType;

    private String thirdId;

    private String thirdType;

    private Integer enable;

    public static SysUser create() {
        return new SysUser();
    }

    public Long getId() {
        return id;
    }

    public SysUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public SysUser setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public Integer getUserType() {
        return userType;
    }

    public SysUser setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }

    public String getThirdId() {
        return thirdId;
    }

    public SysUser setThirdId(String thirdId) {
        this.thirdId = thirdId;
        return this;
    }

    public String getThirdType() {
        return thirdType;
    }

    public SysUser setThirdType(String thirdType) {
        this.thirdType = thirdType;
        return this;
    }

    public Integer getEnable() {
        return enable;
    }

    public SysUser setEnable(Integer enable) {
        this.enable = enable;
        return this;
    }

}
