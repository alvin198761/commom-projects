package org.luna.permission.modules.system.menus;

/**
* 类说明: [角色菜单关联]--数据访问层
 * @类说明: 收寄信息--
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Repository
public class MenusDao extends org.alvin.code.gen.beans.BaseDao {

    /**
    * 方法说明：  新增角色菜单关联记录
    */
    public int save(Menus vo) {
	   String sql = "INSERT INTO roles_menus (menu_id,role_id) VALUES (?,?)";
	  return this.jdbcTemplate.update(sql,new Object[]{vo.getMenuId(),vo.getRoleId()});
    }
    
    /**
    * 方法说明： 批量插入角色菜单关联记录
    */
    public int[] insertBatch(java.util.List<Menus> list) {
	   String sql = "INSERT INTO roles_menus (menu_id,role_id) VALUES (:menuId,:roleId)";
       return batchOperate(list, sql);
    }
    
    /**
    * 方法说明：物理删除角色菜单关联记录(多条)
    */
    public int delete(Long menuId) {
        String sql = "DELETE FROM roles_menus WHERE menu_id = " + menuId;
        return jdbcTemplate.update(sql);
    }
    
    /**
    * 方法说明：更新角色菜单关联记录
    */
    public int update(Menus vo) {
       return 0;
      }


     /**
    * 方法说明： 更新角色菜单关联记录,不为空的都更新掉
    */
    public int updateNotNull(Menus vo) {
        java.util.List<String> fields = new java.util.ArrayList<>();
        java.util.List<Object> values = new java.util.ArrayList<>();
                if(vo.getMenuId() != null){
            fields.add(" menu_id = ? ");
            values.add(vo.getMenuId());
        }   
                if(vo.getRoleId() != null){
            fields.add(" role_id = ? ");
            values.add(vo.getRoleId());
        }   
                
        if(fields.isEmpty()){
            return 0;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE roles_menus SET ");
        sql.append(com.google.common.base.Joiner.on(",").join(fields));
        sql.append(" WHERE ");
        Object[] params = values.toArray();
        return jdbcTemplate.update(sql.toString(), params);
      }

        /**
        * 方法说明： 按条件查询分页角色菜单关联列表
        */
    public org.alvin.code.gen.utils.Page<Menus> queryPage(MenusCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM roles_menus t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        //log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Menus.class);
    }
    
    /**
    * 方法说明：按条件查询不分页角色菜单关联列表
    */
    public java.util.List<Menus> queryList(MenusCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM roles_menus t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(cond.getCondition());
    	sb.append(cond.getOrderSql());//增加排序子句;
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Menus.class));
    }
    
    /**
    * 方法说明：按ID查找单个角色菜单关联实体
    */
    public Menus findById(Long menuId) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(null));
        sb.append(" FROM roles_menus t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(" AND t.menu_id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{menuId}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Menus.class));
    }
	
	 /**
     * 方法说明：按条件查询一个 收寄信息 对象
     */
    public Menus findOne(MenusCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM roles_menus t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Menus.class));
    }
    
    /**
    * 方法说明：按条件查询角色菜单关联记录个数
    */
    public long queryCount(MenusCond cond) {
    	String countSql = "SELECT COUNT(1) FROM roles_menus t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
    * 方法说明：按条件查询角色菜单关联记录个数
    */
    public int deleteLogic(Long menuId) {
    	String sql = "UPDATE roles_menus SET delete_remark=1 WHERE menu_id = " + menuId;
    	return jdbcTemplate.update(sql);
    }

    /**
    * 方法说明：查询参数定制
    */
    public String getSelectedItems(MenusCond cond){
        if(cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()){
        return "t.menu_id,t.role_id"; //默认所有字段
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
     * @param menuId
     * @return
     */
    public MenusFk findFkById(Long menuId) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(null));
        sb.append(" FROM roles_menus t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(" AND t.menu_id=? ");
        return jdbcTemplate.queryForObject(sb.toString(), new Object[]{menuId}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(MenusFk.class));
    }

    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param cond
     * @return
     */
    public MenusFk findFkOne(MenusFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM roles_menus t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(MenusFk.class));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param cond
     * @return
     */
    public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(MenusFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append("t.menu_id as value ,t.${table.labelCol} as label");
        sb.append(" FROM roles_menus t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(org.alvin.code.gen.beans.SelectOption.class));
    }

    /**
     * 方法说明：按条件查询不分页角色菜单关联列表 (带关系表标签)
     */
    public java.util.List<MenusFk> queryFkList(MenusFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM roles_menus t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(MenusFk.class));
    }

    /**
     * 方法说明：按条件查询分页角色菜单关联列表
     */
    public org.alvin.code.gen.utils.Page<MenusFk> queryFkPage(MenusFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM roles_menus t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, MenusFk.class);
    }

    /**
     * @return 方法说明：表连接的所有字段
     */
    public String getFkSelectedItems(MenusCond cond) {
        if (cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append("t.menu_id,t.role_id");
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