package org.luna.permission.modules.system.depts;

/**
* 类说明: [角色部门关联]--数据访问层
 * @类说明: 收寄信息--
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Repository
public class DeptsDao extends org.alvin.code.gen.beans.BaseDao {

    /**
    * 方法说明：  新增角色部门关联记录
    */
    public int save(Depts vo) {
	   String sql = "INSERT INTO roles_depts (role_id,dept_id) VALUES (?,?)";
	   return this.jdbcTemplate.update(sql,new Object[]{vo.getRoleId(),vo.getDeptId()});
    }
    
    /**
    * 方法说明： 批量插入角色部门关联记录
    */
    public int[] insertBatch(java.util.List<Depts> list) {
	   String sql = "INSERT INTO roles_depts (role_id,dept_id) VALUES (:roleId,deptId)";
       return batchOperate(list, sql);
    }
    
    /**
    * 方法说明：物理删除角色部门关联记录(多条)
    */
    public int delete(Long roleId) {
        String sql = "DELETE FROM roles_depts WHERE role_id = " + roleId;
        return jdbcTemplate.update(sql);
    }
    
    /**
    * 方法说明：更新角色部门关联记录
    */
    public int update(Depts vo) {
       return 0;
      }


     /**
    * 方法说明： 更新角色部门关联记录,不为空的都更新掉
    */
    public int updateNotNull(Depts vo) {
        java.util.List<String> fields = new java.util.ArrayList<>();
        java.util.List<Object> values = new java.util.ArrayList<>();
                if(vo.getRoleId() != null){
            fields.add(" role_id = ? ");
            values.add(vo.getRoleId());
        }   
                if(vo.getDeptId() != null){
            fields.add(" dept_id = ? ");
            values.add(vo.getDeptId());
        }   
                
        if(fields.isEmpty()){
            return 0;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE roles_depts SET ");
        sql.append(com.google.common.base.Joiner.on(",").join(fields));
        sql.append(" WHERE ");
        Object[] params = values.toArray();
        return jdbcTemplate.update(sql.toString(), params);
      }

        /**
        * 方法说明： 按条件查询分页角色部门关联列表
        */
    public org.alvin.code.gen.utils.Page<Depts> queryPage(DeptsCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM roles_depts t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        //log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Depts.class);
    }
    
    /**
    * 方法说明：按条件查询不分页角色部门关联列表
    */
    public java.util.List<Depts> queryList(DeptsCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM roles_depts t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(cond.getCondition());
    	sb.append(cond.getOrderSql());//增加排序子句;
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Depts.class));
    }
    
    /**
    * 方法说明：按ID查找单个角色部门关联实体
    */
    public Depts findById(Long roleId) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(null));
        sb.append(" FROM roles_depts t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(" AND t.role_id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{roleId}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Depts.class));
    }
	
	 /**
     * 方法说明：按条件查询一个 收寄信息 对象
     */
    public Depts findOne(DeptsCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM roles_depts t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Depts.class));
    }
    
    /**
    * 方法说明：按条件查询角色部门关联记录个数
    */
    public long queryCount(DeptsCond cond) {
    	String countSql = "SELECT COUNT(1) FROM roles_depts t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
    * 方法说明：按条件查询角色部门关联记录个数
    */
    public int deleteLogic(Long roleId) {
    	String sql = "UPDATE roles_depts SET delete_remark=1 WHERE role_id = " + roleId;
    	return jdbcTemplate.update(sql);
    }

    /**
    * 方法说明：查询参数定制
    */
    public String getSelectedItems(DeptsCond cond){
        if(cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()){
        return "t.role_id,t.dept_id"; //默认所有字段
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
     * @param roleId
     * @return
     */
    public DeptsFk findFkById(Long roleId) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(null));
        sb.append(" FROM roles_depts t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(" AND t.role_id=? ");
        return jdbcTemplate.queryForObject(sb.toString(), new Object[]{roleId}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(DeptsFk.class));
    }

    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param cond
     * @return
     */
    public DeptsFk findFkOne(DeptsFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM roles_depts t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(DeptsFk.class));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param cond
     * @return
     */
    public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(DeptsFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append("t.role_id as value ,t.${table.labelCol} as label");
        sb.append(" FROM roles_depts t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(org.alvin.code.gen.beans.SelectOption.class));
    }

    /**
     * 方法说明：按条件查询不分页角色部门关联列表 (带关系表标签)
     */
    public java.util.List<DeptsFk> queryFkList(DeptsFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM roles_depts t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(DeptsFk.class));
    }

    /**
     * 方法说明：按条件查询分页角色部门关联列表
     */
    public org.alvin.code.gen.utils.Page<DeptsFk> queryFkPage(DeptsFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM roles_depts t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, DeptsFk.class);
    }

    /**
     * @return 方法说明：表连接的所有字段
     */
    public String getFkSelectedItems(DeptsCond cond) {
        if (cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append("t.role_id,t.dept_id");
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