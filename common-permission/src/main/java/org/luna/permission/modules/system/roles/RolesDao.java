package org.luna.permission.modules.system.roles;

/**
* 类说明: [用户角色关联]--数据访问层
 * @类说明: 收寄信息--
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Repository
public class RolesDao extends org.alvin.code.gen.beans.BaseDao {

    /**
    * 方法说明：  新增用户角色关联记录
    */
    public int save(Roles vo) {
	   String sql = "INSERT INTO users_roles () VALUES ()";
	   org.alvin.code.gen.beans.SaveKeyObj obj = saveKey(vo, sql, "user_id");
       vo.setUserId((Long)obj.getKey());
       return obj.getRes();
    }
    
    /**
    * 方法说明： 批量插入用户角色关联记录
    */
    public int[] insertBatch(java.util.List<Roles> list) {
	   String sql = "INSERT INTO users_roles () VALUES ()";
       return batchOperate(list, sql);
    }
    
    /**
    * 方法说明：物理删除用户角色关联记录(多条)
    */
    public int delete(Long userId) {
        String sql = "DELETE FROM users_roles WHERE user_id = " + userId;
        return jdbcTemplate.update(sql);
    }
    
    /**
    * 方法说明：更新用户角色关联记录
    */
    public int update(Roles vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE users_roles SET  ");
        sql.append(" WHERE user_id=? ");
        Object[] params = {,vo.getUserId()};
        return jdbcTemplate.update(sql.toString(), params);
      }


     /**
    * 方法说明： 更新用户角色关联记录,不为空的都更新掉
    */
    public int updateNotNull(Roles vo) {
        java.util.List<String> fields = new java.util.ArrayList<>();
        java.util.List<Object> values = new java.util.ArrayList<>();
                if(vo.getUserId() != null){
            fields.add(" user_id = ? ");
            values.add(vo.getUserId());
        }   
                if(vo.getRoleId() != null){
            fields.add(" role_id = ? ");
            values.add(vo.getRoleId());
        }   
                
        if(fields.isEmpty()){
            return 0;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE users_roles SET ");
        sql.append(com.google.common.base.Joiner.on(",").join(fields));
        sql.append(" WHERE ");
        Object[] params = values.toArray();
        return jdbcTemplate.update(sql.toString(), params);
      }

        /**
        * 方法说明： 按条件查询分页用户角色关联列表
        */
    public org.alvin.code.gen.utils.Page<Roles> queryPage(RolesCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM users_roles t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        //log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Roles.class);
    }
    
    /**
    * 方法说明：按条件查询不分页用户角色关联列表
    */
    public java.util.List<Roles> queryList(RolesCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM users_roles t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(cond.getCondition());
    	sb.append(cond.getOrderSql());//增加排序子句;
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Roles.class));
    }
    
    /**
    * 方法说明：按ID查找单个用户角色关联实体
    */
    public Roles findById(Long userId) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(null));
        sb.append(" FROM users_roles t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(" AND t.user_id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{userId}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Roles.class));
    }
	
	 /**
     * 方法说明：按条件查询一个 收寄信息 对象
     */
    public Roles findOne(RolesCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM users_roles t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Roles.class));
    }
    
    /**
    * 方法说明：按条件查询用户角色关联记录个数
    */
    public long queryCount(RolesCond cond) {
    	String countSql = "SELECT COUNT(1) FROM users_roles t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
    * 方法说明：按条件查询用户角色关联记录个数
    */
    public int deleteLogic(Long userId) {
    	String sql = "UPDATE users_roles SET delete_remark=1 WHERE user_id = " + userId;
    	return jdbcTemplate.update(sql);
    }

    /**
    * 方法说明：查询参数定制
    */
    public String getSelectedItems(RolesCond cond){
        if(cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()){
        return "t.user_id,t.role_id"; //默认所有字段
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
     * @param userId
     * @return
     */
    public RolesFk findFkById(Long userId) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(null));
        sb.append(" FROM users_roles t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(" AND t.user_id=? ");
        return jdbcTemplate.queryForObject(sb.toString(), new Object[]{userId}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(RolesFk.class));
    }

    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param cond
     * @return
     */
    public RolesFk findFkOne(RolesFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM users_roles t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(RolesFk.class));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param cond
     * @return
     */
    public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(RolesFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append("t.user_id as value ,t.${table.labelCol} as label");
        sb.append(" FROM users_roles t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(org.alvin.code.gen.beans.SelectOption.class));
    }

    /**
     * 方法说明：按条件查询不分页用户角色关联列表 (带关系表标签)
     */
    public java.util.List<RolesFk> queryFkList(RolesFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM users_roles t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(RolesFk.class));
    }

    /**
     * 方法说明：按条件查询分页用户角色关联列表
     */
    public org.alvin.code.gen.utils.Page<RolesFk> queryFkPage(RolesFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM users_roles t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, RolesFk.class);
    }

    /**
     * @return 方法说明：表连接的所有字段
     */
    public String getFkSelectedItems(RolesCond cond) {
        if (cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append("t.user_id,t.role_id");
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