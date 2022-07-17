package hanhan.demo.Controller;

import hanhan.demo.Util.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/send")
@Api(tags = "消息发送测试类接口")
public class SendController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping(value = "/{topic}/{msg}")
    public JsonResult<Void> send(@PathVariable(value = "topic") String topic, @PathVariable(value = "msg") String msg) {
        kafkaTemplate.send(topic, msg);
        return new JsonResult<>();
    }
}
