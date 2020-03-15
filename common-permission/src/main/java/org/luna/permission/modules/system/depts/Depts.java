package org.luna.permission.modules.system.depts;

/**
* @类说明: 角色部门关联--实体类
* @author: 唐植超
* @date : 2020-03-09 22:33:12
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Depts {

    //数据库中的字段
        private Long roleId ;//  role_id
        private Long deptId ;//  dept_id
    
    //此处可添加查询显示辅助字段

}