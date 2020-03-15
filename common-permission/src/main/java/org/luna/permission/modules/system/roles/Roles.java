package org.luna.permission.modules.system.roles;

/**
* @类说明: 用户角色关联--实体类
* @author: 唐植超
* @date : 2020-03-09 22:33:12
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Roles {

    //数据库中的字段
        private Long userId ;//  用户ID
        private Long roleId ;//  角色ID
    
    //此处可添加查询显示辅助字段

}