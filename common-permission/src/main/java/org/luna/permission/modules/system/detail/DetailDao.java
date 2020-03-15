package org.luna.permission.modules.system.detail;

/**
 * 类说明: [数据字典详情]--数据访问层
 *
 * @author 唐植超
 * 生成日期 2020-03-09 22:33:12
 * @类说明: 收寄信息--
 **/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Repository
public class DetailDao extends org.alvin.code.gen.beans.BaseDao {

    /**
     * 方法说明：  新增数据字典详情记录
     */
    public int save(Detail vo) {
        String sql = "INSERT INTO dict_detail (label,value,sort,dict_id,create_time) VALUES (:label,:value,:sort,:dictId,:createTime)";
        org.alvin.code.gen.beans.SaveKeyObj obj = saveKey(vo, sql, "id");
        vo.setId((Long) obj.getKey());
        return obj.getRes();
    }

    /**
     * 方法说明： 批量插入数据字典详情记录
     */
    public int[] insertBatch(java.util.List<Detail> list) {
        String sql = "INSERT INTO dict_detail (label,value,sort,dict_id,create_time) VALUES (:label,:value,:sort,:dictId,:createTime)";
        return batchOperate(list, sql);
    }

    /**
     * 方法说明：物理删除数据字典详情记录(多条)
     */
    public int delete(Long id) {
        String sql = "DELETE FROM dict_detail WHERE id = " + id;
        return jdbcTemplate.update(sql);
    }

    /**
     * 方法说明：更新数据字典详情记录
     */
    public int update(Detail vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE dict_detail SET label=?,value=?,sort=?,dict_id=?,create_time=? ");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getLabel(), vo.getValue(), vo.getSort(), vo.getDictId(), vo.getCreateTime(), vo.getId()};
        return jdbcTemplate.update(sql.toString(), params);
    }


    /**
     * 方法说明： 更新数据字典详情记录,不为空的都更新掉
     */
    public int updateNotNull(Detail vo) {
        java.util.List<String> fields = new java.util.ArrayList<>();
        java.util.List<Object> values = new java.util.ArrayList<>();
        if (vo.getId() != null) {
            fields.add(" id = ? ");
            values.add(vo.getId());
        }
        if (vo.getLabel() != null) {
            fields.add(" label = ? ");
            values.add(vo.getLabel());
        }
        if (vo.getValue() != null) {
            fields.add(" value = ? ");
            values.add(vo.getValue());
        }
        if (vo.getSort() != null) {
            fields.add(" sort = ? ");
            values.add(vo.getSort());
        }
        if (vo.getDictId() != null) {
            fields.add(" dict_id = ? ");
            values.add(vo.getDictId());
        }
        if (vo.getCreateTime() != null) {
            fields.add(" create_time = ? ");
            values.add(vo.getCreateTime());
        }

        if (fields.isEmpty()) {
            return 0;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE dict_detail SET ");
        sql.append(com.google.common.base.Joiner.on(",").join(fields));
        sql.append(" WHERE ");
        Object[] params = values.toArray();
        return jdbcTemplate.update(sql.toString(), params);
    }

    /**
     * 方法说明： 按条件查询分页数据字典详情列表
     */
    public org.alvin.code.gen.utils.Page<Detail> queryPage(DetailCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM dict_detail t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Detail.class);
    }

    /**
     * 方法说明：按条件查询不分页数据字典详情列表
     */
    public java.util.List<Detail> queryList(DetailCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM dict_detail t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Detail.class));
    }

    /**
     * 方法说明：按ID查找单个数据字典详情实体
     */
    public Detail findById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(null));
        sb.append(" FROM dict_detail t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(" AND t.id=?");
        return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Detail.class));
    }

    /**
     * 方法说明：按条件查询一个 收寄信息 对象
     */
    public Detail findOne(DetailCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM dict_detail t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Detail.class));
    }

    /**
     * 方法说明：按条件查询数据字典详情记录个数
     */
    public long queryCount(DetailCond cond) {
        String countSql = "SELECT COUNT(1) FROM dict_detail t WHERE 1=1" + cond.getCondition();
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(countSql.toString(),cond.getArray()));//显示SQL语句
        return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }

    /**
     * 方法说明：按条件查询数据字典详情记录个数
     */
    public int deleteLogic(Long id) {
        String sql = "UPDATE dict_detail SET delete_remark=1 WHERE id = " + id;
        return jdbcTemplate.update(sql);
    }

    /**
     * 方法说明：查询参数定制
     */
    public String getSelectedItems(DetailCond cond) {
        if (cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()) {
            return "t.id,t.label,t.value,t.sort,t.dict_id,t.create_time,d.name as dict_name"; //默认所有字段
        }
        return com.google.common.base.Joiner.on(",").join(cond.getSelectedFields());
    }

    /**
     * 方法说明：表连接代码
     *
     * @return
     */
    public String getJoinTables() {
        return " left join dict d on t.dict_id = d.id ";
    }

    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param id
     * @return
     */
    public DetailFk findFkById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(null));
        sb.append(" FROM dict_detail t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(" AND t.id=? ");
        return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(DetailFk.class));
    }

    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param cond
     * @return
     */
    public DetailFk findFkOne(DetailFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM dict_detail t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(DetailFk.class));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param cond
     * @return
     */
    public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(DetailFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append("t.id as value ,t.${table.labelCol} as label");
        sb.append(" FROM dict_detail t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(org.alvin.code.gen.beans.SelectOption.class));
    }

    /**
     * 方法说明：按条件查询不分页数据字典详情列表 (带关系表标签)
     */
    public java.util.List<DetailFk> queryFkList(DetailFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM dict_detail t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(DetailFk.class));
    }

    /**
     * 方法说明：按条件查询分页数据字典详情列表
     */
    public org.alvin.code.gen.utils.Page<DetailFk> queryFkPage(DetailFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM dict_detail t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, DetailFk.class);
    }

    /**
     * @return 方法说明：表连接的所有字段
     */
    public String getFkSelectedItems(DetailCond cond) {
        if (cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("t.id,t.label,t.value,t.sort,t.dict_id,t.create_time");
            return sb.toString(); //默认所有字段
        }
        return com.google.common.base.Joiner.on(",").join(cond.getSelectedFields());
    }

    /**
     * @return 方法说明：表连接代码
     */
    public String getFkJoinTables() {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }

}