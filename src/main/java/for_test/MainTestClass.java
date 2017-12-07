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
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainTestClass {


    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        String myBatisConfig = "for_test/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(myBatisConfig);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @After
    public void after() {
        //sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 测试sqlseessionFactory
     *
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
    public void testSqlStrQuery() {
        System.out.println((User) sqlSession.selectOne("selectUser", 20));
        System.out.println((User) sqlSession.selectOne("selectUserById", 1));
    }

    /**
     * 测试单条的主键返回
     */
    @Test
    public void testGeneratedKeySingle() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("测试用户5", 30);

        mapper.insertUser(user);
        System.out.println(user.getId());
    }

    /**
     * 测试批量插入，批量插入返回的主键
     */
    @Test
    public void testGeneratedKeys() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = Arrays.asList(
                new User("测试用户" + String.valueOf(new Random().nextInt()), 21),
                new User("测试用户" + String.valueOf(new Random().nextInt()), 21),
                new User("测试用户" + String.valueOf(new Random().nextInt()), 21),
                new User("测试用户" + String.valueOf(new Random().nextInt()), 21)
        );
        mapper.insertMany(userList);


        //输出id
        userList.forEach(e -> System.out.println(e));


    }

    /**
     * 测试自动映射
     * 指定 MyBatis 应如何自动映射列到字段或属性。
     * NONE 表示取消自动映射
     * PARTIAL 将自动映射结果除了那些有内部定义内嵌结果映射的(joins).
     * FULL 会自动映射任意复杂的结果集（无论是否嵌套）。
     */
    @Test
    public  void testAutoMapping(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.selectUserResultMap(1));
    }
    /**
     * 测试查询以返回一个map的方式
     */
    @Test
    public void testReturnMap() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.selectUserMap(1));

    }


    /**
     * 测试复杂的查询
     */
    @Test
    public void testComplicatedSelect(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
         User user= mapper.findUserWithAllPets(1);
        System.out.println(user);
    }


}
