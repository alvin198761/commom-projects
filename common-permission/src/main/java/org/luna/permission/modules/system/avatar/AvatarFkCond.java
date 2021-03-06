package org.luna.permission.modules.system.avatar;

/**
* 类说明: 系统用户头像--查询条件实体类
* @author 唐植超
* 生成日期 2020-03-15 17:28:25
**/
@lombok.Setter
@lombok.Getter
@lombok.experimental.Accessors(chain = true)
@io.swagger.annotations.ApiModel(value = "AvatarFkCond", description = "系统用户头像--查询条件实体类-外键")
public class AvatarFkCond extends AvatarCond {

    /**
    * 方法说明: 拼加自定义条件
    **/
    @Override
    public void addCondition() {
		super.addCondition();
        }

    //属性
	
}