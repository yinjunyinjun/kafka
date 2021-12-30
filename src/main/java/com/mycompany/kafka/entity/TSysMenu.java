package com.mycompany.kafka.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author 尹君
 * @since 2021-12-28
 */
@TableName("T_SYS_MENU")
public class TSysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
    @TableId
   // @TableField("ID")
    private String id;

    /**
     * 菜单名称
     */
    @TableField("MENU_NAME")
    private String menuName;

    /**
     * 菜单路径
     */
    @TableField("MENU_URL")
    private String menuUrl;

    /**
     * 菜单类型
     */
    @TableField("MENU_TYPE")
    private String menuType;

    /**
     * 图标
     */
    @TableField("MENU_ICON")
    private String menuIcon;

    /**
     * 排列号
     */
    @TableField("ORDER_NUM")
    private Integer orderNum;

    /**
     * 父节点id
     */
    @TableField("PARENT_ID")
    private String parentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }
    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "TSysMenu{" +
            "id=" + id +
            ", menuName=" + menuName +
            ", menuUrl=" + menuUrl +
            ", menuType=" + menuType +
            ", menuIcon=" + menuIcon +
            ", orderNum=" + orderNum +
            ", parentId=" + parentId +
        "}";
    }
}
