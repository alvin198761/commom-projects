package org.luna.permission.modules.system.user;

/**
* @类说明: 系统用户--实体类
* @author: 唐植超
* @date : 2020-03-09 22:33:12
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class User {

    //数据库中的字段
        private Long id ;//  ID
        private Long avatarId ;//  头像
        private String email ;//  邮箱
        private Long enabled ;//  状态：1启用、0禁用
        private String password ;//  密码
        private String username ;//  用户名
        private Long deptId ;//  部门名称
        private String phone ;//  手机号码
        private Long jobId ;//  岗位名称
        private java.util.Date createTime ;//  创建日期
        private java.util.Date lastPasswordResetTime ;//  最后修改密码的日期
        private String nickName ;//  nick_name
        private String sex ;//  sex
    
    //此处可添加查询显示辅助字段

}