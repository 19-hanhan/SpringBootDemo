package hanhan.demo.Controller;

import hanhan.demo.Util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exception")
@Api(tags = "测试异常输出类")
public class ExceptionController {
    // Log对象
    private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    /**
     * 在输入的时候不输入所有参数用于测试，发送POST请求
     * @param uname
     * @param pwd
     * @return
     */
    @ApiOperation("测试缺少必要参数")
    @PostMapping("/lackdata")
    public JsonResult<Void> LackData(@RequestParam("username") String uname, @RequestParam("password") String pwd) {
        log.info("username: {}, password: {}", uname, pwd);
        return new JsonResult();
    }
}


