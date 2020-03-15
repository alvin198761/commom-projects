package org.luna.permission.modules.system.dept;

/**
* 类说明: 部门--查询条件实体类
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@io.swagger.annotations.ApiModel(value = "DeptCond", description = "部门--查询条件实体类")
public class DeptCond extends org.alvin.code.gen.beans.BaseCondition {


    /**
    * 方法说明: 拼加自定义条件
    **/
    @Override
    public void addCondition() {
                    add(this.id , " AND t.id = ? " );
                            add(this.name , " AND t.name LIKE ? " ,3);
		                    add(this.pid , " AND t.pid = ? " );
                            add(this.enabled , " AND t.enabled = ? " );
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
		    	@io.swagger.annotations.ApiModelProperty(value = "名称", dataType = "java.lang.String")
    private  String  name ;//  名称
		    	@io.swagger.annotations.ApiModelProperty(value = "上级部门", dataType = "java.lang.Long")
    private  Long  pid ;//  上级部门
		    	@io.swagger.annotations.ApiModelProperty(value = "状态", dataType = "java.lang.Boolean")
    private  Boolean  enabled ;//  状态
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