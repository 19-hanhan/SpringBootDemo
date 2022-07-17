package hanhan.demo.Service;

import hanhan.demo.Entity.User;

import java.util.List;

public interface UserService {
    /**
     * 添加用户
     * @param usr 用户信息中有账号密码，可以不包含id
     * @return 成功操作的行数
     */
    int AddUser(User usr);

    /**
     * 通过ID删除用户
     * @param id
     * @return 成功操作的行数
     */
    int DeleteUserById(int id);

    /**
     * 通过用户名修改密码
     * @param username
     * @param password
     * @return 成功操作的行数
     */
    int UpdatePwdByUname(String username, String password);

    /**
     * 查找所有的用户信息
     * @return 用户对象列表
     */
    List<User> FindAll();

    /**
     * 查找用户名中包含输入字符的人
     * @param username 用户匹配字符串
     * @return 查找到的对象列表
     */
    List<User> FindByUname(String username);

    /**
     * 根据多种条件选择合适的人
     * @param usr
     * @return
     */
    List<User> FindUser(User usr);
}
