package org.luna.permission.modules.system.menus;

/**
* 类说明: 角色菜单关联--查询条件实体类
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@io.swagger.annotations.ApiModel(value = "MenusCond", description = "角色菜单关联--查询条件实体类")
public class MenusCond extends org.alvin.code.gen.beans.BaseCondition {


    /**
    * 方法说明: 拼加自定义条件
    **/
    @Override
    public void addCondition() {
                    add(this.menuId , " AND t.menu_id = ? " );
                            add(this.roleId , " AND t.role_id = ? " );
                }

    //属性
    	@io.swagger.annotations.ApiModelProperty(value = "菜单ID", dataType = "java.lang.Long")
    private  Long  menuId ;//  菜单ID
		    	@io.swagger.annotations.ApiModelProperty(value = "角色ID", dataType = "java.lang.Long")
    private  Long  roleId ;//  角色ID
		    	//其他常用条件字段
	@io.swagger.annotations.ApiModelProperty(value = "菜单ID", dataType = "java.lang.List")
    private java.util.List<Long> menuIdList;// 主键列表

}