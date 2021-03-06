package for_test;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    User selectUser(@Param("id") Integer id);

    @Select("select * from reg_user where id=#{id}")
    User selectUserById(Integer id);

    Integer insertUser(User unSaveUser);

    void insertMany(List<User> userList);

    List<Map> selectUserMap(int i);

    User findUserWithAllPets(@Param("id") int i);

    User selectUserResultMap(int id);
}
