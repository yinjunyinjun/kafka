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
@TableName("T_SYS_MENU_REL")
public class TSysMenuRel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
    @TableId
  //  @TableField("MENU_ID")
    private String menuId;

    /**
     * 对象id
     */
    @TableField("OBJ_ID")
    private String objId;

    /**
     * 对象类型：用户  角色   机构
     */
    @TableField("OBJ_TYPE")
    private String objType;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }
    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    @Override
    public String toString() {
        return "TSysMenuRel{" +
            "menuId=" + menuId +
            ", objId=" + objId +
            ", objType=" + objType +
        "}";
    }
}
