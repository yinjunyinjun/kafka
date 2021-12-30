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
@TableName("T_SYS_SYSTEMPARM")
public class TSysSystemparm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
  //  @TableField("ID")
    private String id;

    /**
     * 参数名
     */
    @TableField("NAME")
    private String name;

    /**
     * 参数值
     */
    @TableField("VALUE")
    private String value;

    /**
     * 参数类型
     */
    @TableField("TYPE")
    private String type;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "TSysSystemparm{" +
            "id=" + id +
            ", name=" + name +
            ", value=" + value +
            ", type=" + type +
            ", parentId=" + parentId +
        "}";
    }
}
