package org.luna.permission.modules.system.dept;

/**
* 类说明: [部门]--数据访问层
 * @类说明: 收寄信息--
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Repository
public class DeptDao extends org.alvin.code.gen.beans.BaseDao {

    /**
    * 方法说明：  新增部门记录
    */
    public int save(Dept vo) {
	   String sql = "INSERT INTO dept (name,pid,enabled,create_time) VALUES (:name,:pid,:enabled,:createTime)";
	   org.alvin.code.gen.beans.SaveKeyObj obj = saveKey(vo, sql, "id");
       vo.setId((Long)obj.getKey());
       return obj.getRes();
    }
    
    /**
    * 方法说明： 批量插入部门记录
    */
    public int[] insertBatch(java.util.List<Dept> list) {
	   String sql = "INSERT INTO dept (name,pid,enabled,create_time) VALUES (:name,:pid,:enabled,:createTime)";
       return batchOperate(list, sql);
    }
    
    /**
    * 方法说明：物理删除部门记录(多条)
    */
    public int delete(Long id) {
        String sql = "DELETE FROM dept WHERE id = " + id;
        return jdbcTemplate.update(sql);
    }
    
    /**
    * 方法说明：更新部门记录
    */
    public int update(Dept vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE dept SET name=?,pid=?,enabled=?,create_time=? ");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getName(),vo.getPid(),vo.getEnabled(),vo.getCreateTime(),vo.getId()};
        return jdbcTemplate.update(sql.toString(), params);
      }


     /**
    * 方法说明： 更新部门记录,不为空的都更新掉
    */
    public int updateNotNull(Dept vo) {
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
                if(vo.getPid() != null){
            fields.add(" pid = ? ");
            values.add(vo.getPid());
        }   
                if(vo.getEnabled() != null){
            fields.add(" enabled = ? ");
            values.add(vo.getEnabled());
        }   
                if(vo.getCreateTime() != null){
            fields.add(" create_time = ? ");
            values.add(vo.getCreateTime());
        }   
                
        if(fields.isEmpty()){
            return 0;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE dept SET ");
        sql.append(com.google.common.base.Joiner.on(",").join(fields));
        sql.append(" WHERE ");
        Object[] params = values.toArray();
        return jdbcTemplate.update(sql.toString(), params);
      }

        /**
        * 方法说明： 按条件查询分页部门列表
        */
    public org.alvin.code.gen.utils.Page<Dept> queryPage(DeptCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM dept t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        //log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Dept.class);
    }
    
    /**
    * 方法说明：按条件查询不分页部门列表
    */
    public java.util.List<Dept> queryList(DeptCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM dept t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(cond.getCondition());
    	sb.append(cond.getOrderSql());//增加排序子句;
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Dept.class));
    }
    
    /**
    * 方法说明：按ID查找单个部门实体
    */
    public Dept findById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(null));
        sb.append(" FROM dept t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(" AND t.id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Dept.class));
    }
	
	 /**
     * 方法说明：按条件查询一个 收寄信息 对象
     */
    public Dept findOne(DeptCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM dept t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Dept.class));
    }
    
    /**
    * 方法说明：按条件查询部门记录个数
    */
    public long queryCount(DeptCond cond) {
    	String countSql = "SELECT COUNT(1) FROM dept t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
    * 方法说明：按条件查询部门记录个数
    */
    public int deleteLogic(Long id) {
    	String sql = "UPDATE dept SET delete_remark=1 WHERE id = " + id;
    	return jdbcTemplate.update(sql);
    }

    /**
    * 方法说明：查询参数定制
    */
    public String getSelectedItems(DeptCond cond){
        if(cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()){
        return "t.id,t.name,t.pid,t.enabled,t.create_time"; //默认所有字段
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
    public DeptFk findFkById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(null));
        sb.append(" FROM dept t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(" AND t.id=? ");
        return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(DeptFk.class));
    }

    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param cond
     * @return
     */
    public DeptFk findFkOne(DeptFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM dept t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(DeptFk.class));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param cond
     * @return
     */
    public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(DeptFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append("t.id as value ,t.${table.labelCol} as label");
        sb.append(" FROM dept t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(org.alvin.code.gen.beans.SelectOption.class));
    }

    /**
     * 方法说明：按条件查询不分页部门列表 (带关系表标签)
     */
    public java.util.List<DeptFk> queryFkList(DeptFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM dept t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(DeptFk.class));
    }

    /**
     * 方法说明：按条件查询分页部门列表
     */
    public org.alvin.code.gen.utils.Page<DeptFk> queryFkPage(DeptFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM dept t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, DeptFk.class);
    }

    /**
     * @return 方法说明：表连接的所有字段
     */
    public String getFkSelectedItems(DeptCond cond) {
        if (cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append("t.id,t.name,t.pid,t.enabled,t.create_time");
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