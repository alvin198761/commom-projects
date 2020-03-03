package org.luna.permission.modules.system.roles;

/**
* 类说明: 用户角色关联--Swagger控制器类 ,使用requestbody 实现
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.extern.slf4j.Slf4j
@io.swagger.annotations.Api(value = "[用户角色关联]控制器", description = "[用户角色关联]相关操作")
@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/api/roles")
public class RolesAction {

    @org.springframework.beans.factory.annotation.Autowired
    private RolesService rolesService; //注入[用户角色关联]业务逻辑类

    /**
     * 方法说明： 新增[用户角色关联]记录
     */
    @io.swagger.annotations.ApiOperation(value = "新增[用户角色关联]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Roles", name = "roles", value = "收寄信息", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("save")
    public org.alvin.code.gen.beans.RestfullResp<Integer> save(@org.springframework.web.bind.annotation.RequestBody Roles roles) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.rolesService.save(roles));
    }


    /**
     * 方法说明： 删除[用户角色关联]记录
     */
    @io.swagger.annotations.ApiOperation(value = "删除[用户角色关联]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "userId", value = "[用户角色关联]的主键", required = true, dataType = "array", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("delete")
    public org.alvin.code.gen.beans.RestfullResp<Integer> delete(@org.springframework.web.bind.annotation.RequestParam("userId") Long userId) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.rolesService.delete(id));
    }


    /**
     * 方法说明： 修改[用户角色关联]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[用户角色关联]", notes = "返回影响记录行数,(必须传入完整对象,否则会有数据丢失)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Roles", name = "roles", value = "用户角色关联", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("update")
    public org.alvin.code.gen.beans.RestfullResp<Integer> update(@org.springframework.web.bind.annotation.RequestBody Roles roles) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.rolesService.update(roles));
    }

    /**
     * 方法说明： 修改[用户角色关联]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[用户角色关联]", notes = "返回影响记录行数(传入需要修改的属性和主键即可,其他可以为空)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Roles", name = "roles", value = "用户角色关联", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("updateNotNull")
    public org.alvin.code.gen.beans.RestfullResp<Integer> updateNotNull(@org.springframework.web.bind.annotation.RequestBody Roles roles) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.rolesService.updateNotNull(roles));
    }

    /**
     * 方法说明： 按条件查询分页[用户角色关联]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[用户角色关联]列表", notes = "返回分页[用户角色关联]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "RolesCond", name = "cond", value = "用户角色关联", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<Roles>> queryPage(@org.springframework.web.bind.annotation.RequestBody RolesCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.rolesService.queryPage(cond));
    }

    /**
     * 方法说明： 按条件查询不分页[用户角色关联]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[用户角色关联]列表", notes = "返回不分页[用户角色关联]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "RolesCond", name = "cond", value = "用户角色关联", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<Roles>> queryList(@org.springframework.web.bind.annotation.RequestBody RolesCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.rolesService.queryList(cond));
    }

    /**
     * 方法说明： 按条件查询一个 用户角色关联 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 用户角色关联 对象", notes = "返回 用户角色关联对象")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "RolesCond", name = "cond", value = "用户角色关联", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findOne")
    public org.alvin.code.gen.beans.RestfullResp<Roles> findOne(@org.springframework.web.bind.annotation.RequestBody RolesCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.rolesService.findOne(cond));
    }

    /**
     * 方法说明： 按条件查询[用户角色关联]记录个数
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询[用户角色关联]记录个数", notes = "返回记录个数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "RolesCond", name = "cond", value = "用户角色关联", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryCount")
    public org.alvin.code.gen.beans.RestfullResp<Long> queryCount(@org.springframework.web.bind.annotation.RequestBody RolesCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.rolesService.queryCount(cond));
    }

    /**
     * 方法说明： 按主键查询单条[用户角色关联]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[用户角色关联]记录", notes = "返回单个[用户角色关联]对象")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "userId", value = "[用户角色关联]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findById")
    public org.alvin.code.gen.beans.RestfullResp<Roles> findById(@org.springframework.web.bind.annotation.RequestParam("id") Long userId) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.rolesService.findById(id));
    }

    /**
     * 方法说明： 按主键查询单条[用户角色关联]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[用户角色关联]记录(带标签)", notes = "返回单个[用户角色关联]对象(带标签)")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "userId", value = "[用户角色关联]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findFkById")
    public org.alvin.code.gen.beans.RestfullResp<RolesFk> findFkById(@org.springframework.web.bind.annotation.RequestParam("userId") Long userId) {
        return  new org.alvin.code.gen.beans.RestfullResp<>(this.rolesService.findFkById(id));
    }

    /**
     * 方法说明： 按条件查询一个 用户角色关联 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 用户角色关联 对象(带外键标签)", notes = "返回 用户角色关联对象 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "RolesFkCond", name = "{table.varName}Cond", value = "用户角色关联(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findFkOne")
    public org.alvin.code.gen.beans.RestfullResp<RolesFk> findFkOne(@org.springframework.web.bind.annotation.RequestBody RolesFkCond rolesCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.rolesService.findFkOne(rolesCond));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param rolesFkCond
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 用户角色关联 对象(只显示标签和id的列表)", notes = "返回 用户角色关联对象 (只显示标签和id的列表)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "RolesFkCond", name = "rolesFkCond", value = "用户角色关联", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryLabelList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<org.alvin.code.gen.beans.SelectOption>> queryLabelList(@org.springframework.web.bind.annotation.RequestBody RolesFkCond rolesFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.rolesService.queryLabelList(rolesFkCond));
    }

    /**
     * 方法说明：按条件查询不分页用户角色关联列表 (带关系表标签)
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[用户角色关联]列表 (带外键标签)", notes = "返回不分页[用户角色关联]列表 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "RolesFkCond", name = "rolesFkCond", value = "用户角色关联 (外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<RolesFk>> queryFkList(@org.springframework.web.bind.annotation.RequestBody RolesFkCond rolesFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.rolesService.queryFkList(rolesFkCond));
    }

    /**
     * 方法说明：按条件查询分页用户角色关联列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[用户角色关联]列表(带外键标签)", notes = "返回分页[用户角色关联]列表(带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "RolesFkCond", name = "fkCond", value = "用户角色关联(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<RolesFk>> queryFkPage(@org.springframework.web.bind.annotation.RequestBody RolesFkCond fkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.rolesService.queryFkPage(fkCond));
    }

}

