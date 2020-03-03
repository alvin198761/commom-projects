package org.luna.permission.modules.system.dept;

import java.util.List;

/**
 * @类说明: 部门--实体类
 * @author: 唐植超
 * @date : 2020-03-01 10:01:39
 **/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Dept {

    //数据库中的字段
    private Long id;//  ID
    private String name;//  名称
    private Long pid;//  上级部门
    private Boolean enabled;//  状态
    private java.util.Date createTime;//  创建日期

    //此处可添加查询显示辅助字段
    private List<Dept> children;

}