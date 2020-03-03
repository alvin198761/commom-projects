package org.luna.permission.modules.system.menu;

/**
* @类说明: menu--实体类
* @author: 唐植超
* @date : 2020-03-01 10:01:39
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Menu {

    //数据库中的字段
        private Long id ;//  ID
        private Boolean iFrame ;//  是否外链
        private String name ;//  菜单名称
        private String component ;//  组件
        private Long pid ;//  上级菜单ID
        private Long sort ;//  排序
        private String icon ;//  图标
        private String path ;//  链接地址
        private Boolean cache ;//  缓存
        private Boolean hidden ;//  是否隐藏
        private String componentName ;//  组件名称
        private java.util.Date createTime ;//  创建日期
        private String permission ;//  权限
        private Integer type ;//  类型
    
    //此处可添加查询显示辅助字段

}