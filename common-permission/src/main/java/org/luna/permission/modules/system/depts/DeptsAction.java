package org.luna.permission.modules.system.depts;

/**
* 类说明: 角色部门关联--Swagger控制器类 ,使用requestbody 实现
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.extern.slf4j.Slf4j
@io.swagger.annotations.Api(value = "[角色部门关联]控制器", description = "[角色部门关联]相关操作")
@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/api/depts")
public class DeptsAction {

    @org.springframework.beans.factory.annotation.Autowired
    private DeptsService deptsService; //注入[角色部门关联]业务逻辑类

    /**
     * 方法说明： 新增[角色部门关联]记录
     */
    @io.swagger.annotations.ApiOperation(value = "新增[角色部门关联]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Depts", name = "depts", value = "收寄信息", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("save")
    public org.alvin.code.gen.beans.RestfullResp<Integer> save(@org.springframework.web.bind.annotation.RequestBody Depts depts) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptsService.save(depts));
    }


    /**
     * 方法说明： 删除[角色部门关联]记录
     */
    @io.swagger.annotations.ApiOperation(value = "删除[角色部门关联]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "roleId", value = "[角色部门关联]的主键", required = true, dataType = "array", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("delete")
    public org.alvin.code.gen.beans.RestfullResp<Integer> delete(@org.springframework.web.bind.annotation.RequestParam("roleId") Long roleId) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptsService.delete(id));
    }


    /**
     * 方法说明： 修改[角色部门关联]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[角色部门关联]", notes = "返回影响记录行数,(必须传入完整对象,否则会有数据丢失)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Depts", name = "depts", value = "角色部门关联", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("update")
    public org.alvin.code.gen.beans.RestfullResp<Integer> update(@org.springframework.web.bind.annotation.RequestBody Depts depts) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptsService.update(depts));
    }

    /**
     * 方法说明： 修改[角色部门关联]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[角色部门关联]", notes = "返回影响记录行数(传入需要修改的属性和主键即可,其他可以为空)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Depts", name = "depts", value = "角色部门关联", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("updateNotNull")
    public org.alvin.code.gen.beans.RestfullResp<Integer> updateNotNull(@org.springframework.web.bind.annotation.RequestBody Depts depts) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptsService.updateNotNull(depts));
    }

    /**
     * 方法说明： 按条件查询分页[角色部门关联]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[角色部门关联]列表", notes = "返回分页[角色部门关联]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptsCond", name = "cond", value = "角色部门关联", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<Depts>> queryPage(@org.springframework.web.bind.annotation.RequestBody DeptsCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptsService.queryPage(cond));
    }

    /**
     * 方法说明： 按条件查询不分页[角色部门关联]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[角色部门关联]列表", notes = "返回不分页[角色部门关联]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptsCond", name = "cond", value = "角色部门关联", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<Depts>> queryList(@org.springframework.web.bind.annotation.RequestBody DeptsCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptsService.queryList(cond));
    }

    /**
     * 方法说明： 按条件查询一个 角色部门关联 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 角色部门关联 对象", notes = "返回 角色部门关联对象")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptsCond", name = "cond", value = "角色部门关联", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findOne")
    public org.alvin.code.gen.beans.RestfullResp<Depts> findOne(@org.springframework.web.bind.annotation.RequestBody DeptsCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptsService.findOne(cond));
    }

    /**
     * 方法说明： 按条件查询[角色部门关联]记录个数
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询[角色部门关联]记录个数", notes = "返回记录个数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptsCond", name = "cond", value = "角色部门关联", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryCount")
    public org.alvin.code.gen.beans.RestfullResp<Long> queryCount(@org.springframework.web.bind.annotation.RequestBody DeptsCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptsService.queryCount(cond));
    }

    /**
     * 方法说明： 按主键查询单条[角色部门关联]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[角色部门关联]记录", notes = "返回单个[角色部门关联]对象")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "roleId", value = "[角色部门关联]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findById")
    public org.alvin.code.gen.beans.RestfullResp<Depts> findById(@org.springframework.web.bind.annotation.RequestParam("id") Long roleId) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptsService.findById(id));
    }

    /**
     * 方法说明： 按主键查询单条[角色部门关联]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[角色部门关联]记录(带标签)", notes = "返回单个[角色部门关联]对象(带标签)")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "roleId", value = "[角色部门关联]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findFkById")
    public org.alvin.code.gen.beans.RestfullResp<DeptsFk> findFkById(@org.springframework.web.bind.annotation.RequestParam("roleId") Long roleId) {
        return  new org.alvin.code.gen.beans.RestfullResp<>(this.deptsService.findFkById(id));
    }

    /**
     * 方法说明： 按条件查询一个 角色部门关联 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 角色部门关联 对象(带外键标签)", notes = "返回 角色部门关联对象 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptsFkCond", name = "{table.varName}Cond", value = "角色部门关联(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findFkOne")
    public org.alvin.code.gen.beans.RestfullResp<DeptsFk> findFkOne(@org.springframework.web.bind.annotation.RequestBody DeptsFkCond deptsCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptsService.findFkOne(deptsCond));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param deptsFkCond
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 角色部门关联 对象(只显示标签和id的列表)", notes = "返回 角色部门关联对象 (只显示标签和id的列表)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptsFkCond", name = "deptsFkCond", value = "角色部门关联", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryLabelList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<org.alvin.code.gen.beans.SelectOption>> queryLabelList(@org.springframework.web.bind.annotation.RequestBody DeptsFkCond deptsFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptsService.queryLabelList(deptsFkCond));
    }

    /**
     * 方法说明：按条件查询不分页角色部门关联列表 (带关系表标签)
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[角色部门关联]列表 (带外键标签)", notes = "返回不分页[角色部门关联]列表 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptsFkCond", name = "deptsFkCond", value = "角色部门关联 (外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<DeptsFk>> queryFkList(@org.springframework.web.bind.annotation.RequestBody DeptsFkCond deptsFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptsService.queryFkList(deptsFkCond));
    }

    /**
     * 方法说明：按条件查询分页角色部门关联列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[角色部门关联]列表(带外键标签)", notes = "返回分页[角色部门关联]列表(带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptsFkCond", name = "fkCond", value = "角色部门关联(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<DeptsFk>> queryFkPage(@org.springframework.web.bind.annotation.RequestBody DeptsFkCond fkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptsService.queryFkPage(fkCond));
    }

}

