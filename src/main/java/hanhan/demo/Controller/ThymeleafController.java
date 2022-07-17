package hanhan.demo.Controller;

import hanhan.demo.Entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Api(tags = "Thymeleaf测试类接口")
@RequestMapping("/thymeleaf")
public class ThymeleafController {
    /**
     * 这里需要特意输入错误网址
     * @return
     */
    @ApiOperation("测试404页面")
    @GetMapping("/test404")
    public String Test404() {
        return "index";
    }

    @ApiOperation("测试抛出的异常错误500页面")
    @GetMapping("/test500")
    public String Test500() {
        int i = 1 / 0;
        return "index";
    }

    @ApiOperation("将User对象发送到前端")
    @GetMapping("/setuser")
    public String GetUser(Model model) {
        User usr = new User("hanhan", "pwd");
        usr.setuId(18);
        model.addAttribute("usr", usr);
        return "html/user";
    }

    @ApiOperation("将List对象发送到前端")
    @GetMapping("/setlist")
    public String getList(Model model) {
        User usr1 = new User("hanhan", "hanhan-pwd");
        User usr2 = new User("Ander", "Ander-pwd");
        List<User> list = new ArrayList<>();
        list.add(usr1);
        list.add(usr2);
        model.addAttribute("list", list);
        return "html/list";
    }


}
