package org.luna.permission.modules.system.job;

/**
* 类说明: [岗位]--数据逻辑层
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Service
public class JobService {

	@org.springframework.beans.factory.annotation.Autowired
	private JobDao jobDao; //注入收寄信息数据访问层

	/**
	* 方法说明：  新增[岗位]记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int save(Job job) {
		return this.jobDao.save(job);
	}

	/**
	* 方法说明：  删除岗位记录(多条)
	*/
	@org.springframework.transaction.annotation.Transactional
	public int delete(Long id) {
		//return this.jobDao.deleteLogic(id);//逻辑删除
		return this.jobDao.delete(id);//物理删除
	}

	/**
	* 方法说明：  更新岗位记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int update(Job job) {
		return this.jobDao.update(job); 
	}

	 /**
    * 方法说明：更新岗位记录,不为空的都更新掉
    */
    @org.springframework.transaction.annotation.Transactional
    public int updateNotNull(Job job) {
		return this.jobDao.updateNotNull(job); 
    }

	/**
	* 方法说明： 按条件查询分页岗位列表
	*/
	public org.alvin.code.gen.utils.Page<Job> queryPage(JobCond jobCond) {
		jobCond.getOrder().put("t.id" , "desc");
		return this.jobDao.queryPage(jobCond);
	}

	/**
	* 方法说明： 按条件查询不分页岗位列表(使用范型)
	*/
	public java.util.List<Job> queryList(JobCond jobCond) {
		jobCond.getOrder().put("t.id" , "desc");
		return this.jobDao.queryList(jobCond);
	}
	
	/**
	* 方法说明： 按条件查询一个 岗位 对象
	*/
	public Job findOne(JobCond jobCond) {
		return this.jobDao.findOne(jobCond);
	}

	/**
	* 方法说明： 按ID查找单个岗位记录
	*/
	public Job findById(Long id) {
		return this.jobDao.findById(id);
	}

	/**
	* 方法说明： 按条件查询岗位记录个数
	*/
	public long queryCount(JobCond jobCond) {
		return this.jobDao.queryCount(jobCond);
	}


	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param id
	 * @return
	 */
	public JobFk findFkById(Long id) {
		return this.jobDao.findFkById(id);
	}

	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param jobFkCond
	 * @return
	 */
	public JobFk findFkOne(JobFkCond jobFkCond) {
		return this.jobDao.findFkOne(jobFkCond);
	}

	/**
	 * 方法说明: 只显示标签和id的列表
	 *
	 * @param jobFkCond
	 * @return
	 */
	public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(JobFkCond jobFkCond) {
		jobFkCond.getOrder().put("t.id" , "desc");
		return this.jobDao.queryLabelList(jobFkCond);
	}

	/**
	 * 方法说明：按条件查询不分页岗位列表 (带关系表标签)
	 */
	public java.util.List<JobFk> queryFkList(JobFkCond jobFkCond) {
		jobFkCond.getOrder().put("t.id" , "desc");
		return this.jobDao.queryFkList(jobFkCond);
	}

	/**
	 * 方法说明：按条件查询分页岗位列表
	 */
	public org.alvin.code.gen.utils.Page<JobFk> queryFkPage(JobFkCond jobFkCond) {
		jobFkCond.getOrder().put("t.id" , "desc");
		return this.jobDao.queryFkPage(jobFkCond);
	}

}