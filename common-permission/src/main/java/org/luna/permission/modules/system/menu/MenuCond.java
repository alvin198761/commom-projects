package org.luna.permission.modules.system.menu;

/**
* 类说明: menu--查询条件实体类
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@io.swagger.annotations.ApiModel(value = "MenuCond", description = "menu--查询条件实体类")
public class MenuCond extends org.alvin.code.gen.beans.BaseCondition {


    /**
    * 方法说明: 拼加自定义条件
    **/
    @Override
    public void addCondition() {
                    add(this.id , " AND t.id = ? " );
                            add(this.iFrame , " AND t.i_frame = ? " );
                            add(this.name , " AND t.name LIKE ? " ,3);
		                    add(this.component , " AND t.component LIKE ? " ,3);
		                    add(this.pid , " AND t.pid = ? " );
                            add(this.sort , " AND t.sort = ? " );
                            add(this.icon , " AND t.icon LIKE ? " ,3);
		                    add(this.path , " AND t.path LIKE ? " ,3);
		                    add(this.cache , " AND t.cache = ? " );
                            add(this.hidden , " AND t.hidden = ? " );
                            add(this.componentName , " AND t.component_name LIKE ? " ,3);
		            		add(this.createTime , " AND t.create_time = ? " );
		if(this.createTimeStart != null){
			add(org.alvin.utils.DateUtil.setStart(this.createTimeStart ), " AND t.create_time >= ? "); //创建日期开始
		}
		if(this.createTimeStart != null){
			add(org.alvin.utils.DateUtil.setEnd(this.createTimeEnd), " AND t.create_time <= ? "); //  创建日期结束
		}
                            add(this.permission , " AND t.permission LIKE ? " ,3);
		                    add(this.type , " AND t.type = ? " );
                            add(this.appCode , " AND t.app_code LIKE ? " ,3);
		        }

    //属性
    	@io.swagger.annotations.ApiModelProperty(value = "ID", dataType = "java.lang.Long")
    private  Long  id ;//  ID
		    	@io.swagger.annotations.ApiModelProperty(value = "是否外链", dataType = "java.lang.Boolean")
    private  Boolean  iFrame ;//  是否外链
		    	@io.swagger.annotations.ApiModelProperty(value = "菜单名称", dataType = "java.lang.String")
    private  String  name ;//  菜单名称
		    	@io.swagger.annotations.ApiModelProperty(value = "组件", dataType = "java.lang.String")
    private  String  component ;//  组件
		    	@io.swagger.annotations.ApiModelProperty(value = "上级菜单ID", dataType = "java.lang.Long")
    private  Long  pid ;//  上级菜单ID
		    	@io.swagger.annotations.ApiModelProperty(value = "排序", dataType = "java.lang.Long")
    private  Long  sort ;//  排序
		    	@io.swagger.annotations.ApiModelProperty(value = "图标", dataType = "java.lang.String")
    private  String  icon ;//  图标
		    	@io.swagger.annotations.ApiModelProperty(value = "链接地址", dataType = "java.lang.String")
    private  String  path ;//  链接地址
		    	@io.swagger.annotations.ApiModelProperty(value = "缓存", dataType = "java.lang.Boolean")
    private  Boolean  cache ;//  缓存
		    	@io.swagger.annotations.ApiModelProperty(value = "是否隐藏", dataType = "java.lang.Boolean")
    private  Boolean  hidden ;//  是否隐藏
		    	@io.swagger.annotations.ApiModelProperty(value = "组件名称", dataType = "java.lang.String")
    private  String  componentName ;//  组件名称
		    	@io.swagger.annotations.ApiModelProperty(value = "创建日期", dataType = "java.util.Date")
    private  java.util.Date  createTime ;//  创建日期
					//日期查询范围
			@io.swagger.annotations.ApiModelProperty(value = "创建日期开始", dataType = "java.util.Date")
			private  java.util.Date  createTimeStart ;//  创建日期开始
			@io.swagger.annotations.ApiModelProperty(value = "创建日期结束", dataType = "java.util.Date")
			private  java.util.Date  createTimeEnd ;//  创建日期结束
		    	@io.swagger.annotations.ApiModelProperty(value = "权限", dataType = "java.lang.String")
    private  String  permission ;//  权限
		    	@io.swagger.annotations.ApiModelProperty(value = "类型", dataType = "java.lang.Integer")
    private  Integer  type ;//  类型
		    	@io.swagger.annotations.ApiModelProperty(value = "系统码", dataType = "java.lang.String")
    private  String  appCode ;//  系统码
		    	//其他常用条件字段
	@io.swagger.annotations.ApiModelProperty(value = "ID", dataType = "java.lang.List")
    private java.util.List<Long> idList;// 主键列表

}