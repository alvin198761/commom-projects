package org.luna.permission.modules.system.role;

/**
* 类说明: [角色表]--数据访问层
 * @类说明: 收寄信息--
* @author 唐植超
* 生成日期 2020-03-01 10:01:39
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Repository
public class RoleDao extends org.alvin.code.gen.beans.BaseDao {

    /**
    * 方法说明：  新增角色表记录
    */
    public int save(Role vo) {
	   String sql = "INSERT INTO role (name,remark,data_scope,level,create_time,permission) VALUES (:name,:remark,:dataScope,:level,:createTime,:permission)";
	   org.alvin.code.gen.beans.SaveKeyObj obj = saveKey(vo, sql, "id");
       vo.setId((Long)obj.getKey());
       return obj.getRes();
    }
    
    /**
    * 方法说明： 批量插入角色表记录
    */
    public int[] insertBatch(java.util.List<Role> list) {
	   String sql = "INSERT INTO role (name,remark,data_scope,level,create_time,permission) VALUES (:name,:remark,:dataScope,:level,:createTime,:permission)";
       return batchOperate(list, sql);
    }
    
    /**
    * 方法说明：物理删除角色表记录(多条)
    */
    public int delete(Long id) {
        String sql = "DELETE FROM role WHERE id = " + id;
        return jdbcTemplate.update(sql);
    }
    
    /**
    * 方法说明：更新角色表记录
    */
    public int update(Role vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE role SET name=?,remark=?,data_scope=?,level=?,create_time=?,permission=? ");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getName(),vo.getRemark(),vo.getDataScope(),vo.getLevel(),vo.getCreateTime(),vo.getPermission(),vo.getId()};
        return jdbcTemplate.update(sql.toString(), params);
      }


     /**
    * 方法说明： 更新角色表记录,不为空的都更新掉
    */
    public int updateNotNull(Role vo) {
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
                if(vo.getDataScope() != null){
            fields.add(" data_scope = ? ");
            values.add(vo.getDataScope());
        }   
                if(vo.getLevel() != null){
            fields.add(" level = ? ");
            values.add(vo.getLevel());
        }   
                if(vo.getCreateTime() != null){
            fields.add(" create_time = ? ");
            values.add(vo.getCreateTime());
        }   
                if(vo.getPermission() != null){
            fields.add(" permission = ? ");
            values.add(vo.getPermission());
        }   
                
        if(fields.isEmpty()){
            return 0;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE role SET ");
        sql.append(com.google.common.base.Joiner.on(",").join(fields));
        sql.append(" WHERE ");
        Object[] params = values.toArray();
        return jdbcTemplate.update(sql.toString(), params);
      }

        /**
        * 方法说明： 按条件查询分页角色表列表
        */
    public org.alvin.code.gen.utils.Page<Role> queryPage(RoleCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM role t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        //log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Role.class);
    }
    
    /**
    * 方法说明：按条件查询不分页角色表列表
    */
    public java.util.List<Role> queryList(RoleCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM role t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(cond.getCondition());
    	sb.append(cond.getOrderSql());//增加排序子句;
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Role.class));
    }
    
    /**
    * 方法说明：按ID查找单个角色表实体
    */
    public Role findById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(null));
        sb.append(" FROM role t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(" AND t.id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Role.class));
    }
	
	 /**
     * 方法说明：按条件查询一个 收寄信息 对象
     */
    public Role findOne(RoleCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM role t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Role.class));
    }
    
    /**
    * 方法说明：按条件查询角色表记录个数
    */
    public long queryCount(RoleCond cond) {
    	String countSql = "SELECT COUNT(1) FROM role t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
    * 方法说明：按条件查询角色表记录个数
    */
    public int deleteLogic(Long id) {
    	String sql = "UPDATE role SET delete_remark=1 WHERE id = " + id;
    	return jdbcTemplate.update(sql);
    }

    /**
    * 方法说明：查询参数定制
    */
    public String getSelectedItems(RoleCond cond){
        if(cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()){
        return "t.id,t.name,t.remark,t.data_scope,t.level,t.create_time,t.permission"; //默认所有字段
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
    public RoleFk findFkById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(null));
        sb.append(" FROM role t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(" AND t.id=? ");
        return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(RoleFk.class));
    }

    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param cond
     * @return
     */
    public RoleFk findFkOne(RoleFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM role t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(RoleFk.class));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param cond
     * @return
     */
    public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(RoleFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append("t.id as value ,t.${table.labelCol} as label");
        sb.append(" FROM role t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(org.alvin.code.gen.beans.SelectOption.class));
    }

    /**
     * 方法说明：按条件查询不分页角色表列表 (带关系表标签)
     */
    public java.util.List<RoleFk> queryFkList(RoleFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM role t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(RoleFk.class));
    }

    /**
     * 方法说明：按条件查询分页角色表列表
     */
    public org.alvin.code.gen.utils.Page<RoleFk> queryFkPage(RoleFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM role t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, RoleFk.class);
    }

    /**
     * @return 方法说明：表连接的所有字段
     */
    public String getFkSelectedItems(RoleCond cond) {
        if (cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append("t.id,t.name,t.remark,t.data_scope,t.level,t.create_time,t.permission");
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