package org.apache.ibatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class InitializingMainSupport {

    public static void main(String[] args) {
        try {
            String resource = "mybatis-config.xml";
            // 加载mybatis的配置文件（它也加载关联的映射文件）
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 构建sqlSession的工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sessionFactory.openSession();
            List<Object> persons = session.selectList("select * from person");
            System.out.println(persons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
