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
@TableName("T_SYS_ORGANIZATION")
public class TSysOrganization implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织id
     */
    @TableId
  //  @TableField("ID")
    private String id;

    /**
     * 组织机构名称
     */
    @TableField("ORG_NAME")
    private String orgName;

    /**
     * 地址
     */
    @TableField("ADDR")
    private String addr;

    /**
     * 主管id
     */
    @TableField("PIC_ID")
    private String picId;

    /**
     * 排序号
     */
    @TableField("SORT_NUM")
    private BigDecimal sortNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }
    public BigDecimal getSortNum() {
        return sortNum;
    }

    public void setSortNum(BigDecimal sortNum) {
        this.sortNum = sortNum;
    }

    @Override
    public String toString() {
        return "TSysOrganization{" +
            "id=" + id +
            ", orgName=" + orgName +
            ", addr=" + addr +
            ", picId=" + picId +
            ", sortNum=" + sortNum +
        "}";
    }
}
