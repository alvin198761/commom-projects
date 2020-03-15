package org.luna.permission.modules.system.dept;

import com.google.common.collect.Lists;
import org.luna.permission.modules.beans.TreeNodeBean;
import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 类说明: [部门]--数据逻辑层
 *
 * @author 唐植超
 * 生成日期 2020-03-09 22:33:12
 **/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Service
public class DeptService {

    @org.springframework.beans.factory.annotation.Autowired
    private DeptDao deptDao; //注入收寄信息数据访问层

    /**
     * 方法说明：  新增[部门]记录
     */
    @org.springframework.transaction.annotation.Transactional
    public int save(Dept dept) {
        return this.deptDao.save(dept);
    }

    /**
     * 方法说明：  删除部门记录(多条)
     */
    @org.springframework.transaction.annotation.Transactional
    public int delete(Long id) {
        //return this.deptDao.deleteLogic(id);//逻辑删除
        return this.deptDao.delete(id);//物理删除
    }

    /**
     * 方法说明：  更新部门记录
     */
    @org.springframework.transaction.annotation.Transactional
    public int update(Dept dept) {
        return this.deptDao.update(dept);
    }

    /**
     * 方法说明：更新部门记录,不为空的都更新掉
     */
    @org.springframework.transaction.annotation.Transactional
    public int updateNotNull(Dept dept) {
        return this.deptDao.updateNotNull(dept);
    }

    /**
     * 方法说明： 按条件查询分页部门列表
     */
    public org.alvin.code.gen.utils.Page<Dept> queryPage(DeptCond deptCond) {
        deptCond.getOrder().put("t.id", "desc");
        return this.deptDao.queryPage(deptCond);
    }

    /**
     * 方法说明： 按条件查询不分页部门列表(使用范型)
     */
    public java.util.List<Dept> queryList(DeptCond deptCond) {
        deptCond.getOrder().put("t.id", "desc");
        return this.deptDao.queryList(deptCond);
    }

    /**
     * 方法说明： 按条件查询一个 部门 对象
     */
    public Dept findOne(DeptCond deptCond) {
        return this.deptDao.findOne(deptCond);
    }

    /**
     * 方法说明： 按ID查找单个部门记录
     */
    public Dept findById(Long id) {
        return this.deptDao.findById(id);
    }

    /**
     * 方法说明： 按条件查询部门记录个数
     */
    public long queryCount(DeptCond deptCond) {
        return this.deptDao.queryCount(deptCond);
    }


    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param id
     * @return
     */
    public DeptFk findFkById(Long id) {
        return this.deptDao.findFkById(id);
    }

    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param deptFkCond
     * @return
     */
    public DeptFk findFkOne(DeptFkCond deptFkCond) {
        return this.deptDao.findFkOne(deptFkCond);
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param deptFkCond
     * @return
     */
    public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(DeptFkCond deptFkCond) {
        deptFkCond.getOrder().put("t.id", "desc");
        return this.deptDao.queryLabelList(deptFkCond);
    }

    /**
     * 方法说明：按条件查询不分页部门列表 (带关系表标签)
     */
    public java.util.List<DeptFk> queryFkList(DeptFkCond deptFkCond) {
        deptFkCond.getOrder().put("t.id", "desc");
        return this.deptDao.queryFkList(deptFkCond);
    }

    /**
     * 方法说明：按条件查询分页部门列表
     */
    public org.alvin.code.gen.utils.Page<DeptFk> queryFkPage(DeptFkCond deptFkCond) {
        deptFkCond.getOrder().put("t.id", "desc");
        return this.deptDao.queryFkPage(deptFkCond);
    }

    /**
     * 方法说明：树节点展示部门
     */
    public List<TreeNodeBean> queryTreeList(DeptCond cond) {
        List<TreeNodeBean> depts = this.deptDao.queryList(cond).parallelStream().map(item ->{
            TreeNodeBean node = new TreeNodeBean();
            node.setValue(item.getId());
            node.setPid(item.getPid());
            return node;
        }).collect(Collectors.toList());
        for (TreeNodeBean dept : depts) {
            for (TreeNodeBean subDept : depts) {
                if (subDept.getPid().longValue() != dept.getValue().longValue()) {
                    continue;
                }
                if (dept.getChildren() == null) {
                    dept.setChildren(Lists.newArrayList());
                }
                dept.getChildren().add(subDept);
            }
            dept.setHasChildren(dept.getChildren() != null);
        }
        return depts.parallelStream().filter(item -> item.getPid() == 0).collect(Collectors.toList());
    }
}