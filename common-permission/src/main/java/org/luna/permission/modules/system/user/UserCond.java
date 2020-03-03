package org.luna.permission.modules.system.user;

/**
* 类说明: 系统用户--查询条件实体类
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@io.swagger.annotations.ApiModel(value = "UserCond", description = "系统用户--查询条件实体类")
public class UserCond extends org.alvin.code.gen.beans.BaseCondition {


    /**
    * 方法说明: 拼加自定义条件
    **/
    @Override
    public void addCondition() {
                    add(this.id , " AND t.id = ? " );
                            add(this.avatarId , " AND t.avatar_id = ? " );
                            add(this.email , " AND t.email LIKE ? " ,3);
		                    add(this.enabled , " AND t.enabled = ? " );
                            add(this.password , " AND t.password LIKE ? " ,3);
		                    add(this.username , " AND t.username LIKE ? " ,3);
		                    add(this.deptId , " AND t.dept_id = ? " );
                            add(this.phone , " AND t.phone LIKE ? " ,3);
		                    add(this.jobId , " AND t.job_id = ? " );
                    		add(this.createTime , " AND t.create_time = ? " );
		if(this.createTimeStart != null){
			add(org.alvin.utils.DateUtil.setStart(this.createTimeStart ), " AND t.create_time >= ? "); //创建日期开始
		}
		if(this.createTimeStart != null){
			add(org.alvin.utils.DateUtil.setEnd(this.createTimeEnd), " AND t.create_time <= ? "); //  创建日期结束
		}
                    		add(this.lastPasswordResetTime , " AND t.last_password_reset_time = ? " );
		if(this.lastPasswordResetTimeStart != null){
			add(org.alvin.utils.DateUtil.setStart(this.lastPasswordResetTimeStart ), " AND t.last_password_reset_time >= ? "); //最后修改密码的日期开始
		}
		if(this.lastPasswordResetTimeStart != null){
			add(org.alvin.utils.DateUtil.setEnd(this.lastPasswordResetTimeEnd), " AND t.last_password_reset_time <= ? "); //  最后修改密码的日期结束
		}
                            add(this.nickName , " AND t.nick_name LIKE ? " ,3);
		                    add(this.sex , " AND t.sex LIKE ? " ,3);
		        }

    //属性
    	@io.swagger.annotations.ApiModelProperty(value = "ID", dataType = "java.lang.Long")
    private  Long  id ;//  ID
		    	@io.swagger.annotations.ApiModelProperty(value = "头像", dataType = "java.lang.Long")
    private  Long  avatarId ;//  头像
		    	@io.swagger.annotations.ApiModelProperty(value = "邮箱", dataType = "java.lang.String")
    private  String  email ;//  邮箱
		    	@io.swagger.annotations.ApiModelProperty(value = "状态：1启用、0禁用", dataType = "java.lang.Long")
    private  Long  enabled ;//  状态：1启用、0禁用
		    	@io.swagger.annotations.ApiModelProperty(value = "密码", dataType = "java.lang.String")
    private  String  password ;//  密码
		    	@io.swagger.annotations.ApiModelProperty(value = "用户名", dataType = "java.lang.String")
    private  String  username ;//  用户名
		    	@io.swagger.annotations.ApiModelProperty(value = "部门名称", dataType = "java.lang.Long")
    private  Long  deptId ;//  部门名称
		    	@io.swagger.annotations.ApiModelProperty(value = "手机号码", dataType = "java.lang.String")
    private  String  phone ;//  手机号码
		    	@io.swagger.annotations.ApiModelProperty(value = "岗位名称", dataType = "java.lang.Long")
    private  Long  jobId ;//  岗位名称
		    	@io.swagger.annotations.ApiModelProperty(value = "创建日期", dataType = "java.util.Date")
    private  java.util.Date  createTime ;//  创建日期
					//日期查询范围
			@io.swagger.annotations.ApiModelProperty(value = "创建日期开始", dataType = "java.util.Date")
			private  java.util.Date  createTimeStart ;//  创建日期开始
			@io.swagger.annotations.ApiModelProperty(value = "创建日期结束", dataType = "java.util.Date")
			private  java.util.Date  createTimeEnd ;//  创建日期结束
		    	@io.swagger.annotations.ApiModelProperty(value = "最后修改密码的日期", dataType = "java.util.Date")
    private  java.util.Date  lastPasswordResetTime ;//  最后修改密码的日期
					//日期查询范围
			@io.swagger.annotations.ApiModelProperty(value = "最后修改密码的日期开始", dataType = "java.util.Date")
			private  java.util.Date  lastPasswordResetTimeStart ;//  最后修改密码的日期开始
			@io.swagger.annotations.ApiModelProperty(value = "最后修改密码的日期结束", dataType = "java.util.Date")
			private  java.util.Date  lastPasswordResetTimeEnd ;//  最后修改密码的日期结束
		    	@io.swagger.annotations.ApiModelProperty(value = "nick_name", dataType = "java.lang.String")
    private  String  nickName ;//  nick_name
		    	@io.swagger.annotations.ApiModelProperty(value = "sex", dataType = "java.lang.String")
    private  String  sex ;//  sex
		    	//其他常用条件字段
	@io.swagger.annotations.ApiModelProperty(value = "ID", dataType = "java.lang.List")
    private java.util.List<Long> idList;// 主键列表

}