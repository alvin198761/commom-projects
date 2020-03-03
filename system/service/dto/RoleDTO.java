package org.luna.permission.modules.system.service.dto;

import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Data
public class RoleDTO implements Serializable {

    private Long id;

    private String name;

    private String dataScope;

    private Integer level;

    private String remark;

    private String permission;

    private Set<MenuDTO> menus;

    private Set<DeptDTO> depts;

    private Timestamp createTime;
}
