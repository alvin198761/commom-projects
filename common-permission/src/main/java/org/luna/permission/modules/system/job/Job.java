package org.luna.permission.modules.system.job;

/**
* @类说明: 岗位--实体类
* @author: 唐植超
* @date : 2020-03-01 10:01:39
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Job {

    //数据库中的字段
        private Long id ;//  ID
        private String name ;//  岗位名称
        private Boolean enabled ;//  岗位状态
        private Long sort ;//  岗位排序
        private Long deptId ;//  部门ID
        private java.util.Date createTime ;//  创建日期
    
    //此处可添加查询显示辅助字段

}