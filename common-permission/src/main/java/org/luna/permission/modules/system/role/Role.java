package org.luna.permission.modules.system.role;

/**
* @类说明: 角色表--实体类
* @author: 唐植超
* @date : 2020-03-09 22:33:12
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Role {

    //数据库中的字段
        private Long id ;//  ID
        private String name ;//  名称
        private String remark ;//  备注
        private String dataScope ;//  数据权限
        private Integer level ;//  角色级别
        private java.util.Date createTime ;//  创建日期
        private String permission ;//  功能权限
    
    //此处可添加查询显示辅助字段

}