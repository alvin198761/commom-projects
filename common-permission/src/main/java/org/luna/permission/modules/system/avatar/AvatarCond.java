package org.luna.permission.modules.system.avatar;

/**
* 类说明: 系统用户头像--查询条件实体类
* @author 唐植超
* 生成日期 2020-03-15 17:28:25
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@io.swagger.annotations.ApiModel(value = "AvatarCond", description = "系统用户头像--查询条件实体类")
public class AvatarCond extends org.alvin.code.gen.beans.BaseCondition {


    /**
    * 方法说明: 拼加自定义条件
    **/
    @Override
    public void addCondition() {
                    add(this.id , " AND t.id = ? " );
                            add(this.realName , " AND t.real_name LIKE ? " ,3);
		                    add(this.path , " AND t.path LIKE ? " ,3);
		                    add(this.fileSize , " AND t.file_size LIKE ? " ,3);
		            		add(this.createTime , " AND t.create_time = ? " );
		if(this.createTimeStart != null){
			add(org.alvin.utils.DateUtil.setStart(this.createTimeStart ), " AND t.create_time >= ? "); //创建时间开始
		}
		if(this.createTimeStart != null){
			add(org.alvin.utils.DateUtil.setEnd(this.createTimeEnd), " AND t.create_time <= ? "); //  创建时间结束
		}
                }

    //属性
    	@io.swagger.annotations.ApiModelProperty(value = "id", dataType = "java.lang.Long")
    private  Long  id ;//  id
		    	@io.swagger.annotations.ApiModelProperty(value = "真实文件名", dataType = "java.lang.String")
    private  String  realName ;//  真实文件名
		    	@io.swagger.annotations.ApiModelProperty(value = "路径", dataType = "java.lang.String")
    private  String  path ;//  路径
		    	@io.swagger.annotations.ApiModelProperty(value = "大小", dataType = "java.lang.String")
    private  String  fileSize ;//  大小
		    	@io.swagger.annotations.ApiModelProperty(value = "创建时间", dataType = "java.util.Date")
    private  java.util.Date  createTime ;//  创建时间
					//日期查询范围
			@io.swagger.annotations.ApiModelProperty(value = "创建时间开始", dataType = "java.util.Date")
			private  java.util.Date  createTimeStart ;//  创建时间开始
			@io.swagger.annotations.ApiModelProperty(value = "创建时间结束", dataType = "java.util.Date")
			private  java.util.Date  createTimeEnd ;//  创建时间结束
		    	//其他常用条件字段
	@io.swagger.annotations.ApiModelProperty(value = "id", dataType = "java.lang.List")
    private java.util.List<Long> idList;// 主键列表

}