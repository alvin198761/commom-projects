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
 * 角色
 * @author Zheng Jie
 * @date 2018-11-22
 */
@Getter
@Setter
public class Role implements Serializable {

    @NotNull(groups = {Update.class})
    private Long id;

    @NotBlank
    private String name;

    /** 数据权限类型 全部 、 本级 、 自定义 */
    private String dataScope = "本级";

    /** 数值越小，级别越大 */
    private Integer level = 3;

    private String remark;

    /** 权限 */
    private String permission;

    @JsonIgnore
    private Set<User> users;

    private Set<Menu> menus;

    private Set<Dept> depts;

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
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
