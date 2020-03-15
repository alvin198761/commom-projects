package org.luna.permission.modules.system.dict;

/**
* @类说明: 数据字典--实体类
* @author: 唐植超
* @date : 2020-03-09 22:33:12
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Dict {

    //数据库中的字段
        private Long id ;//  id
        private String name ;//  字典名称
        private String remark ;//  描述
        private java.util.Date createTime ;//  创建日期
    
    //此处可添加查询显示辅助字段

}