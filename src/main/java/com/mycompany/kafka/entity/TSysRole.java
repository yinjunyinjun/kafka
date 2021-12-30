package com.mycompany.kafka.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("T_SYS_ROLE")
public class TSysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @TableId
 //   @TableField("ID")
    private String id;

    /**
     * 角色名称
     */
    @TableField("ROLE_NAME")
    private String roleName;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TSysRole{" +
            "id=" + id +
            ", roleName=" + roleName +
            ", remark=" + remark +
        "}";
    }
}
