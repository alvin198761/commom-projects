package org.luna.permission.modules.system.detail;

import java.util.Date;

/**
* 类说明: 数据字典详情--Swagger控制器类 ,使用requestbody 实现
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.extern.slf4j.Slf4j
@io.swagger.annotations.Api(value = "[数据字典详情]控制器", description = "[数据字典详情]相关操作")
@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/api/detail")
public class DetailAction {

    @org.springframework.beans.factory.annotation.Autowired
    private DetailService detailService; //注入[数据字典详情]业务逻辑类

    /**
     * 方法说明： 新增[数据字典详情]记录
     */
    @io.swagger.annotations.ApiOperation(value = "新增[数据字典详情]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Detail", name = "detail", value = "收寄信息", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("save")
    public org.alvin.code.gen.beans.RestfullResp<Integer> save(@org.springframework.web.bind.annotation.RequestBody Detail detail) {
        detail.setCreateTime(new Date());
        return new org.alvin.code.gen.beans.RestfullResp<>(this.detailService.save(detail));
    }


    /**
     * 方法说明： 删除[数据字典详情]记录
     */
    @io.swagger.annotations.ApiOperation(value = "删除[数据字典详情]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[数据字典详情]的主键", required = true, dataType = "array", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("delete")
    public org.alvin.code.gen.beans.RestfullResp<Integer> delete(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.detailService.delete(id));
    }


    /**
     * 方法说明： 修改[数据字典详情]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[数据字典详情]", notes = "返回影响记录行数,(必须传入完整对象,否则会有数据丢失)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Detail", name = "detail", value = "数据字典详情", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("update")
    public org.alvin.code.gen.beans.RestfullResp<Integer> update(@org.springframework.web.bind.annotation.RequestBody Detail detail) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.detailService.update(detail));
    }

    /**
     * 方法说明： 修改[数据字典详情]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[数据字典详情]", notes = "返回影响记录行数(传入需要修改的属性和主键即可,其他可以为空)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Detail", name = "detail", value = "数据字典详情", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("updateNotNull")
    public org.alvin.code.gen.beans.RestfullResp<Integer> updateNotNull(@org.springframework.web.bind.annotation.RequestBody Detail detail) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.detailService.updateNotNull(detail));
    }

    /**
     * 方法说明： 按条件查询分页[数据字典详情]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[数据字典详情]列表", notes = "返回分页[数据字典详情]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DetailCond", name = "cond", value = "数据字典详情", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<Detail>> queryPage(@org.springframework.web.bind.annotation.RequestBody DetailCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.detailService.queryPage(cond));
    }

    /**
     * 方法说明： 按条件查询不分页[数据字典详情]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[数据字典详情]列表", notes = "返回不分页[数据字典详情]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DetailCond", name = "cond", value = "数据字典详情", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<Detail>> queryList(@org.springframework.web.bind.annotation.RequestBody DetailCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.detailService.queryList(cond));
    }

    /**
     * 方法说明： 按条件查询一个 数据字典详情 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 数据字典详情 对象", notes = "返回 数据字典详情对象")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DetailCond", name = "cond", value = "数据字典详情", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findOne")
    public org.alvin.code.gen.beans.RestfullResp<Detail> findOne(@org.springframework.web.bind.annotation.RequestBody DetailCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.detailService.findOne(cond));
    }

    /**
     * 方法说明： 按条件查询[数据字典详情]记录个数
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询[数据字典详情]记录个数", notes = "返回记录个数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DetailCond", name = "cond", value = "数据字典详情", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryCount")
    public org.alvin.code.gen.beans.RestfullResp<Long> queryCount(@org.springframework.web.bind.annotation.RequestBody DetailCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.detailService.queryCount(cond));
    }

    /**
     * 方法说明： 按主键查询单条[数据字典详情]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[数据字典详情]记录", notes = "返回单个[数据字典详情]对象")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[数据字典详情]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findById")
    public org.alvin.code.gen.beans.RestfullResp<Detail> findById(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.detailService.findById(id));
    }

    /**
     * 方法说明： 按主键查询单条[数据字典详情]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[数据字典详情]记录(带标签)", notes = "返回单个[数据字典详情]对象(带标签)")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[数据字典详情]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findFkById")
    public org.alvin.code.gen.beans.RestfullResp<DetailFk> findFkById(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return  new org.alvin.code.gen.beans.RestfullResp<>(this.detailService.findFkById(id));
    }

    /**
     * 方法说明： 按条件查询一个 数据字典详情 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 数据字典详情 对象(带外键标签)", notes = "返回 数据字典详情对象 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DetailFkCond", name = "{table.varName}Cond", value = "数据字典详情(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findFkOne")
    public org.alvin.code.gen.beans.RestfullResp<DetailFk> findFkOne(@org.springframework.web.bind.annotation.RequestBody DetailFkCond detailCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.detailService.findFkOne(detailCond));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param detailFkCond
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 数据字典详情 对象(只显示标签和id的列表)", notes = "返回 数据字典详情对象 (只显示标签和id的列表)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DetailFkCond", name = "detailFkCond", value = "数据字典详情", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryLabelList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<org.alvin.code.gen.beans.SelectOption>> queryLabelList(@org.springframework.web.bind.annotation.RequestBody DetailFkCond detailFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.detailService.queryLabelList(detailFkCond));
    }

    /**
     * 方法说明：按条件查询不分页数据字典详情列表 (带关系表标签)
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[数据字典详情]列表 (带外键标签)", notes = "返回不分页[数据字典详情]列表 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DetailFkCond", name = "detailFkCond", value = "数据字典详情 (外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<DetailFk>> queryFkList(@org.springframework.web.bind.annotation.RequestBody DetailFkCond detailFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.detailService.queryFkList(detailFkCond));
    }

    /**
     * 方法说明：按条件查询分页数据字典详情列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[数据字典详情]列表(带外键标签)", notes = "返回分页[数据字典详情]列表(带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DetailFkCond", name = "fkCond", value = "数据字典详情(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<DetailFk>> queryFkPage(@org.springframework.web.bind.annotation.RequestBody DetailFkCond fkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.detailService.queryFkPage(fkCond));
    }

}

