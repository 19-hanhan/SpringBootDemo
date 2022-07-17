package hanhan.demo.listener;

import io.swagger.annotations.ApiModelProperty;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaListener {

    @ApiModelProperty("日志信息对象")
    private final static Logger log = LoggerFactory.getLogger(MyKafkaListener.class);

//    @KafkaListener(topics = {"test"}, groupId = "testGroup")
//    public void testListener(ConsumerRecord<String, String> record) {
//        log.info("读取的消息：" + record.value() + "、当前偏移量：" + record.offset());
//    }
}
