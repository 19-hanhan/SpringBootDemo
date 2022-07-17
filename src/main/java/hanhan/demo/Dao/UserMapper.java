package hanhan.demo.Dao;

import hanhan.demo.Entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
//    @Insert("INSERT user(u_username, u_password) VALUES (#{uUsername}, #{uPassword})")
    int AddUser(User usr);

//    @Delete("DELETE FROM user WHERE u_id=#{id}")
    int DeleteUserById(@Param("id") int id);

//    @Update("UPDATE user SET u_password=#{pwd} WHERE u_username=#{uname}")
    int UpdatePwdByUname(@Param("uname") String username, @Param("pwd") String password);

//    @Select("SELECT * FROM user")
    List<User> FindAll();

//    @Select("SELECT * FROM user WHERE u_username like '%${uname}%'")
    List<User> FindByUname(@Param("uname") String username);

    User FindById(@Param("id") int id);

//    @Select("<script>" +
//            "SELECT * FROM user\n" +
//            "<where>\n" +
//            "    <if test=\"uId != null and uId != 0\">\n" +
//            "        u_id = #{uId}\n" +
//            "    </if>\n" +
//            "    <if test=\"uUsername != null\">\n" +
//            "        AND u_username like '%${uUsername}%'\n" +
//            "    </if>\n" +
//            "    <if test=\"uPassword != null\">\n" +
//            "        AND u_password like '%${uPassword}%'\n" +
//            "    </if>\n" +
//            "</where>" +
//            "</script>")
    List<User> FindUser(User usr);

    List<User> FindFansById(int id);

    List<User> FindFollowsById(int id);
}
