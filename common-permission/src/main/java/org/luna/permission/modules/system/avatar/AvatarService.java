package org.luna.permission.modules.system.avatar;

/**
* 类说明: [系统用户头像]--数据逻辑层
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Service
public class AvatarService {

	@org.springframework.beans.factory.annotation.Autowired
	private AvatarDao avatarDao; //注入收寄信息数据访问层

	/**
	* 方法说明：  新增[系统用户头像]记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int save(Avatar avatar) {
		return this.avatarDao.save(avatar);
	}

	/**
	* 方法说明：  删除系统用户头像记录(多条)
	*/
	@org.springframework.transaction.annotation.Transactional
	public int delete(Long id) {
		//return this.avatarDao.deleteLogic(id);//逻辑删除
		return this.avatarDao.delete(id);//物理删除
	}

	/**
	* 方法说明：  更新系统用户头像记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int update(Avatar avatar) {
		return this.avatarDao.update(avatar); 
	}

	 /**
    * 方法说明：更新系统用户头像记录,不为空的都更新掉
    */
    @org.springframework.transaction.annotation.Transactional
    public int updateNotNull(Avatar avatar) {
		return this.avatarDao.updateNotNull(avatar); 
    }

	/**
	* 方法说明： 按条件查询分页系统用户头像列表
	*/
	public org.alvin.code.gen.utils.Page<Avatar> queryPage(AvatarCond avatarCond) {
		avatarCond.getOrder().put("t.id" , "desc");
		return this.avatarDao.queryPage(avatarCond);
	}

	/**
	* 方法说明： 按条件查询不分页系统用户头像列表(使用范型)
	*/
	public java.util.List<Avatar> queryList(AvatarCond avatarCond) {
		avatarCond.getOrder().put("t.id" , "desc");
		return this.avatarDao.queryList(avatarCond);
	}
	
	/**
	* 方法说明： 按条件查询一个 系统用户头像 对象
	*/
	public Avatar findOne(AvatarCond avatarCond) {
		return this.avatarDao.findOne(avatarCond);
	}

	/**
	* 方法说明： 按ID查找单个系统用户头像记录
	*/
	public Avatar findById(Long id) {
		return this.avatarDao.findById(id);
	}

	/**
	* 方法说明： 按条件查询系统用户头像记录个数
	*/
	public long queryCount(AvatarCond avatarCond) {
		return this.avatarDao.queryCount(avatarCond);
	}


	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param id
	 * @return
	 */
	public AvatarFk findFkById(Long id) {
		return this.avatarDao.findFkById(id);
	}

	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param avatarFkCond
	 * @return
	 */
	public AvatarFk findFkOne(AvatarFkCond avatarFkCond) {
		return this.avatarDao.findFkOne(avatarFkCond);
	}

	/**
	 * 方法说明: 只显示标签和id的列表
	 *
	 * @param avatarFkCond
	 * @return
	 */
	public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(AvatarFkCond avatarFkCond) {
		avatarFkCond.getOrder().put("t.id" , "desc");
		return this.avatarDao.queryLabelList(avatarFkCond);
	}

	/**
	 * 方法说明：按条件查询不分页系统用户头像列表 (带关系表标签)
	 */
	public java.util.List<AvatarFk> queryFkList(AvatarFkCond avatarFkCond) {
		avatarFkCond.getOrder().put("t.id" , "desc");
		return this.avatarDao.queryFkList(avatarFkCond);
	}

	/**
	 * 方法说明：按条件查询分页系统用户头像列表
	 */
	public org.alvin.code.gen.utils.Page<AvatarFk> queryFkPage(AvatarFkCond avatarFkCond) {
		avatarFkCond.getOrder().put("t.id" , "desc");
		return this.avatarDao.queryFkPage(avatarFkCond);
	}

}