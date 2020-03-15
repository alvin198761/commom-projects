package org.luna.permission.modules.system.dict;

/**
* 类说明: [数据字典]--数据访问层
 * @类说明: 收寄信息--
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Repository
public class DictDao extends org.alvin.code.gen.beans.BaseDao {

    /**
    * 方法说明：  新增数据字典记录
    */
    public int save(Dict vo) {
	   String sql = "INSERT INTO dict (name,remark,create_time) VALUES (:name,:remark,:createTime)";
	   org.alvin.code.gen.beans.SaveKeyObj obj = saveKey(vo, sql, "id");
       vo.setId((Long)obj.getKey());
       return obj.getRes();
    }
    
    /**
    * 方法说明： 批量插入数据字典记录
    */
    public int[] insertBatch(java.util.List<Dict> list) {
	   String sql = "INSERT INTO dict (name,remark,create_time) VALUES (:name,:remark,:createTime)";
       return batchOperate(list, sql);
    }
    
    /**
    * 方法说明：物理删除数据字典记录(多条)
    */
    public int delete(Long id) {
        String sql = "DELETE FROM dict WHERE id = " + id;
        return jdbcTemplate.update(sql);
    }
    
    /**
    * 方法说明：更新数据字典记录
    */
    public int update(Dict vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE dict SET name=?,remark=?,create_time=? ");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getName(),vo.getRemark(),vo.getCreateTime(),vo.getId()};
        return jdbcTemplate.update(sql.toString(), params);
      }


     /**
    * 方法说明： 更新数据字典记录,不为空的都更新掉
    */
    public int updateNotNull(Dict vo) {
        java.util.List<String> fields = new java.util.ArrayList<>();
        java.util.List<Object> values = new java.util.ArrayList<>();
                if(vo.getId() != null){
            fields.add(" id = ? ");
            values.add(vo.getId());
        }   
                if(vo.getName() != null){
            fields.add(" name = ? ");
            values.add(vo.getName());
        }   
                if(vo.getRemark() != null){
            fields.add(" remark = ? ");
            values.add(vo.getRemark());
        }   
                if(vo.getCreateTime() != null){
            fields.add(" create_time = ? ");
            values.add(vo.getCreateTime());
        }   
                
        if(fields.isEmpty()){
            return 0;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE dict SET ");
        sql.append(com.google.common.base.Joiner.on(",").join(fields));
        sql.append(" WHERE ");
        Object[] params = values.toArray();
        return jdbcTemplate.update(sql.toString(), params);
      }

        /**
        * 方法说明： 按条件查询分页数据字典列表
        */
    public org.alvin.code.gen.utils.Page<Dict> queryPage(DictCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM dict t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        //log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Dict.class);
    }
    
    /**
    * 方法说明：按条件查询不分页数据字典列表
    */
    public java.util.List<Dict> queryList(DictCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM dict t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(cond.getCondition());
    	sb.append(cond.getOrderSql());//增加排序子句;
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Dict.class));
    }
    
    /**
    * 方法说明：按ID查找单个数据字典实体
    */
    public Dict findById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(null));
        sb.append(" FROM dict t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(" AND t.id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Dict.class));
    }
	
	 /**
     * 方法说明：按条件查询一个 收寄信息 对象
     */
    public Dict findOne(DictCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM dict t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Dict.class));
    }
    
    /**
    * 方法说明：按条件查询数据字典记录个数
    */
    public long queryCount(DictCond cond) {
    	String countSql = "SELECT COUNT(1) FROM dict t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
    * 方法说明：按条件查询数据字典记录个数
    */
    public int deleteLogic(Long id) {
    	String sql = "UPDATE dict SET delete_remark=1 WHERE id = " + id;
    	return jdbcTemplate.update(sql);
    }

    /**
    * 方法说明：查询参数定制
    */
    public String getSelectedItems(DictCond cond){
        if(cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()){
        return "t.id,t.name,t.remark,t.create_time"; //默认所有字段
        }
        return com.google.common.base.Joiner.on(",").join(cond.getSelectedFields());
    }

    /**
    * 方法说明：表连接代码
    * @return
    */
    public String getJoinTables(){
        return "";
    }

    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param id
     * @return
     */
    public DictFk findFkById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(null));
        sb.append(" FROM dict t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(" AND t.id=? ");
        return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(DictFk.class));
    }

    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param cond
     * @return
     */
    public DictFk findFkOne(DictFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM dict t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(DictFk.class));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param cond
     * @return
     */
    public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(DictFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append("t.id as value ,t.${table.labelCol} as label");
        sb.append(" FROM dict t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(org.alvin.code.gen.beans.SelectOption.class));
    }

    /**
     * 方法说明：按条件查询不分页数据字典列表 (带关系表标签)
     */
    public java.util.List<DictFk> queryFkList(DictFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM dict t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(DictFk.class));
    }

    /**
     * 方法说明：按条件查询分页数据字典列表
     */
    public org.alvin.code.gen.utils.Page<DictFk> queryFkPage(DictFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM dict t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, DictFk.class);
    }

    /**
     * @return 方法说明：表连接的所有字段
     */
    public String getFkSelectedItems(DictCond cond) {
        if (cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append("t.id,t.name,t.remark,t.create_time");
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