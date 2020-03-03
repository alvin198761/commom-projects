package org.luna.permission.modules.system.avatar;

/**
* @类说明: 系统用户头像--实体类
* @author: 唐植超
* @date : 2020-03-01 10:01:39
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Avatar {

    //数据库中的字段
        private Long id ;//  id
        private String realName ;//  真实文件名
        private String path ;//  路径
        private String size ;//  大小
        private java.util.Date createTime ;//  创建时间
    
    //此处可添加查询显示辅助字段

}