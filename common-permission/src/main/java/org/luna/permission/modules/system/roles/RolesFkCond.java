package org.luna.permission.modules.system.roles;

/**
* 类说明: 用户角色关联--查询条件实体类
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@io.swagger.annotations.ApiModel(value = "RolesFkCond", description = "用户角色关联--查询条件实体类-外键")
public class RolesFkCond extends RolesCond {

    /**
    * 方法说明: 拼加自定义条件
    **/
    @Override
    public void addCondition() {
		super.addCondition();
        }

    //属性
	
}