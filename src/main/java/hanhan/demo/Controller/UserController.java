package hanhan.demo.Controller;

import hanhan.demo.Entity.User;
import hanhan.demo.Service.RedisService;
import hanhan.demo.Service.UserService;
import hanhan.demo.Util.JsonResult;
import hanhan.demo.Util.MicroServiceUrl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "用户测试类接口")
public class UserController {

    @ApiModelProperty("日志信息对象")
    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    @ApiModelProperty("微服务类对象")
    private MicroServiceUrl serviceUrl;

    @Autowired
    @ApiModelProperty("Service层注入对象")
    private UserService service;

    @ApiOperation("返回空Json对象")
    @GetMapping("/start")
    public JsonResult<Void> StartSpringBoot() {
        return new JsonResult<>();
    }

    @ApiOperation("Json访问数据库全部数据")
    @GetMapping(value = "/getjson1", produces = "application/json;charset=utf-8")
    public JsonResult<List> GetJson1() {
        return new JsonResult<>(service.FindAll());
    }

    @ApiOperation("Json访问名称中带有Ander的对象")
    @GetMapping("/getjson2")
    public JsonResult<Map> GetJson2() {
        Map<String, Object> mp = new HashMap<>();
        List<User> ls = service.FindByUname("Ander");
        mp.put("list", ls);
        mp.put("cnt", ls.size());
        return new JsonResult<>(mp);
    }

    @ApiOperation("发送Json数据并包装返回")
    @PostMapping("/userlist.do")
    public JsonResult<Map> GetUserlist(@RequestBody Map<String, Object> mp) {
        return new JsonResult<>(mp);
    }

    @ApiOperation("日志打印测试")
    @GetMapping("/log")
    public String TestLog() {
        log.debug("===== 测试日志debug级别打印");
        log.info("====== 测试日志info级别打印");
        log.error("===== 测试日志error级别打印");
        log.warn("====== 测试日志warn级别打印");

        // 可以使用占位符打印出一些参数信息
        String str1 = "hanhan";
        String str2 = "https://github.com/hanhan";
        log.info("======{}的项目库：{}", str1, str2);

        return "success";
    }

    @ApiOperation("微服务链接打印测试")
    @GetMapping("/microservice")
    private String MicroService() {
        log.info("===== 获取的One服务地址为：{}", serviceUrl.getOneUrl());
        log.info("===== 获取的Two服务地址为：{}", serviceUrl.getTwoUrl());
        log.info("===== 获取的Three服务地址为：{}", serviceUrl.getThreeUrl());
        return "success";
    }

    /**
     * @param name 设定位置的参数数据
     * @return
     */
    @ApiOperation("通过设定的网址内容读取username携带的数据")
    @GetMapping("/user/{username}")
    public JsonResult<String> GetUserId1(@PathVariable("username") String name) {
        log.info("===== 进入的用户为{}", name);
        return new JsonResult<>(name);
    }

    /**
     * @param name ?后面接的参数，并且用required=false表示没有输入参数为空，设置为true则是返回404
     * @return
     */
    @ApiOperation("读取网址中username携带参数")
    @GetMapping("/user")
    public JsonResult<String> GetUserId2(@RequestParam(value = "username", required = false) String name) {
        log.info("===== 进入的用户为{}", name);
        return new JsonResult<>(name);
    }

    /**
     * @param req 请求对象
     * @return
     */
    @ApiOperation("测试上下文监听器实现的缓存数据")
    @GetMapping("/application")
    public JsonResult<List> TestApplication(HttpServletRequest req) {
        return new JsonResult<>((List)req.getServletContext().getAttribute("userList"));
    }

    @ApiOperation("测试Session监听器实现的在线用户统计")
    @GetMapping("/user_number")
    public String TestUserNumber(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie;
        try {
            // 把sessionId记录在浏览器中
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(req.getSession().getId(), "utf-8"));
            cookie.setPath("/");
            // 设置cookie有效期为2天
            cookie.setMaxAge(48 * 60 * 60);
            resp.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "当前在线人数：" + (Integer)req.getSession().getServletContext().getAttribute("cnt");
    }

    @ApiOperation("测试Request监听器功能")
    @GetMapping("/request")
    public String TestRequest(HttpServletRequest req) {
        return (String)req.getAttribute("name");
    }

    @Autowired
    private RedisService redisService;

    @GetMapping("/redis")
    public String redis() {
        redisService.setString("username", "hanhan");
        log.info("===== 缓存中存入username，值为" + redisService.getString("username"));
        redisService.delKey("username");
        return redisService.getString("username");
    }
}
