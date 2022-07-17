package hanhan.demo.listener;

import hanhan.demo.Entity.User;
import hanhan.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * 上下文监听器，在刷新上下文的时候调用
 */
@Component
public class MyContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    UserService service;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 获取application上下文
        ApplicationContext alc = event.getApplicationContext();
        // 获取对应service
        List<User> ls = service.FindAll();
        System.out.println("上下文监听器实现在内存中存入用户列表");
        // 获取application域对象，将查到的信息放到application域里
        ServletContext application = alc.getBean(ServletContext.class);
        application.setAttribute("userList", ls);
    }
}
