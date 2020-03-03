package org.luna.permission.modules.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2018-12-17
 */
@Getter
@Setter
public class Menu implements Serializable {

    @NotNull(groups = {Update.class})
    private Long id;

    @NotBlank
    private String name;

    private Long sort = 999L;

    private String path;

    private String component;

    /** 类型，目录、菜单、按钮 */
    private Integer type;

    /** 权限 */
    private String permission;

    private String componentName;

    private String icon;

    private Boolean cache;

    private Boolean hidden;

    /** 上级菜单ID */
    private Long pid;

    /** 是否为外链 true/false */
    private Boolean iFrame;

    @JsonIgnore
    private Set<Role> roles;

    private Timestamp createTime;

    public @interface Update {}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
