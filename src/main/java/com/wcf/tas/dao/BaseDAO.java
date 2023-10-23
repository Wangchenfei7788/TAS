package com.wcf.tas.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BaseDAO {
	
	SqlSessionFactory sqlSessionFct;

	public BaseDAO() {
		
	}

	public SqlSessionFactory getSqlSessionFct() {
		return sqlSessionFct;
	}

	public void setSqlSessionFct(SqlSessionFactory sqlSessionFct) {
		this.sqlSessionFct = sqlSessionFct;
	}
	
	public SqlSession getSession() {
		return sqlSessionFct.openSession();
	}
	
}
