package hanhan.demo.Util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "url")
public class MicroServiceUrl {
    private String oneUrl = "http://localhost:3001";
    private String twoUrl = "http://localhost:3002";
    private String threeUrl = "http://localhost:3003";

    public String getOneUrl() {
        return oneUrl;
    }

    public void setOneUrl(String oneUrl) {
        this.oneUrl = oneUrl;
    }

    public String getTwoUrl() {
        return twoUrl;
    }

    public void setTwoUrl(String twoUrl) {
        this.twoUrl = twoUrl;
    }

    public String getThreeUrl() {
        return threeUrl;
    }

    public void setThreeUrl(String threeUrl) {
        this.threeUrl = threeUrl;
    }
}
