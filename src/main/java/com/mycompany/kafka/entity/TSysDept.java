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
@TableName("T_SYS_DEPT")
public class TSysDept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    @TableId
   // @TableField("ID")
    private String id;

    /**
     * 部门名称
     */
    @TableField("DEPT_NAME")
    private String deptName;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 主管id(用户id)
     */
    @TableField("PIC_ID")
    private String picId;

    /**
     * 机构id
     */
    @TableField("ORG_ID")
    private String orgId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "TSysDept{" +
            "id=" + id +
            ", deptName=" + deptName +
            ", remark=" + remark +
            ", picId=" + picId +
            ", orgId=" + orgId +
        "}";
    }
}
