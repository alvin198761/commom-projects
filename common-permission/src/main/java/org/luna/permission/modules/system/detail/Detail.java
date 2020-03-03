package org.luna.permission.modules.system.detail;

/**
* @类说明: 数据字典详情--实体类
* @author: 唐植超
* @date : 2020-03-01 10:01:39
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Detail {

    //数据库中的字段
        private Long id ;//  id
        private String label ;//  字典标签
        private String value ;//  字典值
        private String sort ;//  排序
        private Long dictId ;//  字典id
        private java.util.Date createTime ;//  创建日期
    
    //此处可添加查询显示辅助字段

}