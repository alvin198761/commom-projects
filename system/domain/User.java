package org.luna.permission.modules.system.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2018-11-22
 */
@Getter
@Setter
public class User implements Serializable {

    @NotNull(groups = Update.class)
    private Long id;

    @NotBlank
    private String username;

    /** 用户昵称 */
    @NotBlank
    private String nickName;

    /** 性别 */
    private String sex;

    private UserAvatar userAvatar;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phone;

    @NotNull
    private Boolean enabled;

    private String password;

    private Timestamp createTime;

    private Date lastPasswordResetTime;

    private Set<Role> roles;

    private Job job;

    private Dept dept;

    public @interface Update {}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}