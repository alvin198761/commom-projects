package org.luna.permission.modules.system.dict;

/**
* 类说明: 数据字典--Swagger控制器类 ,使用requestbody 实现
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.extern.slf4j.Slf4j
@io.swagger.annotations.Api(value = "[数据字典]控制器", description = "[数据字典]相关操作")
@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/api/dict")
public class DictAction {

    @org.springframework.beans.factory.annotation.Autowired
    private DictService dictService; //注入[数据字典]业务逻辑类

    /**
     * 方法说明： 新增[数据字典]记录
     */
    @io.swagger.annotations.ApiOperation(value = "新增[数据字典]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Dict", name = "dict", value = "收寄信息", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("save")
    public org.alvin.code.gen.beans.RestfullResp<Integer> save(@org.springframework.web.bind.annotation.RequestBody Dict dict) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.dictService.save(dict));
    }


    /**
     * 方法说明： 删除[数据字典]记录
     */
    @io.swagger.annotations.ApiOperation(value = "删除[数据字典]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[数据字典]的主键", required = true, dataType = "array", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("delete")
    public org.alvin.code.gen.beans.RestfullResp<Integer> delete(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.dictService.delete(id));
    }


    /**
     * 方法说明： 修改[数据字典]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[数据字典]", notes = "返回影响记录行数,(必须传入完整对象,否则会有数据丢失)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Dict", name = "dict", value = "数据字典", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("update")
    public org.alvin.code.gen.beans.RestfullResp<Integer> update(@org.springframework.web.bind.annotation.RequestBody Dict dict) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.dictService.update(dict));
    }

    /**
     * 方法说明： 修改[数据字典]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[数据字典]", notes = "返回影响记录行数(传入需要修改的属性和主键即可,其他可以为空)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Dict", name = "dict", value = "数据字典", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("updateNotNull")
    public org.alvin.code.gen.beans.RestfullResp<Integer> updateNotNull(@org.springframework.web.bind.annotation.RequestBody Dict dict) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.dictService.updateNotNull(dict));
    }

    /**
     * 方法说明： 按条件查询分页[数据字典]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[数据字典]列表", notes = "返回分页[数据字典]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DictCond", name = "cond", value = "数据字典", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<Dict>> queryPage(@org.springframework.web.bind.annotation.RequestBody DictCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.dictService.queryPage(cond));
    }

    /**
     * 方法说明： 按条件查询不分页[数据字典]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[数据字典]列表", notes = "返回不分页[数据字典]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DictCond", name = "cond", value = "数据字典", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<Dict>> queryList(@org.springframework.web.bind.annotation.RequestBody DictCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.dictService.queryList(cond));
    }

    /**
     * 方法说明： 按条件查询一个 数据字典 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 数据字典 对象", notes = "返回 数据字典对象")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DictCond", name = "cond", value = "数据字典", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findOne")
    public org.alvin.code.gen.beans.RestfullResp<Dict> findOne(@org.springframework.web.bind.annotation.RequestBody DictCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.dictService.findOne(cond));
    }

    /**
     * 方法说明： 按条件查询[数据字典]记录个数
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询[数据字典]记录个数", notes = "返回记录个数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DictCond", name = "cond", value = "数据字典", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryCount")
    public org.alvin.code.gen.beans.RestfullResp<Long> queryCount(@org.springframework.web.bind.annotation.RequestBody DictCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.dictService.queryCount(cond));
    }

    /**
     * 方法说明： 按主键查询单条[数据字典]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[数据字典]记录", notes = "返回单个[数据字典]对象")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[数据字典]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findById")
    public org.alvin.code.gen.beans.RestfullResp<Dict> findById(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.dictService.findById(id));
    }

    /**
     * 方法说明： 按主键查询单条[数据字典]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[数据字典]记录(带标签)", notes = "返回单个[数据字典]对象(带标签)")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[数据字典]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findFkById")
    public org.alvin.code.gen.beans.RestfullResp<DictFk> findFkById(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return  new org.alvin.code.gen.beans.RestfullResp<>(this.dictService.findFkById(id));
    }

    /**
     * 方法说明： 按条件查询一个 数据字典 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 数据字典 对象(带外键标签)", notes = "返回 数据字典对象 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DictFkCond", name = "{table.varName}Cond", value = "数据字典(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findFkOne")
    public org.alvin.code.gen.beans.RestfullResp<DictFk> findFkOne(@org.springframework.web.bind.annotation.RequestBody DictFkCond dictCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.dictService.findFkOne(dictCond));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param dictFkCond
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 数据字典 对象(只显示标签和id的列表)", notes = "返回 数据字典对象 (只显示标签和id的列表)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DictFkCond", name = "dictFkCond", value = "数据字典", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryLabelList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<org.alvin.code.gen.beans.SelectOption>> queryLabelList(@org.springframework.web.bind.annotation.RequestBody DictFkCond dictFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.dictService.queryLabelList(dictFkCond));
    }

    /**
     * 方法说明：按条件查询不分页数据字典列表 (带关系表标签)
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[数据字典]列表 (带外键标签)", notes = "返回不分页[数据字典]列表 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DictFkCond", name = "dictFkCond", value = "数据字典 (外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<DictFk>> queryFkList(@org.springframework.web.bind.annotation.RequestBody DictFkCond dictFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.dictService.queryFkList(dictFkCond));
    }

    /**
     * 方法说明：按条件查询分页数据字典列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[数据字典]列表(带外键标签)", notes = "返回分页[数据字典]列表(带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "DictFkCond", name = "fkCond", value = "数据字典(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<DictFk>> queryFkPage(@org.springframework.web.bind.annotation.RequestBody DictFkCond fkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.dictService.queryFkPage(fkCond));
    }

}

