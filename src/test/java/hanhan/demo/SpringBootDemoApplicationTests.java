package hanhan.demo;

import hanhan.demo.Entity.User;
import hanhan.demo.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class SpringBootDemoApplicationTests {
    @Autowired
    private UserService service;

    @Test
    void contextLoads() {
        System.out.println(service.AddUser(new User("hanhan2", "password")));
//        System.out.println(service.DeleteUserById(6));
//        System.out.println(service.FindAll());
//        System.out.println(service.FindUser(new User("hanhan", "pwd")));
    }

}
