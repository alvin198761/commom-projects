package org.luna.permission.modules.system.roles;

/**
* 类说明: [用户角色关联]--数据逻辑层
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Service
public class RolesService {

	@org.springframework.beans.factory.annotation.Autowired
	private RolesDao rolesDao; //注入收寄信息数据访问层

	/**
	* 方法说明：  新增[用户角色关联]记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int save(Roles roles) {
		return this.rolesDao.save(roles);
	}

	/**
	* 方法说明：  删除用户角色关联记录(多条)
	*/
	@org.springframework.transaction.annotation.Transactional
	public int delete(Long userId) {
		//return this.rolesDao.deleteLogic(userId);//逻辑删除
		return this.rolesDao.delete(userId);//物理删除
	}

	/**
	* 方法说明：  更新用户角色关联记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int update(Roles roles) {
		return this.rolesDao.update(roles); 
	}

	 /**
    * 方法说明：更新用户角色关联记录,不为空的都更新掉
    */
    @org.springframework.transaction.annotation.Transactional
    public int updateNotNull(Roles roles) {
		return this.rolesDao.updateNotNull(roles); 
    }

	/**
	* 方法说明： 按条件查询分页用户角色关联列表
	*/
	public org.alvin.code.gen.utils.Page<Roles> queryPage(RolesCond rolesCond) {
		rolesCond.getOrder().put("t.user_id" , "desc");
		return this.rolesDao.queryPage(rolesCond);
	}

	/**
	* 方法说明： 按条件查询不分页用户角色关联列表(使用范型)
	*/
	public java.util.List<Roles> queryList(RolesCond rolesCond) {
		rolesCond.getOrder().put("t.user_id" , "desc");
		return this.rolesDao.queryList(rolesCond);
	}
	
	/**
	* 方法说明： 按条件查询一个 用户角色关联 对象
	*/
	public Roles findOne(RolesCond rolesCond) {
		return this.rolesDao.findOne(rolesCond);
	}

	/**
	* 方法说明： 按ID查找单个用户角色关联记录
	*/
	public Roles findById(Long id) {
		return this.rolesDao.findById(id);
	}

	/**
	* 方法说明： 按条件查询用户角色关联记录个数
	*/
	public long queryCount(RolesCond rolesCond) {
		return this.rolesDao.queryCount(rolesCond);
	}


	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param id
	 * @return
	 */
	public RolesFk findFkById(Long id) {
		return this.rolesDao.findFkById(id);
	}

	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param rolesFkCond
	 * @return
	 */
	public RolesFk findFkOne(RolesFkCond rolesFkCond) {
		return this.rolesDao.findFkOne(rolesFkCond);
	}

	/**
	 * 方法说明: 只显示标签和id的列表
	 *
	 * @param rolesFkCond
	 * @return
	 */
	public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(RolesFkCond rolesFkCond) {
		rolesFkCond.getOrder().put("t.user_id" , "desc");
		return this.rolesDao.queryLabelList(rolesFkCond);
	}

	/**
	 * 方法说明：按条件查询不分页用户角色关联列表 (带关系表标签)
	 */
	public java.util.List<RolesFk> queryFkList(RolesFkCond rolesFkCond) {
		rolesFkCond.getOrder().put("t.user_id" , "desc");
		return this.rolesDao.queryFkList(rolesFkCond);
	}

	/**
	 * 方法说明：按条件查询分页用户角色关联列表
	 */
	public org.alvin.code.gen.utils.Page<RolesFk> queryFkPage(RolesFkCond rolesFkCond) {
		rolesFkCond.getOrder().put("t.user_id" , "desc");
		return this.rolesDao.queryFkPage(rolesFkCond);
	}

}