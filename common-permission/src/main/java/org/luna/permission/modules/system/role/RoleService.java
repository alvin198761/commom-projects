package org.luna.permission.modules.system.role;

/**
* 类说明: [角色表]--数据逻辑层
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Service
public class RoleService {

	@org.springframework.beans.factory.annotation.Autowired
	private RoleDao roleDao; //注入收寄信息数据访问层

	/**
	* 方法说明：  新增[角色表]记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int save(Role role) {
		return this.roleDao.save(role);
	}

	/**
	* 方法说明：  删除角色表记录(多条)
	*/
	@org.springframework.transaction.annotation.Transactional
	public int delete(Long id) {
		//return this.roleDao.deleteLogic(id);//逻辑删除
		return this.roleDao.delete(id);//物理删除
	}

	/**
	* 方法说明：  更新角色表记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int update(Role role) {
		return this.roleDao.update(role); 
	}

	 /**
    * 方法说明：更新角色表记录,不为空的都更新掉
    */
    @org.springframework.transaction.annotation.Transactional
    public int updateNotNull(Role role) {
		return this.roleDao.updateNotNull(role); 
    }

	/**
	* 方法说明： 按条件查询分页角色表列表
	*/
	public org.alvin.code.gen.utils.Page<Role> queryPage(RoleCond roleCond) {
		roleCond.getOrder().put("t.id" , "desc");
		return this.roleDao.queryPage(roleCond);
	}

	/**
	* 方法说明： 按条件查询不分页角色表列表(使用范型)
	*/
	public java.util.List<Role> queryList(RoleCond roleCond) {
		roleCond.getOrder().put("t.id" , "desc");
		return this.roleDao.queryList(roleCond);
	}
	
	/**
	* 方法说明： 按条件查询一个 角色表 对象
	*/
	public Role findOne(RoleCond roleCond) {
		return this.roleDao.findOne(roleCond);
	}

	/**
	* 方法说明： 按ID查找单个角色表记录
	*/
	public Role findById(Long id) {
		return this.roleDao.findById(id);
	}

	/**
	* 方法说明： 按条件查询角色表记录个数
	*/
	public long queryCount(RoleCond roleCond) {
		return this.roleDao.queryCount(roleCond);
	}


	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param id
	 * @return
	 */
	public RoleFk findFkById(Long id) {
		return this.roleDao.findFkById(id);
	}

	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param roleFkCond
	 * @return
	 */
	public RoleFk findFkOne(RoleFkCond roleFkCond) {
		return this.roleDao.findFkOne(roleFkCond);
	}

	/**
	 * 方法说明: 只显示标签和id的列表
	 *
	 * @param roleFkCond
	 * @return
	 */
	public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(RoleFkCond roleFkCond) {
		roleFkCond.getOrder().put("t.id" , "desc");
		return this.roleDao.queryLabelList(roleFkCond);
	}

	/**
	 * 方法说明：按条件查询不分页角色表列表 (带关系表标签)
	 */
	public java.util.List<RoleFk> queryFkList(RoleFkCond roleFkCond) {
		roleFkCond.getOrder().put("t.id" , "desc");
		return this.roleDao.queryFkList(roleFkCond);
	}

	/**
	 * 方法说明：按条件查询分页角色表列表
	 */
	public org.alvin.code.gen.utils.Page<RoleFk> queryFkPage(RoleFkCond roleFkCond) {
		roleFkCond.getOrder().put("t.id" , "desc");
		return this.roleDao.queryFkPage(roleFkCond);
	}

}