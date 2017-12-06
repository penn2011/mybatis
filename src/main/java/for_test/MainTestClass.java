package for_test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MainTestClass {


    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        String myBatisConfig = "for_test/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(myBatisConfig);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void after() {
        sqlSession.close();
    }


    /**
     * 测试sqlseessionFactory
     * @throws IOException
     */
    @Test
    public void testSqlSessionFacotry() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.selectUser(1));

    }

    /**
     * 测试使用原生的selectOne的方式来映射sql语句
     */
    @Test
    public void testSqlStrQuery(){
        System.out.println((User)sqlSession.selectOne("selectUser", 1));
        System.out.println((User)sqlSession.selectOne("selectUserById", 1));
    }








}
