package org.luna.permission.modules.system.user;

/**
* 类说明: 系统用户--Swagger控制器类 ,使用requestbody 实现
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.extern.slf4j.Slf4j
@io.swagger.annotations.Api(value = "[系统用户]控制器", description = "[系统用户]相关操作")
@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/api/user")
public class UserAction {

    @org.springframework.beans.factory.annotation.Autowired
    private UserService userService; //注入[系统用户]业务逻辑类

    /**
     * 方法说明： 新增[系统用户]记录
     */
    @io.swagger.annotations.ApiOperation(value = "新增[系统用户]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "User", name = "user", value = "收寄信息", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("save")
    public org.alvin.code.gen.beans.RestfullResp<Integer> save(@org.springframework.web.bind.annotation.RequestBody User user) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.userService.save(user));
    }


    /**
     * 方法说明： 删除[系统用户]记录
     */
    @io.swagger.annotations.ApiOperation(value = "删除[系统用户]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[系统用户]的主键", required = true, dataType = "array", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("delete")
    public org.alvin.code.gen.beans.RestfullResp<Integer> delete(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.userService.delete(id));
    }


    /**
     * 方法说明： 修改[系统用户]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[系统用户]", notes = "返回影响记录行数,(必须传入完整对象,否则会有数据丢失)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "User", name = "user", value = "系统用户", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("update")
    public org.alvin.code.gen.beans.RestfullResp<Integer> update(@org.springframework.web.bind.annotation.RequestBody User user) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.userService.update(user));
    }

    /**
     * 方法说明： 修改[系统用户]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[系统用户]", notes = "返回影响记录行数(传入需要修改的属性和主键即可,其他可以为空)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "User", name = "user", value = "系统用户", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("updateNotNull")
    public org.alvin.code.gen.beans.RestfullResp<Integer> updateNotNull(@org.springframework.web.bind.annotation.RequestBody User user) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.userService.updateNotNull(user));
    }

    /**
     * 方法说明： 按条件查询分页[系统用户]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[系统用户]列表", notes = "返回分页[系统用户]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "UserCond", name = "cond", value = "系统用户", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<User>> queryPage(@org.springframework.web.bind.annotation.RequestBody UserCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.userService.queryPage(cond));
    }

    /**
     * 方法说明： 按条件查询不分页[系统用户]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[系统用户]列表", notes = "返回不分页[系统用户]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "UserCond", name = "cond", value = "系统用户", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<User>> queryList(@org.springframework.web.bind.annotation.RequestBody UserCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.userService.queryList(cond));
    }

    /**
     * 方法说明： 按条件查询一个 系统用户 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 系统用户 对象", notes = "返回 系统用户对象")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "UserCond", name = "cond", value = "系统用户", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findOne")
    public org.alvin.code.gen.beans.RestfullResp<User> findOne(@org.springframework.web.bind.annotation.RequestBody UserCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.userService.findOne(cond));
    }

    /**
     * 方法说明： 按条件查询[系统用户]记录个数
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询[系统用户]记录个数", notes = "返回记录个数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "UserCond", name = "cond", value = "系统用户", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryCount")
    public org.alvin.code.gen.beans.RestfullResp<Long> queryCount(@org.springframework.web.bind.annotation.RequestBody UserCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.userService.queryCount(cond));
    }

    /**
     * 方法说明： 按主键查询单条[系统用户]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[系统用户]记录", notes = "返回单个[系统用户]对象")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[系统用户]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findById")
    public org.alvin.code.gen.beans.RestfullResp<User> findById(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.userService.findById(id));
    }

    /**
     * 方法说明： 按主键查询单条[系统用户]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[系统用户]记录(带标签)", notes = "返回单个[系统用户]对象(带标签)")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[系统用户]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findFkById")
    public org.alvin.code.gen.beans.RestfullResp<UserFk> findFkById(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return  new org.alvin.code.gen.beans.RestfullResp<>(this.userService.findFkById(id));
    }

    /**
     * 方法说明： 按条件查询一个 系统用户 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 系统用户 对象(带外键标签)", notes = "返回 系统用户对象 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "UserFkCond", name = "{table.varName}Cond", value = "系统用户(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findFkOne")
    public org.alvin.code.gen.beans.RestfullResp<UserFk> findFkOne(@org.springframework.web.bind.annotation.RequestBody UserFkCond userCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.userService.findFkOne(userCond));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param userFkCond
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 系统用户 对象(只显示标签和id的列表)", notes = "返回 系统用户对象 (只显示标签和id的列表)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "UserFkCond", name = "userFkCond", value = "系统用户", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryLabelList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<org.alvin.code.gen.beans.SelectOption>> queryLabelList(@org.springframework.web.bind.annotation.RequestBody UserFkCond userFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.userService.queryLabelList(userFkCond));
    }

    /**
     * 方法说明：按条件查询不分页系统用户列表 (带关系表标签)
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[系统用户]列表 (带外键标签)", notes = "返回不分页[系统用户]列表 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "UserFkCond", name = "userFkCond", value = "系统用户 (外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<UserFk>> queryFkList(@org.springframework.web.bind.annotation.RequestBody UserFkCond userFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.userService.queryFkList(userFkCond));
    }

    /**
     * 方法说明：按条件查询分页系统用户列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[系统用户]列表(带外键标签)", notes = "返回分页[系统用户]列表(带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "UserFkCond", name = "fkCond", value = "系统用户(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<UserFk>> queryFkPage(@org.springframework.web.bind.annotation.RequestBody UserFkCond fkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.userService.queryFkPage(fkCond));
    }

}

