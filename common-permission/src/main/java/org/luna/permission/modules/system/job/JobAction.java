package org.luna.permission.modules.system.job;

/**
* 类说明: 岗位--Swagger控制器类 ,使用requestbody 实现
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.extern.slf4j.Slf4j
@io.swagger.annotations.Api(value = "[岗位]控制器", description = "[岗位]相关操作")
@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/api/job")
public class JobAction {

    @org.springframework.beans.factory.annotation.Autowired
    private JobService jobService; //注入[岗位]业务逻辑类

    /**
     * 方法说明： 新增[岗位]记录
     */
    @io.swagger.annotations.ApiOperation(value = "新增[岗位]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Job", name = "job", value = "收寄信息", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("save")
    public org.alvin.code.gen.beans.RestfullResp<Integer> save(@org.springframework.web.bind.annotation.RequestBody Job job) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.jobService.save(job));
    }


    /**
     * 方法说明： 删除[岗位]记录
     */
    @io.swagger.annotations.ApiOperation(value = "删除[岗位]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[岗位]的主键", required = true, dataType = "array", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("delete")
    public org.alvin.code.gen.beans.RestfullResp<Integer> delete(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.jobService.delete(id));
    }


    /**
     * 方法说明： 修改[岗位]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[岗位]", notes = "返回影响记录行数,(必须传入完整对象,否则会有数据丢失)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Job", name = "job", value = "岗位", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("update")
    public org.alvin.code.gen.beans.RestfullResp<Integer> update(@org.springframework.web.bind.annotation.RequestBody Job job) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.jobService.update(job));
    }

    /**
     * 方法说明： 修改[岗位]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[岗位]", notes = "返回影响记录行数(传入需要修改的属性和主键即可,其他可以为空)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "Job", name = "job", value = "岗位", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("updateNotNull")
    public org.alvin.code.gen.beans.RestfullResp<Integer> updateNotNull(@org.springframework.web.bind.annotation.RequestBody Job job) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.jobService.updateNotNull(job));
    }

    /**
     * 方法说明： 按条件查询分页[岗位]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[岗位]列表", notes = "返回分页[岗位]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "JobCond", name = "cond", value = "岗位", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<Job>> queryPage(@org.springframework.web.bind.annotation.RequestBody JobCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.jobService.queryPage(cond));
    }

    /**
     * 方法说明： 按条件查询不分页[岗位]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[岗位]列表", notes = "返回不分页[岗位]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "JobCond", name = "cond", value = "岗位", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<Job>> queryList(@org.springframework.web.bind.annotation.RequestBody JobCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.jobService.queryList(cond));
    }

    /**
     * 方法说明： 按条件查询一个 岗位 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 岗位 对象", notes = "返回 岗位对象")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "JobCond", name = "cond", value = "岗位", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findOne")
    public org.alvin.code.gen.beans.RestfullResp<Job> findOne(@org.springframework.web.bind.annotation.RequestBody JobCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.jobService.findOne(cond));
    }

    /**
     * 方法说明： 按条件查询[岗位]记录个数
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询[岗位]记录个数", notes = "返回记录个数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "JobCond", name = "cond", value = "岗位", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryCount")
    public org.alvin.code.gen.beans.RestfullResp<Long> queryCount(@org.springframework.web.bind.annotation.RequestBody JobCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.jobService.queryCount(cond));
    }

    /**
     * 方法说明： 按主键查询单条[岗位]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[岗位]记录", notes = "返回单个[岗位]对象")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[岗位]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findById")
    public org.alvin.code.gen.beans.RestfullResp<Job> findById(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.jobService.findById(id));
    }

    /**
     * 方法说明： 按主键查询单条[岗位]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[岗位]记录(带标签)", notes = "返回单个[岗位]对象(带标签)")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[岗位]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findFkById")
    public org.alvin.code.gen.beans.RestfullResp<JobFk> findFkById(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return  new org.alvin.code.gen.beans.RestfullResp<>(this.jobService.findFkById(id));
    }

    /**
     * 方法说明： 按条件查询一个 岗位 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 岗位 对象(带外键标签)", notes = "返回 岗位对象 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "JobFkCond", name = "{table.varName}Cond", value = "岗位(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findFkOne")
    public org.alvin.code.gen.beans.RestfullResp<JobFk> findFkOne(@org.springframework.web.bind.annotation.RequestBody JobFkCond jobCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.jobService.findFkOne(jobCond));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param jobFkCond
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 岗位 对象(只显示标签和id的列表)", notes = "返回 岗位对象 (只显示标签和id的列表)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "JobFkCond", name = "jobFkCond", value = "岗位", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryLabelList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<org.alvin.code.gen.beans.SelectOption>> queryLabelList(@org.springframework.web.bind.annotation.RequestBody JobFkCond jobFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.jobService.queryLabelList(jobFkCond));
    }

    /**
     * 方法说明：按条件查询不分页岗位列表 (带关系表标签)
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[岗位]列表 (带外键标签)", notes = "返回不分页[岗位]列表 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "JobFkCond", name = "jobFkCond", value = "岗位 (外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<JobFk>> queryFkList(@org.springframework.web.bind.annotation.RequestBody JobFkCond jobFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.jobService.queryFkList(jobFkCond));
    }

    /**
     * 方法说明：按条件查询分页岗位列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[岗位]列表(带外键标签)", notes = "返回分页[岗位]列表(带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "JobFkCond", name = "fkCond", value = "岗位(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<JobFk>> queryFkPage(@org.springframework.web.bind.annotation.RequestBody JobFkCond fkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.jobService.queryFkPage(fkCond));
    }

}

