package org.luna.permission.modules.system.menus;

/**
* 类说明: [角色菜单关联]--数据逻辑层
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Service
public class MenusService {

	@org.springframework.beans.factory.annotation.Autowired
	private MenusDao menusDao; //注入收寄信息数据访问层

	/**
	* 方法说明：  新增[角色菜单关联]记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int save(Menus menus) {
		return this.menusDao.save(menus);
	}

	/**
	* 方法说明：  删除角色菜单关联记录(多条)
	*/
	@org.springframework.transaction.annotation.Transactional
	public int delete(Long menuId) {
		//return this.menusDao.deleteLogic(menuId);//逻辑删除
		return this.menusDao.delete(menuId);//物理删除
	}

	/**
	* 方法说明：  更新角色菜单关联记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int update(Menus menus) {
		return this.menusDao.update(menus); 
	}

	 /**
    * 方法说明：更新角色菜单关联记录,不为空的都更新掉
    */
    @org.springframework.transaction.annotation.Transactional
    public int updateNotNull(Menus menus) {
		return this.menusDao.updateNotNull(menus); 
    }

	/**
	* 方法说明： 按条件查询分页角色菜单关联列表
	*/
	public org.alvin.code.gen.utils.Page<Menus> queryPage(MenusCond menusCond) {
		menusCond.getOrder().put("t.menu_id" , "desc");
		return this.menusDao.queryPage(menusCond);
	}

	/**
	* 方法说明： 按条件查询不分页角色菜单关联列表(使用范型)
	*/
	public java.util.List<Menus> queryList(MenusCond menusCond) {
		menusCond.getOrder().put("t.menu_id" , "desc");
		return this.menusDao.queryList(menusCond);
	}
	
	/**
	* 方法说明： 按条件查询一个 角色菜单关联 对象
	*/
	public Menus findOne(MenusCond menusCond) {
		return this.menusDao.findOne(menusCond);
	}

	/**
	* 方法说明： 按ID查找单个角色菜单关联记录
	*/
	public Menus findById(Long id) {
		return this.menusDao.findById(id);
	}

	/**
	* 方法说明： 按条件查询角色菜单关联记录个数
	*/
	public long queryCount(MenusCond menusCond) {
		return this.menusDao.queryCount(menusCond);
	}


	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param id
	 * @return
	 */
	public MenusFk findFkById(Long id) {
		return this.menusDao.findFkById(id);
	}

	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param menusFkCond
	 * @return
	 */
	public MenusFk findFkOne(MenusFkCond menusFkCond) {
		return this.menusDao.findFkOne(menusFkCond);
	}

	/**
	 * 方法说明: 只显示标签和id的列表
	 *
	 * @param menusFkCond
	 * @return
	 */
	public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(MenusFkCond menusFkCond) {
		menusFkCond.getOrder().put("t.menu_id" , "desc");
		return this.menusDao.queryLabelList(menusFkCond);
	}

	/**
	 * 方法说明：按条件查询不分页角色菜单关联列表 (带关系表标签)
	 */
	public java.util.List<MenusFk> queryFkList(MenusFkCond menusFkCond) {
		menusFkCond.getOrder().put("t.menu_id" , "desc");
		return this.menusDao.queryFkList(menusFkCond);
	}

	/**
	 * 方法说明：按条件查询分页角色菜单关联列表
	 */
	public org.alvin.code.gen.utils.Page<MenusFk> queryFkPage(MenusFkCond menusFkCond) {
		menusFkCond.getOrder().put("t.menu_id" , "desc");
		return this.menusDao.queryFkPage(menusFkCond);
	}

}