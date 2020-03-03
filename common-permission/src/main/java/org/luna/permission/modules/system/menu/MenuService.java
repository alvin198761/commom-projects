package org.luna.permission.modules.system.menu;

/**
* 类说明: [menu]--数据逻辑层
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Service
public class MenuService {

	@org.springframework.beans.factory.annotation.Autowired
	private MenuDao menuDao; //注入收寄信息数据访问层

	/**
	* 方法说明：  新增[menu]记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int save(Menu menu) {
		return this.menuDao.save(menu);
	}

	/**
	* 方法说明：  删除menu记录(多条)
	*/
	@org.springframework.transaction.annotation.Transactional
	public int delete(Long id) {
		//return this.menuDao.deleteLogic(id);//逻辑删除
		return this.menuDao.delete(id);//物理删除
	}

	/**
	* 方法说明：  更新menu记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int update(Menu menu) {
		return this.menuDao.update(menu); 
	}

	 /**
    * 方法说明：更新menu记录,不为空的都更新掉
    */
    @org.springframework.transaction.annotation.Transactional
    public int updateNotNull(Menu menu) {
		return this.menuDao.updateNotNull(menu); 
    }

	/**
	* 方法说明： 按条件查询分页menu列表
	*/
	public org.alvin.code.gen.utils.Page<Menu> queryPage(MenuCond menuCond) {
		menuCond.getOrder().put("t.id" , "desc");
		return this.menuDao.queryPage(menuCond);
	}

	/**
	* 方法说明： 按条件查询不分页menu列表(使用范型)
	*/
	public java.util.List<Menu> queryList(MenuCond menuCond) {
		menuCond.getOrder().put("t.id" , "desc");
		return this.menuDao.queryList(menuCond);
	}
	
	/**
	* 方法说明： 按条件查询一个 menu 对象
	*/
	public Menu findOne(MenuCond menuCond) {
		return this.menuDao.findOne(menuCond);
	}

	/**
	* 方法说明： 按ID查找单个menu记录
	*/
	public Menu findById(Long id) {
		return this.menuDao.findById(id);
	}

	/**
	* 方法说明： 按条件查询menu记录个数
	*/
	public long queryCount(MenuCond menuCond) {
		return this.menuDao.queryCount(menuCond);
	}


	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param id
	 * @return
	 */
	public MenuFk findFkById(Long id) {
		return this.menuDao.findFkById(id);
	}

	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param menuFkCond
	 * @return
	 */
	public MenuFk findFkOne(MenuFkCond menuFkCond) {
		return this.menuDao.findFkOne(menuFkCond);
	}

	/**
	 * 方法说明: 只显示标签和id的列表
	 *
	 * @param menuFkCond
	 * @return
	 */
	public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(MenuFkCond menuFkCond) {
		menuFkCond.getOrder().put("t.id" , "desc");
		return this.menuDao.queryLabelList(menuFkCond);
	}

	/**
	 * 方法说明：按条件查询不分页menu列表 (带关系表标签)
	 */
	public java.util.List<MenuFk> queryFkList(MenuFkCond menuFkCond) {
		menuFkCond.getOrder().put("t.id" , "desc");
		return this.menuDao.queryFkList(menuFkCond);
	}

	/**
	 * 方法说明：按条件查询分页menu列表
	 */
	public org.alvin.code.gen.utils.Page<MenuFk> queryFkPage(MenuFkCond menuFkCond) {
		menuFkCond.getOrder().put("t.id" , "desc");
		return this.menuDao.queryFkPage(menuFkCond);
	}

}