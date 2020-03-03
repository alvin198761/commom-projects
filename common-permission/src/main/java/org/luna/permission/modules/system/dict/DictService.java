package org.luna.permission.modules.system.dict;

/**
* 类说明: [数据字典]--数据逻辑层
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Service
public class DictService {

	@org.springframework.beans.factory.annotation.Autowired
	private DictDao dictDao; //注入收寄信息数据访问层

	/**
	* 方法说明：  新增[数据字典]记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int save(Dict dict) {
		return this.dictDao.save(dict);
	}

	/**
	* 方法说明：  删除数据字典记录(多条)
	*/
	@org.springframework.transaction.annotation.Transactional
	public int delete(Long id) {
		//return this.dictDao.deleteLogic(id);//逻辑删除
		return this.dictDao.delete(id);//物理删除
	}

	/**
	* 方法说明：  更新数据字典记录
	*/
	@org.springframework.transaction.annotation.Transactional
	public int update(Dict dict) {
		return this.dictDao.update(dict); 
	}

	 /**
    * 方法说明：更新数据字典记录,不为空的都更新掉
    */
    @org.springframework.transaction.annotation.Transactional
    public int updateNotNull(Dict dict) {
		return this.dictDao.updateNotNull(dict); 
    }

	/**
	* 方法说明： 按条件查询分页数据字典列表
	*/
	public org.alvin.code.gen.utils.Page<Dict> queryPage(DictCond dictCond) {
		dictCond.getOrder().put("t.id" , "desc");
		return this.dictDao.queryPage(dictCond);
	}

	/**
	* 方法说明： 按条件查询不分页数据字典列表(使用范型)
	*/
	public java.util.List<Dict> queryList(DictCond dictCond) {
		dictCond.getOrder().put("t.id" , "desc");
		return this.dictDao.queryList(dictCond);
	}
	
	/**
	* 方法说明： 按条件查询一个 数据字典 对象
	*/
	public Dict findOne(DictCond dictCond) {
		return this.dictDao.findOne(dictCond);
	}

	/**
	* 方法说明： 按ID查找单个数据字典记录
	*/
	public Dict findById(Long id) {
		return this.dictDao.findById(id);
	}

	/**
	* 方法说明： 按条件查询数据字典记录个数
	*/
	public long queryCount(DictCond dictCond) {
		return this.dictDao.queryCount(dictCond);
	}


	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param id
	 * @return
	 */
	public DictFk findFkById(Long id) {
		return this.dictDao.findFkById(id);
	}

	/**
	 * 方法说明: 查询数据包含外键对象和显示标签
	 *
	 * @param dictFkCond
	 * @return
	 */
	public DictFk findFkOne(DictFkCond dictFkCond) {
		return this.dictDao.findFkOne(dictFkCond);
	}

	/**
	 * 方法说明: 只显示标签和id的列表
	 *
	 * @param dictFkCond
	 * @return
	 */
	public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(DictFkCond dictFkCond) {
		dictFkCond.getOrder().put("t.id" , "desc");
		return this.dictDao.queryLabelList(dictFkCond);
	}

	/**
	 * 方法说明：按条件查询不分页数据字典列表 (带关系表标签)
	 */
	public java.util.List<DictFk> queryFkList(DictFkCond dictFkCond) {
		dictFkCond.getOrder().put("t.id" , "desc");
		return this.dictDao.queryFkList(dictFkCond);
	}

	/**
	 * 方法说明：按条件查询分页数据字典列表
	 */
	public org.alvin.code.gen.utils.Page<DictFk> queryFkPage(DictFkCond dictFkCond) {
		dictFkCond.getOrder().put("t.id" , "desc");
		return this.dictDao.queryFkPage(dictFkCond);
	}

}