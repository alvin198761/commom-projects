package org.luna.permission.modules.system.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Zheng Jie
 * @date 2019年9月7日 16:16:59
 */
@Getter
@Setter
@NoArgsConstructor
public class UserAvatar implements Serializable {

    private Long id;

    private String realName;

    private String path;

    private String size;

    private Timestamp createTime;

    public UserAvatar(UserAvatar userAvatar, String realName, String path, String size) {
        this.id = userAvatar.getId();
        this.realName = realName;
        this.path = path;
        this.size = size;
    }
}
