package org.luna.permission.modules.system.depts;

/**
* 类说明: 角色部门关联--查询条件实体类
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@lombok.Builder	
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@io.swagger.annotations.ApiModel(value = "DeptsCond", description = "角色部门关联--查询条件实体类")
public class DeptsCond extends org.alvin.code.gen.beans.BaseCondition {


    /**
    * 方法说明: 拼加自定义条件
    **/
    @Override
    public void addCondition() {
                    add(this.roleId , " AND t.role_id = ? " );
                            add(this.deptId , " AND t.dept_id = ? " );
                }

    //属性
    	@io.swagger.annotations.ApiModelProperty(value = "role_id", dataType = "java.lang.Long")
    private  Long  roleId ;//  role_id
		    	@io.swagger.annotations.ApiModelProperty(value = "dept_id", dataType = "java.lang.Long")
    private  Long  deptId ;//  dept_id
		    	//其他常用条件字段
	@io.swagger.annotations.ApiModelProperty(value = "role_id", dataType = "java.lang.List")
    private java.util.List<Long> roleIdList;// 主键列表

}