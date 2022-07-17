package hanhan.demo.Service.Impl;

import hanhan.demo.Service.RedisService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private StringRedisTemplate srt;

    @Override
    public void setString(String key, String value) {
        srt.opsForValue().set(key, value);
    }

    @Override
    public String getString(String key) {
        return srt.opsForValue().get(key);
    }

    @Override
    public void setHash(String key, String filedKey, String value) {
        srt.opsForHash().put(key, filedKey, value);
    }

    @Override
    public String getHasn(String key, String filedKey) {
        return (String) srt.opsForHash().get(key, filedKey);
    }

    @Override
    public Long setList(String key, String value){
        return srt.opsForList().leftPush(key, value);
    }

    @Override
    public List<String> getList(String key, long start, long end){
        return srt.opsForList().range(key, start, end);
    }

    @Override
    public Boolean delKey(String key) {
        return srt.delete(key);
    }
}
