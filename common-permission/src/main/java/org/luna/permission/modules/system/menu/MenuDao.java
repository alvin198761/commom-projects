package org.luna.permission.modules.system.menu;

/**
* 类说明: [menu]--数据访问层
 * @类说明: 收寄信息--
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Repository
public class MenuDao extends org.alvin.code.gen.beans.BaseDao {

    /**
    * 方法说明：  新增menu记录
    */
    public int save(Menu vo) {
	   String sql = "INSERT INTO menu (i_frame,name,component,pid,sort,icon,path,cache,hidden,component_name,create_time,permission,type,app_code) VALUES (:iFrame,:name,:component,:pid,:sort,:icon,:path,:cache,:hidden,:componentName,:createTime,:permission,:type,:appCode)";
	   org.alvin.code.gen.beans.SaveKeyObj obj = saveKey(vo, sql, "id");
       vo.setId((Long)obj.getKey());
       return obj.getRes();
    }
    
    /**
    * 方法说明： 批量插入menu记录
    */
    public int[] insertBatch(java.util.List<Menu> list) {
	   String sql = "INSERT INTO menu (i_frame,name,component,pid,sort,icon,path,cache,hidden,component_name,create_time,permission,type,app_code) VALUES (:iFrame,:name,:component,:pid,:sort,:icon,:path,:cache,:hidden,:componentName,:createTime,:permission,:type,:appCode)";
       return batchOperate(list, sql);
    }
    
    /**
    * 方法说明：物理删除menu记录(多条)
    */
    public int delete(Long id) {
        String sql = "DELETE FROM menu WHERE id = " + id;
        return jdbcTemplate.update(sql);
    }
    
    /**
    * 方法说明：更新menu记录
    */
    public int update(Menu vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE menu SET i_frame=?,name=?,component=?,pid=?,sort=?,icon=?,path=?,cache=?,hidden=?,component_name=?,create_time=?,permission=?,type=?,app_code=? ");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getIFrame(),vo.getName(),vo.getComponent(),vo.getPid(),vo.getSort(),vo.getIcon(),vo.getPath(),vo.getCache(),vo.getHidden(),vo.getComponentName(),vo.getCreateTime(),vo.getPermission(),vo.getType(),vo.getAppCode(),vo.getId()};
        return jdbcTemplate.update(sql.toString(), params);
      }


     /**
    * 方法说明： 更新menu记录,不为空的都更新掉
    */
    public int updateNotNull(Menu vo) {
        java.util.List<String> fields = new java.util.ArrayList<>();
        java.util.List<Object> values = new java.util.ArrayList<>();
                if(vo.getId() != null){
            fields.add(" id = ? ");
            values.add(vo.getId());
        }   
                if(vo.getIFrame() != null){
            fields.add(" i_frame = ? ");
            values.add(vo.getIFrame());
        }   
                if(vo.getName() != null){
            fields.add(" name = ? ");
            values.add(vo.getName());
        }   
                if(vo.getComponent() != null){
            fields.add(" component = ? ");
            values.add(vo.getComponent());
        }   
                if(vo.getPid() != null){
            fields.add(" pid = ? ");
            values.add(vo.getPid());
        }   
                if(vo.getSort() != null){
            fields.add(" sort = ? ");
            values.add(vo.getSort());
        }   
                if(vo.getIcon() != null){
            fields.add(" icon = ? ");
            values.add(vo.getIcon());
        }   
                if(vo.getPath() != null){
            fields.add(" path = ? ");
            values.add(vo.getPath());
        }   
                if(vo.getCache() != null){
            fields.add(" cache = ? ");
            values.add(vo.getCache());
        }   
                if(vo.getHidden() != null){
            fields.add(" hidden = ? ");
            values.add(vo.getHidden());
        }   
                if(vo.getComponentName() != null){
            fields.add(" component_name = ? ");
            values.add(vo.getComponentName());
        }   
                if(vo.getCreateTime() != null){
            fields.add(" create_time = ? ");
            values.add(vo.getCreateTime());
        }   
                if(vo.getPermission() != null){
            fields.add(" permission = ? ");
            values.add(vo.getPermission());
        }   
                if(vo.getType() != null){
            fields.add(" type = ? ");
            values.add(vo.getType());
        }   
                if(vo.getAppCode() != null){
            fields.add(" app_code = ? ");
            values.add(vo.getAppCode());
        }   
                
        if(fields.isEmpty()){
            return 0;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE menu SET ");
        sql.append(com.google.common.base.Joiner.on(",").join(fields));
        sql.append(" WHERE ");
        Object[] params = values.toArray();
        return jdbcTemplate.update(sql.toString(), params);
      }

        /**
        * 方法说明： 按条件查询分页menu列表
        */
    public org.alvin.code.gen.utils.Page<Menu> queryPage(MenuCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM menu t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        //log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Menu.class);
    }
    
    /**
    * 方法说明：按条件查询不分页menu列表
    */
    public java.util.List<Menu> queryList(MenuCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM menu t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(cond.getCondition());
    	sb.append(cond.getOrderSql());//增加排序子句;
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Menu.class));
    }
    
    /**
    * 方法说明：按ID查找单个menu实体
    */
    public Menu findById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(null));
        sb.append(" FROM menu t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(" AND t.id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Menu.class));
    }
	
	 /**
     * 方法说明：按条件查询一个 收寄信息 对象
     */
    public Menu findOne(MenuCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM menu t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Menu.class));
    }
    
    /**
    * 方法说明：按条件查询menu记录个数
    */
    public long queryCount(MenuCond cond) {
    	String countSql = "SELECT COUNT(1) FROM menu t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
    * 方法说明：按条件查询menu记录个数
    */
    public int deleteLogic(Long id) {
    	String sql = "UPDATE menu SET delete_remark=1 WHERE id = " + id;
    	return jdbcTemplate.update(sql);
    }

    /**
    * 方法说明：查询参数定制
    */
    public String getSelectedItems(MenuCond cond){
        if(cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()){
        return "t.id,t.i_frame,t.name,t.component,t.pid,t.sort,t.icon,t.path,t.cache,t.hidden,t.component_name,t.create_time,t.permission,t.type,t.app_code"; //默认所有字段
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
    public MenuFk findFkById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(null));
        sb.append(" FROM menu t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(" AND t.id=? ");
        return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(MenuFk.class));
    }

    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param cond
     * @return
     */
    public MenuFk findFkOne(MenuFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM menu t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(MenuFk.class));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param cond
     * @return
     */
    public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(MenuFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append("t.id as value ,t.${table.labelCol} as label");
        sb.append(" FROM menu t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(org.alvin.code.gen.beans.SelectOption.class));
    }

    /**
     * 方法说明：按条件查询不分页menu列表 (带关系表标签)
     */
    public java.util.List<MenuFk> queryFkList(MenuFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM menu t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(MenuFk.class));
    }

    /**
     * 方法说明：按条件查询分页menu列表
     */
    public org.alvin.code.gen.utils.Page<MenuFk> queryFkPage(MenuFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM menu t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, MenuFk.class);
    }

    /**
     * @return 方法说明：表连接的所有字段
     */
    public String getFkSelectedItems(MenuCond cond) {
        if (cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append("t.id,t.i_frame,t.name,t.component,t.pid,t.sort,t.icon,t.path,t.cache,t.hidden,t.component_name,t.create_time,t.permission,t.type,t.app_code");
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