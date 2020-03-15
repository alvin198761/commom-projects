package org.luna.permission.modules.system.user;

/**
* 类说明: [系统用户]--数据访问层
 * @类说明: 收寄信息--
* @author 唐植超
* 生成日期 2020-03-09 22:33:12
**/
@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Repository
public class UserDao extends org.alvin.code.gen.beans.BaseDao {

    /**
    * 方法说明：  新增系统用户记录
    */
    public int save(User vo) {
	   String sql = "INSERT INTO user (avatar_id,email,enabled,password,username,dept_id,phone,job_id,create_time,last_password_reset_time,nick_name,sex) VALUES (:avatarId,:email,:enabled,:password,:username,:deptId,:phone,:jobId,:createTime,:lastPasswordResetTime,:nickName,:sex)";
	   org.alvin.code.gen.beans.SaveKeyObj obj = saveKey(vo, sql, "id");
       vo.setId((Long)obj.getKey());
       return obj.getRes();
    }
    
    /**
    * 方法说明： 批量插入系统用户记录
    */
    public int[] insertBatch(java.util.List<User> list) {
	   String sql = "INSERT INTO user (avatar_id,email,enabled,password,username,dept_id,phone,job_id,create_time,last_password_reset_time,nick_name,sex) VALUES (:avatarId,:email,:enabled,:password,:username,:deptId,:phone,:jobId,:createTime,:lastPasswordResetTime,:nickName,:sex)";
       return batchOperate(list, sql);
    }
    
    /**
    * 方法说明：物理删除系统用户记录(多条)
    */
    public int delete(Long id) {
        String sql = "DELETE FROM user WHERE id = " + id;
        return jdbcTemplate.update(sql);
    }
    
    /**
    * 方法说明：更新系统用户记录
    */
    public int update(User vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE user SET avatar_id=?,email=?,enabled=?,password=?,username=?,dept_id=?,phone=?,job_id=?,create_time=?,last_password_reset_time=?,nick_name=?,sex=? ");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getAvatarId(),vo.getEmail(),vo.getEnabled(),vo.getPassword(),vo.getUsername(),vo.getDeptId(),vo.getPhone(),vo.getJobId(),vo.getCreateTime(),vo.getLastPasswordResetTime(),vo.getNickName(),vo.getSex(),vo.getId()};
        return jdbcTemplate.update(sql.toString(), params);
      }


     /**
    * 方法说明： 更新系统用户记录,不为空的都更新掉
    */
    public int updateNotNull(User vo) {
        java.util.List<String> fields = new java.util.ArrayList<>();
        java.util.List<Object> values = new java.util.ArrayList<>();
                if(vo.getId() != null){
            fields.add(" id = ? ");
            values.add(vo.getId());
        }   
                if(vo.getAvatarId() != null){
            fields.add(" avatar_id = ? ");
            values.add(vo.getAvatarId());
        }   
                if(vo.getEmail() != null){
            fields.add(" email = ? ");
            values.add(vo.getEmail());
        }   
                if(vo.getEnabled() != null){
            fields.add(" enabled = ? ");
            values.add(vo.getEnabled());
        }   
                if(vo.getPassword() != null){
            fields.add(" password = ? ");
            values.add(vo.getPassword());
        }   
                if(vo.getUsername() != null){
            fields.add(" username = ? ");
            values.add(vo.getUsername());
        }   
                if(vo.getDeptId() != null){
            fields.add(" dept_id = ? ");
            values.add(vo.getDeptId());
        }   
                if(vo.getPhone() != null){
            fields.add(" phone = ? ");
            values.add(vo.getPhone());
        }   
                if(vo.getJobId() != null){
            fields.add(" job_id = ? ");
            values.add(vo.getJobId());
        }   
                if(vo.getCreateTime() != null){
            fields.add(" create_time = ? ");
            values.add(vo.getCreateTime());
        }   
                if(vo.getLastPasswordResetTime() != null){
            fields.add(" last_password_reset_time = ? ");
            values.add(vo.getLastPasswordResetTime());
        }   
                if(vo.getNickName() != null){
            fields.add(" nick_name = ? ");
            values.add(vo.getNickName());
        }   
                if(vo.getSex() != null){
            fields.add(" sex = ? ");
            values.add(vo.getSex());
        }   
                
        if(fields.isEmpty()){
            return 0;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE user SET ");
        sql.append(com.google.common.base.Joiner.on(",").join(fields));
        sql.append(" WHERE ");
        Object[] params = values.toArray();
        return jdbcTemplate.update(sql.toString(), params);
      }

        /**
        * 方法说明： 按条件查询分页系统用户列表
        */
    public org.alvin.code.gen.utils.Page<User> queryPage(UserCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM user t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        //log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, User.class);
    }
    
    /**
    * 方法说明：按条件查询不分页系统用户列表
    */
    public java.util.List<User> queryList(UserCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM user t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(cond.getCondition());
    	sb.append(cond.getOrderSql());//增加排序子句;
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(User.class));
    }
    
    /**
    * 方法说明：按ID查找单个系统用户实体
    */
    public User findById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(null));
        sb.append(" FROM user t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(" AND t.id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(User.class));
    }
	
	 /**
     * 方法说明：按条件查询一个 收寄信息 对象
     */
    public User findOne(UserCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM user t ");
        sb.append(this.getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(User.class));
    }
    
    /**
    * 方法说明：按条件查询系统用户记录个数
    */
    public long queryCount(UserCond cond) {
    	String countSql = "SELECT COUNT(1) FROM user t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
    * 方法说明：按条件查询系统用户记录个数
    */
    public int deleteLogic(Long id) {
    	String sql = "UPDATE user SET delete_remark=1 WHERE id = " + id;
    	return jdbcTemplate.update(sql);
    }

    /**
    * 方法说明：查询参数定制
    */
    public String getSelectedItems(UserCond cond){
        if(cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()){
        return "t.id,t.avatar_id,t.email,t.enabled,t.password,t.username,t.dept_id,t.phone,t.job_id,t.create_time,t.last_password_reset_time,t.nick_name,t.sex"; //默认所有字段
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
    public UserFk findFkById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(null));
        sb.append(" FROM user t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(" AND t.id=? ");
        return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(UserFk.class));
    }

    /**
     * 方法说明: 查询数据包含外键对象和显示标签
     *
     * @param cond
     * @return
     */
    public UserFk findFkOne(UserFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM user t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(" limit 0,1");
        return jdbcTemplate.queryForObject(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(UserFk.class));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param cond
     * @return
     */
    public java.util.List<org.alvin.code.gen.beans.SelectOption> queryLabelList(UserFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append("t.id as value ,t.${table.labelCol} as label");
        sb.append(" FROM user t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(org.alvin.code.gen.beans.SelectOption.class));
    }

    /**
     * 方法说明：按条件查询不分页系统用户列表 (带关系表标签)
     */
    public java.util.List<UserFk> queryFkList(UserFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM user t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return jdbcTemplate.query(sb.toString(), cond.getArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(UserFk.class));
    }

    /**
     * 方法说明：按条件查询分页系统用户列表
     */
    public org.alvin.code.gen.utils.Page<UserFk> queryFkPage(UserFkCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getFkSelectedItems(cond));
        sb.append(" FROM user t ");
        sb.append(this.getFkJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
        sb.append(cond.getOrderSql());//增加排序子句;
        log.info(org.alvin.code.gen.utils.SqlUtil.showSql(sb.toString(), cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, UserFk.class);
    }

    /**
     * @return 方法说明：表连接的所有字段
     */
    public String getFkSelectedItems(UserCond cond) {
        if (cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append("t.id,t.avatar_id,t.email,t.enabled,t.password,t.username,t.dept_id,t.phone,t.job_id,t.create_time,t.last_password_reset_time,t.nick_name,t.sex");
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