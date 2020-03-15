package org.luna.permission.modules.system.dept;

import org.luna.permission.modules.beans.TreeNodeBean;

/**
 * 类说明: 部门--Swagger控制器类 ,使用requestbody 实现
 *
 * @author 唐植超
 * 生成日期 2020-03-09 22:33:12
 **/
@lombok.extern.slf4j.Slf4j
@io.swagger.annotations.Api(value = "[部门]控制器", description = "[部门]相关操作")
@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/api/dept")
public class DeptAction {

    @org.springframework.beans.factory.annotation.Autowired
    private DeptService deptService; //注入[部门]业务逻辑类

    /**
     * 方法说明： 新增[部门]记录
     */
    @io.swagger.annotations.ApiOperation(value = "新增[部门]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Dept", name = "dept", value = "收寄信息", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("save")
    public org.alvin.code.gen.beans.RestfullResp<Integer> save(@org.springframework.web.bind.annotation.RequestBody Dept dept) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.save(dept));
    }


    /**
     * 方法说明： 删除[部门]记录
     */
    @io.swagger.annotations.ApiOperation(value = "删除[部门]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[部门]的主键", required = true, dataType = "array", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("delete")
    public org.alvin.code.gen.beans.RestfullResp<Integer> delete(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.delete(id));
    }


    /**
     * 方法说明： 修改[部门]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[部门]", notes = "返回影响记录行数,(必须传入完整对象,否则会有数据丢失)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Dept", name = "dept", value = "部门", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("update")
    public org.alvin.code.gen.beans.RestfullResp<Integer> update(@org.springframework.web.bind.annotation.RequestBody Dept dept) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.update(dept));
    }

    /**
     * 方法说明： 修改[部门]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[部门]", notes = "返回影响记录行数(传入需要修改的属性和主键即可,其他可以为空)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Dept", name = "dept", value = "部门", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("updateNotNull")
    public org.alvin.code.gen.beans.RestfullResp<Integer> updateNotNull(@org.springframework.web.bind.annotation.RequestBody Dept dept) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.updateNotNull(dept));
    }

    /**
     * 方法说明： 按条件查询分页[部门]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[部门]列表", notes = "返回分页[部门]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptCond", name = "cond", value = "部门", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<Dept>> queryPage(@org.springframework.web.bind.annotation.RequestBody DeptCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.queryPage(cond));
    }

    /**
     * 方法说明： 按条件查询不分页[部门]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[部门]列表", notes = "返回不分页[部门]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptCond", name = "cond", value = "部门", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<Dept>> queryList(@org.springframework.web.bind.annotation.RequestBody DeptCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.queryList(cond));
    }

    /**
     * 方法说明： 按条件查询一个 部门 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 部门 对象", notes = "返回 部门对象")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptCond", name = "cond", value = "部门", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findOne")
    public org.alvin.code.gen.beans.RestfullResp<Dept> findOne(@org.springframework.web.bind.annotation.RequestBody DeptCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.findOne(cond));
    }

    /**
     * 方法说明： 按条件查询[部门]记录个数
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询[部门]记录个数", notes = "返回记录个数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptCond", name = "cond", value = "部门", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryCount")
    public org.alvin.code.gen.beans.RestfullResp<Long> queryCount(@org.springframework.web.bind.annotation.RequestBody DeptCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.queryCount(cond));
    }

    /**
     * 方法说明： 按主键查询单条[部门]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[部门]记录", notes = "返回单个[部门]对象")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[部门]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findById")
    public org.alvin.code.gen.beans.RestfullResp<Dept> findById(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.findById(id));
    }

    /**
     * 方法说明： 按主键查询单条[部门]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[部门]记录(带标签)", notes = "返回单个[部门]对象(带标签)")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[部门]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findFkById")
    public org.alvin.code.gen.beans.RestfullResp<DeptFk> findFkById(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.findFkById(id));
    }

    /**
     * 方法说明： 按条件查询一个 部门 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 部门 对象(带外键标签)", notes = "返回 部门对象 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptFkCond", name = "{table.varName}Cond", value = "部门(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findFkOne")
    public org.alvin.code.gen.beans.RestfullResp<DeptFk> findFkOne(@org.springframework.web.bind.annotation.RequestBody DeptFkCond deptCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.findFkOne(deptCond));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param deptFkCond
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 部门 对象(只显示标签和id的列表)", notes = "返回 部门对象 (只显示标签和id的列表)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptFkCond", name = "deptFkCond", value = "部门", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryLabelList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<org.alvin.code.gen.beans.SelectOption>> queryLabelList(@org.springframework.web.bind.annotation.RequestBody DeptFkCond deptFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.queryLabelList(deptFkCond));
    }

    /**
     * 方法说明：按条件查询不分页部门列表 (带关系表标签)
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[部门]列表 (带外键标签)", notes = "返回不分页[部门]列表 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptFkCond", name = "deptFkCond", value = "部门 (外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<DeptFk>> queryFkList(@org.springframework.web.bind.annotation.RequestBody DeptFkCond deptFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.queryFkList(deptFkCond));
    }

    /**
     * 方法说明：按条件查询分页部门列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[部门]列表(带外键标签)", notes = "返回分页[部门]列表(带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptFkCond", name = "fkCond", value = "部门(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<DeptFk>> queryFkPage(@org.springframework.web.bind.annotation.RequestBody DeptFkCond fkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.queryFkPage(fkCond));
    }


    /**
     * 方法说明： 按条件查询不分页[部门]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[部门]列表", notes = "返回不分页[部门]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DeptCond", name = "cond", value = "部门", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryTreeList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<TreeNodeBean>> queryTreeList(@org.springframework.web.bind.annotation.RequestBody DeptCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.deptService.queryTreeList(cond));
    }

}

