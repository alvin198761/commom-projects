package org.luna.permission.modules.system.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author Zheng Jie
* @date 2019-03-29
*/
@Getter
@Setter
public class Job implements Serializable {

    @NotNull(groups = Update.class)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private Long sort;

    @NotNull
    private Boolean enabled;

    private Dept dept;

    private Timestamp createTime;

    public @interface Update {}
}