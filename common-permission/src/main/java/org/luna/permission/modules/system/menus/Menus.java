package org.luna.permission.modules.system.menus;

/**
* @类说明: 角色菜单关联--实体类
* @author: 唐植超
* @date : 2020-03-01 10:01:39
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Menus {

    //数据库中的字段
        private Long menuId ;//  菜单ID
        private Long roleId ;//  角色ID
    
    //此处可添加查询显示辅助字段

}