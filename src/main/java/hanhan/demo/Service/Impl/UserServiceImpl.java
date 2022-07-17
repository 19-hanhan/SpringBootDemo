package hanhan.demo.Service.Impl;

import hanhan.demo.Dao.UserMapper;
import hanhan.demo.Entity.User;
import hanhan.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    @Transactional(rollbackFor = Exception.class) // 制定回滚的异常属性，默认runtime
    public int AddUser(User usr) {
        return mapper.AddUser(usr);
    }

    @Override
    public int DeleteUserById(int id) {
        return mapper.DeleteUserById(id);
    }

    @Override
    public int UpdatePwdByUname(String username, String password) {
        return mapper.UpdatePwdByUname(username, password);
    }

    @Override
    public List<User> FindAll() {
        return mapper.FindAll();
    }

    @Override
    public List<User> FindByUname(String username) {
        return mapper.FindByUname(username);
    }

    @Override
    public List<User> FindUser(User usr) {
        return mapper.FindUser(usr);
    }
}
