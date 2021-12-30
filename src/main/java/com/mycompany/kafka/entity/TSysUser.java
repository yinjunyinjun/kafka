package com.mycompany.kafka.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 尹君
 * @since 2021-12-28
 */
@TableName("T_SYS_USER")
public class TSysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
  //  @TableField("ID")
    private String id;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 性别
     */
    @TableField("GENDER")
    private String gender;

    /**
     * 编号
     */
    @TableField("USER_NO")
    private String userNo;

    /**
     * 登录密码
     */
    @TableField("LOGIN_PASSWORD")
    private String loginPassword;

    /**
     * 出生年月
     */
    @TableField("BIRTH_DAY")
    private String birthDay;

    /**
     * 联系方式
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 家庭住址
     */
    @TableField("ADDR")
    private String addr;

    /**
     * 入职时间
     */
    @TableField("WORK_TIME")
    private String workTime;

    /**
     * 民族
     */
    @TableField("NATION")
    private String nation;

    /**
     * 身份证号
     */
    @TableField("ID_CARD")
    private String idCard;

    /**
     * 部门id
     */
    @TableField("DEPT_ID")
    private String deptId;

    /**
     * 组织id
     */
    @TableField("ORG_ID")
    private String orgId;

    /**
     * 状态
     */
    @TableField("STATE")
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TSysUser{" +
            "id=" + id +
            ", name=" + name +
            ", gender=" + gender +
            ", userNo=" + userNo +
            ", loginPassword=" + loginPassword +
            ", birthDay=" + birthDay +
            ", phone=" + phone +
            ", addr=" + addr +
            ", workTime=" + workTime +
            ", nation=" + nation +
            ", idCard=" + idCard +
            ", deptId=" + deptId +
            ", orgId=" + orgId +
            ", state=" + state +
        "}";
    }
}
