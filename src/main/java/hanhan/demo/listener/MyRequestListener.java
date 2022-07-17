package hanhan.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 请求监听器，发送请求时调用
 */
@Component
public class MyRequestListener implements ServletRequestListener {
    private final static Logger log = LoggerFactory.getLogger(MyRequestListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        log.info("session id为：{}, request url为：{}", req.getRequestedSessionId(), req.getRequestURL());

        req.setAttribute("name", "hanhan");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        log.info("request域中保存的name值为：{}", req.getAttribute("name"));
    }
}
