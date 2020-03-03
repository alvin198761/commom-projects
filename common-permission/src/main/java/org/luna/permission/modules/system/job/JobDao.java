package org.luna.permission.modules.system.job;

/**
* 类说明: [岗位]--数据访问层
 * @类说明: 收寄信息--
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Repository
public class JobDao extends org.alvin.code.gen.beans.BaseDao {

    /**
    * 方法说明：  新增岗位记录
    */
    public int save(Job vo) {
	   String sql = "INSERT INTO job (name,enabled,sort,dept_id,create_time) VALUES (:name,:enabled,:sort,:deptId,:createTime)";
	   org.alvin.code.gen.beans.SaveKeyObj obj = saveKey(vo, sql, "id");
       vo.setId((Long)obj.getKey());
       return obj.getRes();
    }
    
    /**
    * 方法说明： 批量插入岗位记录
    */
    public int[] insertBatch(java.util.List<Job> list) {
	   String sql = "INSERT INTO job (name,enabled,sort,dept_id,create_time) VALUES (:name,:enabled,:sort,:deptId,:createTime)";
       return batchOperate(list, sql);
    }
    
    /**
    * 方法说明：物理删除岗位记录(多条)
    */
    public int delete(Long id) {
        String sql = "DELETE FROM job WHERE id = " + id;
        return jdbcTemplate.update(sql);
    }
    
    /**
    * 方法说明：更新岗位记录
    */
    public int update(Job vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE job SET name=?,enabled=?,sort=?,dept_id=?,create_time=? ");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getName(),vo.getEnabled(),vo.getSort(),vo.getDeptId(),vo.getCreateTime(),vo.getId()};
        return jdbcTemplate.update(sql.toString(), params);
      }


     /**
    * 方法说明： 更新岗位记录,不为空的都更新掉
    */
    public int updateNotNull(Job vo) {
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
                if(vo.getEnabled() != null){
            fields.add(" enabled = ? ");
            values.add(vo.getEnabled());
        }   
                if(vo.getSort() != null){
            fields.add(" sort = ? ");
            values.add(vo.getSort());
        }   
                if(vo.getDeptId() != null){
            fields.add(" dept_id = ? ");
            values.add(vo.getDeptId());
        }   
                if(vo.getCreateTime() != null){
            fields.add(" create_time = ? ");
            values.add(vo.getCreateTime());
        }   
                
        if(fields.isEmpty()){
            return 0;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE job SET ");
        sql.append(com.google.common.base.Joiner.on(",").join(fields));
        sql.append(" WHERE ");
        Object[] params = values.toArray();
        return jdbcTemplate.update(sql.toString(), params);
      }

        /**
        * 方法说明： 按条件查询分页岗位列表
        */
    public org.alvin.code.gen.utils.Page<Job> queryPage(JobCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM job t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        //log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Job.class);
    }
    
    /**
    * 方法说明：按条件查询不分页岗位列表
    */
    public java.util.List<Job> queryList(JobCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM job t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(cond.getCondition());
    	sb.append(cond.getOrderSql());//增加排序子句;
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Job.class));
    }
    
    /**
    * 方法说明：按ID查找单个岗位实体
    */
    public Job findById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(null));
        sb.append(" FROM job t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(" AND t.id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Job.class));
    }
	
	 /**
     * 方法说明：按条件查询一个 收寄信息 对象
     */
    public Job findOne(JobCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM job t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Job.class));
    }
    
    /**
    * 方法说明：按条件查询岗位记录个数
    */
    public long queryCount(JobCond cond) {
    	String countSql = "SELECT COUNT(1) FROM job t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
    * 方法说明：按条件查询岗位记录个数
    */
    public int deleteLogic(Long id) {
    	String sql = "UPDATE job SET delete_remark=1 WHERE id = " + id;
    	return jdbcTemplate.update(sql);
    }

    /**
    * 方法说明：查询参数定制
    */
    public String getSelectedItems(JobCond cond){
        if(cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()){
        return "t.id,t.name,t.enabled,t.sort,t.dept_id,t.create_time"; //默认所有字段
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
    public JobFk findFkById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(null));
        sb.append(" FROM job t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(" AND t.id=? ");
        return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(JobFk.class));
    }

    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param cond
     * @return
     */
    public JobFk findFkOne(JobFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM job t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(JobFk.class));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param cond
     * @return
     */
    public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(JobFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append("t.id as value ,t.${table.labelCol} as label");
        sb.append(" FROM job t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(org.alvin.code.gen.beans.SelectOption.class));
    }

    /**
     * 方法说明：按条件查询不分页岗位列表 (带关系表标签)
     */
    public java.util.List<JobFk> queryFkList(JobFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM job t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(JobFk.class));
    }

    /**
     * 方法说明：按条件查询分页岗位列表
     */
    public org.alvin.code.gen.utils.Page<JobFk> queryFkPage(JobFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM job t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, JobFk.class);
    }

    /**
     * @return 方法说明：表连接的所有字段
     */
    public String getFkSelectedItems(JobCond cond) {
        if (cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append("t.id,t.name,t.enabled,t.sort,t.dept_id,t.create_time");
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