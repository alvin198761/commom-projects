package org.luna.permission.modules.system.menu;

/**
* 类说明: menu--Swagger控制器类 ,使用requestbody 实现
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.extern.slf4j.Slf4j
@io.swagger.annotations.Api(value = "[menu]控制器", description = "[menu]相关操作")
@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/api/menu")
public class MenuAction {

    @org.springframework.beans.factory.annotation.Autowired
    private MenuService menuService; //注入[menu]业务逻辑类

    /**
     * 方法说明： 新增[menu]记录
     */
    @io.swagger.annotations.ApiOperation(value = "新增[menu]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Menu", name = "menu", value = "收寄信息", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("save")
    public org.alvin.code.gen.beans.RestfullResp<Integer> save(@org.springframework.web.bind.annotation.RequestBody Menu menu) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.menuService.save(menu));
    }


    /**
     * 方法说明： 删除[menu]记录
     */
    @io.swagger.annotations.ApiOperation(value = "删除[menu]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[menu]的主键", required = true, dataType = "array", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("delete")
    public org.alvin.code.gen.beans.RestfullResp<Integer> delete(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.menuService.delete(id));
    }


    /**
     * 方法说明： 修改[menu]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[menu]", notes = "返回影响记录行数,(必须传入完整对象,否则会有数据丢失)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Menu", name = "menu", value = "menu", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("update")
    public org.alvin.code.gen.beans.RestfullResp<Integer> update(@org.springframework.web.bind.annotation.RequestBody Menu menu) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.menuService.update(menu));
    }

    /**
     * 方法说明： 修改[menu]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[menu]", notes = "返回影响记录行数(传入需要修改的属性和主键即可,其他可以为空)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Menu", name = "menu", value = "menu", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("updateNotNull")
    public org.alvin.code.gen.beans.RestfullResp<Integer> updateNotNull(@org.springframework.web.bind.annotation.RequestBody Menu menu) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.menuService.updateNotNull(menu));
    }

    /**
     * 方法说明： 按条件查询分页[menu]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[menu]列表", notes = "返回分页[menu]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "MenuCond", name = "cond", value = "menu", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<Menu>> queryPage(@org.springframework.web.bind.annotation.RequestBody MenuCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.menuService.queryPage(cond));
    }

    /**
     * 方法说明： 按条件查询不分页[menu]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[menu]列表", notes = "返回不分页[menu]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "MenuCond", name = "cond", value = "menu", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<Menu>> queryList(@org.springframework.web.bind.annotation.RequestBody MenuCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.menuService.queryList(cond));
    }

    /**
     * 方法说明： 按条件查询一个 menu 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 menu 对象", notes = "返回 menu对象")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "MenuCond", name = "cond", value = "menu", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findOne")
    public org.alvin.code.gen.beans.RestfullResp<Menu> findOne(@org.springframework.web.bind.annotation.RequestBody MenuCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.menuService.findOne(cond));
    }

    /**
     * 方法说明： 按条件查询[menu]记录个数
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询[menu]记录个数", notes = "返回记录个数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "MenuCond", name = "cond", value = "menu", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryCount")
    public org.alvin.code.gen.beans.RestfullResp<Long> queryCount(@org.springframework.web.bind.annotation.RequestBody MenuCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.menuService.queryCount(cond));
    }

    /**
     * 方法说明： 按主键查询单条[menu]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[menu]记录", notes = "返回单个[menu]对象")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[menu]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findById")
    public org.alvin.code.gen.beans.RestfullResp<Menu> findById(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.menuService.findById(id));
    }

    /**
     * 方法说明： 按主键查询单条[menu]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[menu]记录(带标签)", notes = "返回单个[menu]对象(带标签)")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[menu]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findFkById")
    public org.alvin.code.gen.beans.RestfullResp<MenuFk> findFkById(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return  new org.alvin.code.gen.beans.RestfullResp<>(this.menuService.findFkById(id));
    }

    /**
     * 方法说明： 按条件查询一个 menu 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 menu 对象(带外键标签)", notes = "返回 menu对象 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "MenuFkCond", name = "{table.varName}Cond", value = "menu(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findFkOne")
    public org.alvin.code.gen.beans.RestfullResp<MenuFk> findFkOne(@org.springframework.web.bind.annotation.RequestBody MenuFkCond menuCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.menuService.findFkOne(menuCond));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param menuFkCond
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 menu 对象(只显示标签和id的列表)", notes = "返回 menu对象 (只显示标签和id的列表)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "MenuFkCond", name = "menuFkCond", value = "menu", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryLabelList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<org.alvin.code.gen.beans.SelectOption>> queryLabelList(@org.springframework.web.bind.annotation.RequestBody MenuFkCond menuFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.menuService.queryLabelList(menuFkCond));
    }

    /**
     * 方法说明：按条件查询不分页menu列表 (带关系表标签)
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[menu]列表 (带外键标签)", notes = "返回不分页[menu]列表 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "MenuFkCond", name = "menuFkCond", value = "menu (外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<MenuFk>> queryFkList(@org.springframework.web.bind.annotation.RequestBody MenuFkCond menuFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.menuService.queryFkList(menuFkCond));
    }

    /**
     * 方法说明：按条件查询分页menu列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[menu]列表(带外键标签)", notes = "返回分页[menu]列表(带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "MenuFkCond", name = "fkCond", value = "menu(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<MenuFk>> queryFkPage(@org.springframework.web.bind.annotation.RequestBody MenuFkCond fkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.menuService.queryFkPage(fkCond));
    }

}

