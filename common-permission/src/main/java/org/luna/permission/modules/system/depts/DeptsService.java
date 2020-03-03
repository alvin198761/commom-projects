package org.luna.permission.modules.system.depts;

/**
* 类说明: [角色部门关联]--数据逻辑层
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Service
public class DeptsService {

	@org.springframework.beans.factory.annotation.Autowired
	private DeptsDao deptsDao; //注入收寄信息数据访问层

	/**
	* 方法说明：  新增[角色部门关联]记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int save(Depts depts) {
		return this.deptsDao.save(depts);
	}

	/**
	* 方法说明：  删除角色部门关联记录(多条)
	*/
	@org.springframework.transaction.annotation.Transactional
	public int delete(Long roleId) {
		//return this.deptsDao.deleteLogic(roleId);//逻辑删除
		return this.deptsDao.delete(roleId);//物理删除
	}

	/**
	* 方法说明：  更新角色部门关联记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int update(Depts depts) {
		return this.deptsDao.update(depts); 
	}

	 /**
    * 方法说明：更新角色部门关联记录,不为空的都更新掉
    */
    @org.springframework.transaction.annotation.Transactional
    public int updateNotNull(Depts depts) {
		return this.deptsDao.updateNotNull(depts); 
    }

	/**
	* 方法说明： 按条件查询分页角色部门关联列表
	*/
	public org.alvin.code.gen.utils.Page<Depts> queryPage(DeptsCond deptsCond) {
		deptsCond.getOrder().put("t.role_id" , "desc");
		return this.deptsDao.queryPage(deptsCond);
	}

	/**
	* 方法说明： 按条件查询不分页角色部门关联列表(使用范型)
	*/
	public java.util.List<Depts> queryList(DeptsCond deptsCond) {
		deptsCond.getOrder().put("t.role_id" , "desc");
		return this.deptsDao.queryList(deptsCond);
	}
	
	/**
	* 方法说明： 按条件查询一个 角色部门关联 对象
	*/
	public Depts findOne(DeptsCond deptsCond) {
		return this.deptsDao.findOne(deptsCond);
	}

	/**
	* 方法说明： 按ID查找单个角色部门关联记录
	*/
	public Depts findById(Long id) {
		return this.deptsDao.findById(id);
	}

	/**
	* 方法说明： 按条件查询角色部门关联记录个数
	*/
	public long queryCount(DeptsCond deptsCond) {
		return this.deptsDao.queryCount(deptsCond);
	}


	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param id
	 * @return
	 */
	public DeptsFk findFkById(Long id) {
		return this.deptsDao.findFkById(id);
	}

	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param deptsFkCond
	 * @return
	 */
	public DeptsFk findFkOne(DeptsFkCond deptsFkCond) {
		return this.deptsDao.findFkOne(deptsFkCond);
	}

	/**
	 * 方法说明: 只显示标签和id的列表
	 *
	 * @param deptsFkCond
	 * @return
	 */
	public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(DeptsFkCond deptsFkCond) {
		deptsFkCond.getOrder().put("t.role_id" , "desc");
		return this.deptsDao.queryLabelList(deptsFkCond);
	}

	/**
	 * 方法说明：按条件查询不分页角色部门关联列表 (带关系表标签)
	 */
	public java.util.List<DeptsFk> queryFkList(DeptsFkCond deptsFkCond) {
		deptsFkCond.getOrder().put("t.role_id" , "desc");
		return this.deptsDao.queryFkList(deptsFkCond);
	}

	/**
	 * 方法说明：按条件查询分页角色部门关联列表
	 */
	public org.alvin.code.gen.utils.Page<DeptsFk> queryFkPage(DeptsFkCond deptsFkCond) {
		deptsFkCond.getOrder().put("t.role_id" , "desc");
		return this.deptsDao.queryFkPage(deptsFkCond);
	}

}