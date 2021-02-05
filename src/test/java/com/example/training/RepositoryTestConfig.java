package com.example.training;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@ComponentScan("training.common.repository")
@MapperScan("training.common.repository")
public class RepositoryTestConfig {

  @Bean
  public DataSource testDataSource() {
    HikariConfig config = new HikariConfig("/db-test.properties");
    HikariDataSource dataSource = new HikariDataSource(config);
    return dataSource;
  }

  @Bean
  public SqlSessionFactory testSqlSessionFactory() throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(testDataSource());
    factoryBean.setVfs(SpringBootVFS.class);
    factoryBean.setConfigLocation(
        new PathMatchingResourcePatternResolver().getResource("/src/main/resources/mybatis/mybatis-config.xml"));
    return factoryBean.getObject();
  }
}
