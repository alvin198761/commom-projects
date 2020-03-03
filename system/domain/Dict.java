package org.luna.permission.modules.system.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@Getter
@Setter
public class Dict implements Serializable {


    @NotNull(groups = Update.class)
    private Long id;

    @NotBlank
    private String name;

    private String remark;

    private Timestamp createTime;

    private List<DictDetail> dictDetails;

    public @interface Update {}
}