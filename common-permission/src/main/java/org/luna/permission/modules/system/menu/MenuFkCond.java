package org.luna.permission.modules.system.menu;

/**
* 类说明: menu--查询条件实体类
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@io.swagger.annotations.ApiModel(value = "MenuFkCond", description = "menu--查询条件实体类-外键")
public class MenuFkCond extends MenuCond {

    /**
    * 方法说明: 拼加自定义条件
    **/
    @Override
    public void addCondition() {
		super.addCondition();
        }

    //属性
	
}