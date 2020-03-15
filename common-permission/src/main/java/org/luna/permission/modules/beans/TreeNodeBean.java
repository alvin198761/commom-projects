package org.luna.permission.modules.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class TreeNodeBean extends SelectOptionBean {

    private Long pid;
    private List<TreeNodeBean> children;
    private Boolean hasChildren;
}
