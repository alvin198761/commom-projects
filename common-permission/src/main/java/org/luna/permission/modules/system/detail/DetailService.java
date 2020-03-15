package org.luna.permission.modules.system.detail;

/**
 * 类说明: [数据字典详情]--数据逻辑层
 *
 * @author 唐植超
 * 生成日期 2020-03-09 22:33:12
 **/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Service
public class DetailService {

    @org.springframework.beans.factory.annotation.Autowired
    private DetailDao detailDao; //注入收寄信息数据访问层

    /**
     * 方法说明：  新增[数据字典详情]记录
     */
    @org.springframework.transaction.annotation.Transactional
    public int save(Detail detail) {
        DetailCond detailCond = new DetailCond();
        detailCond.setDictId(detail.getDictId());
        detailCond.setLabelEq(detail.getLabel());
        if (this.queryCount(detailCond) > 0) {
            throw new javax.validation.ValidationException("该字典已经存在同名标签");
        }
        return this.detailDao.save(detail);
    }

    /**
     * 方法说明：  删除数据字典详情记录(多条)
     */
    @org.springframework.transaction.annotation.Transactional
    public int delete(Long id) {
        //return this.detailDao.deleteLogic(id);//逻辑删除
        return this.detailDao.delete(id);//物理删除
    }

    /**
     * 方法说明：  更新数据字典详情记录
     */
    @org.springframework.transaction.annotation.Transactional
    public int update(Detail detail) {
        DetailCond detailCond = new DetailCond();
        detailCond.setDictId(detail.getDictId());
        detailCond.setLabelEq(detail.getLabel());
        detailCond.setIdNotEq(detail.getId());
        if (this.queryCount(detailCond) > 0) {
            throw new javax.validation.ValidationException("该字典已经存在同名标签");
        }
        return this.detailDao.update(detail);
    }

    /**
     * 方法说明：更新数据字典详情记录,不为空的都更新掉
     */
    @org.springframework.transaction.annotation.Transactional
    public int updateNotNull(Detail detail) {
//        return this.detailDao.updateNotNull(detail);
        return 0;
    }

    /**
     * 方法说明： 按条件查询分页数据字典详情列表
     */
    public org.alvin.code.gen.utils.Page<Detail> queryPage(DetailCond detailCond) {
        detailCond.getOrder().put("t.sort", "asc");
        return this.detailDao.queryPage(detailCond);
    }

    /**
     * 方法说明： 按条件查询不分页数据字典详情列表(使用范型)
     */
    public java.util.List<Detail> queryList(DetailCond detailCond) {
        detailCond.getOrder().put("t.id", "desc");
        return this.detailDao.queryList(detailCond);
    }

    /**
     * 方法说明： 按条件查询一个 数据字典详情 对象
     */
    public Detail findOne(DetailCond detailCond) {
        return this.detailDao.findOne(detailCond);
    }

    /**
     * 方法说明： 按ID查找单个数据字典详情记录
     */
    public Detail findById(Long id) {
        return this.detailDao.findById(id);
    }

    /**
     * 方法说明： 按条件查询数据字典详情记录个数
     */
    public long queryCount(DetailCond detailCond) {
        return this.detailDao.queryCount(detailCond);
    }


    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param id
     * @return
     */
    public DetailFk findFkById(Long id) {
        return this.detailDao.findFkById(id);
    }

    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param detailFkCond
     * @return
     */
    public DetailFk findFkOne(DetailFkCond detailFkCond) {
        return this.detailDao.findFkOne(detailFkCond);
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param detailFkCond
     * @return
     */
    public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(DetailFkCond detailFkCond) {
        detailFkCond.getOrder().put("t.id", "desc");
        return this.detailDao.queryLabelList(detailFkCond);
    }

    /**
     * 方法说明：按条件查询不分页数据字典详情列表 (带关系表标签)
     */
    public java.util.List<DetailFk> queryFkList(DetailFkCond detailFkCond) {
        detailFkCond.getOrder().put("t.id", "desc");
        return this.detailDao.queryFkList(detailFkCond);
    }

    /**
     * 方法说明：按条件查询分页数据字典详情列表
     */
    public org.alvin.code.gen.utils.Page<DetailFk> queryFkPage(DetailFkCond detailFkCond) {
        detailFkCond.getOrder().put("t.id", "desc");
        return this.detailDao.queryFkPage(detailFkCond);
    }

}