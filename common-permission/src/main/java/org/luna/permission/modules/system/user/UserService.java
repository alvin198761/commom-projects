package org.luna.permission.modules.system.user;

/**
* 类说明: [系统用户]--数据逻辑层
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Service
public class UserService {

	@org.springframework.beans.factory.annotation.Autowired
	private UserDao userDao; //注入收寄信息数据访问层

	/**
	* 方法说明：  新增[系统用户]记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int save(User user) {
		return this.userDao.save(user);
	}

	/**
	* 方法说明：  删除系统用户记录(多条)
	*/
	@org.springframework.transaction.annotation.Transactional
	public int delete(Long id) {
		//return this.userDao.deleteLogic(id);//逻辑删除
		return this.userDao.delete(id);//物理删除
	}

	/**
	* 方法说明：  更新系统用户记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int update(User user) {
		return this.userDao.update(user); 
	}

	 /**
    * 方法说明：更新系统用户记录,不为空的都更新掉
    */
    @org.springframework.transaction.annotation.Transactional
    public int updateNotNull(User user) {
		return this.userDao.updateNotNull(user); 
    }

	/**
	* 方法说明： 按条件查询分页系统用户列表
	*/
	public org.alvin.code.gen.utils.Page<User> queryPage(UserCond userCond) {
		userCond.getOrder().put("t.id" , "desc");
		return this.userDao.queryPage(userCond);
	}

	/**
	* 方法说明： 按条件查询不分页系统用户列表(使用范型)
	*/
	public java.util.List<User> queryList(UserCond userCond) {
		userCond.getOrder().put("t.id" , "desc");
		return this.userDao.queryList(userCond);
	}
	
	/**
	* 方法说明： 按条件查询一个 系统用户 对象
	*/
	public User findOne(UserCond userCond) {
		return this.userDao.findOne(userCond);
	}

	/**
	* 方法说明： 按ID查找单个系统用户记录
	*/
	public User findById(Long id) {
		return this.userDao.findById(id);
	}

	/**
	* 方法说明： 按条件查询系统用户记录个数
	*/
	public long queryCount(UserCond userCond) {
		return this.userDao.queryCount(userCond);
	}


	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param id
	 * @return
	 */
	public UserFk findFkById(Long id) {
		return this.userDao.findFkById(id);
	}

	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param userFkCond
	 * @return
	 */
	public UserFk findFkOne(UserFkCond userFkCond) {
		return this.userDao.findFkOne(userFkCond);
	}

	/**
	 * 方法说明: 只显示标签和id的列表
	 *
	 * @param userFkCond
	 * @return
	 */
	public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(UserFkCond userFkCond) {
		userFkCond.getOrder().put("t.id" , "desc");
		return this.userDao.queryLabelList(userFkCond);
	}

	/**
	 * 方法说明：按条件查询不分页系统用户列表 (带关系表标签)
	 */
	public java.util.List<UserFk> queryFkList(UserFkCond userFkCond) {
		userFkCond.getOrder().put("t.id" , "desc");
		return this.userDao.queryFkList(userFkCond);
	}

	/**
	 * 方法说明：按条件查询分页系统用户列表
	 */
	public org.alvin.code.gen.utils.Page<UserFk> queryFkPage(UserFkCond userFkCond) {
		userFkCond.getOrder().put("t.id" , "desc");
		return this.userDao.queryFkPage(userFkCond);
	}

}