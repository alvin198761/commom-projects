package org.luna.permission.modules.system.job;

/**
* 类说明: 岗位--查询条件实体类
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@io.swagger.annotations.ApiModel(value = "JobCond", description = "岗位--查询条件实体类")
public class JobCond extends org.alvin.code.gen.beans.BaseCondition {


    /**
    * 方法说明: 拼加自定义条件
    **/
    @Override
    public void addCondition() {
                    add(this.id , " AND t.id = ? " );
                            add(this.name , " AND t.name LIKE ? " ,3);
		                    add(this.enabled , " AND t.enabled = ? " );
                            add(this.sort , " AND t.sort = ? " );
                            add(this.deptId , " AND t.dept_id = ? " );
                    		add(this.createTime , " AND t.create_time = ? " );
		if(this.createTimeStart != null){
			add(org.alvin.utils.DateUtil.setStart(this.createTimeStart ), " AND t.create_time >= ? "); //创建日期开始
		}
		if(this.createTimeStart != null){
			add(org.alvin.utils.DateUtil.setEnd(this.createTimeEnd), " AND t.create_time <= ? "); //  创建日期结束
		}
                }

    //属性
    	@io.swagger.annotations.ApiModelProperty(value = "ID", dataType = "java.lang.Long")
    private  Long  id ;//  ID
		    	@io.swagger.annotations.ApiModelProperty(value = "岗位名称", dataType = "java.lang.String")
    private  String  name ;//  岗位名称
		    	@io.swagger.annotations.ApiModelProperty(value = "岗位状态", dataType = "java.lang.Boolean")
    private  Boolean  enabled ;//  岗位状态
		    	@io.swagger.annotations.ApiModelProperty(value = "岗位排序", dataType = "java.lang.Long")
    private  Long  sort ;//  岗位排序
		    	@io.swagger.annotations.ApiModelProperty(value = "部门ID", dataType = "java.lang.Long")
    private  Long  deptId ;//  部门ID
		    	@io.swagger.annotations.ApiModelProperty(value = "创建日期", dataType = "java.util.Date")
    private  java.util.Date  createTime ;//  创建日期
					//日期查询范围
			@io.swagger.annotations.ApiModelProperty(value = "创建日期开始", dataType = "java.util.Date")
			private  java.util.Date  createTimeStart ;//  创建日期开始
			@io.swagger.annotations.ApiModelProperty(value = "创建日期结束", dataType = "java.util.Date")
			private  java.util.Date  createTimeEnd ;//  创建日期结束
		    	//其他常用条件字段
	@io.swagger.annotations.ApiModelProperty(value = "ID", dataType = "java.lang.List")
    private java.util.List<Long> idList;// 主键列表

}