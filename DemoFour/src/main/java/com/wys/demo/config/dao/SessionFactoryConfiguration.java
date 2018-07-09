package com.wys.demo.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;

public class SessionFactoryConfiguration {
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean(){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
    }
}
