package hanhan.demo.Service;

import java.util.List;

public interface RedisService {
    public void setString(String key, String value);

    public String getString(String key);

    public void setHash(String key, String filedKey, String value);

    public String getHasn(String key, String filedKey);

    public Long setList(String key, String value);

    public List<String> getList(String key, long start, long end);

    public Boolean delKey(String key);
}
