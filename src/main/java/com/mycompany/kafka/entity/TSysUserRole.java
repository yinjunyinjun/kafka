package com.mycompany.kafka.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author 尹君
 * @since 2021-12-28
 */
@TableName("T_SYS_USER_ROLE")
public class TSysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */

    @TableField("USER_ID")
    private String userId;

    /**
     * 角色id
     */
    @TableField("ROLE_ID")
    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "TSysUserRole{" +
            "userId=" + userId +
            ", roleId=" + roleId +
        "}";
    }
}
