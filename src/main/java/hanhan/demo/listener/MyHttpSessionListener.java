package hanhan.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Session监听器，实现在线用户的数量统计
 */
@Component
public class MyHttpSessionListener implements HttpSessionListener {
    private final static Logger log = LoggerFactory.getLogger(MyHttpSessionListener.class);

    private Integer cnt = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("用户上线");
        cnt++;
        se.getSession().getServletContext().setAttribute("cnt", cnt);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("用户下线");
        cnt--;
        se.getSession().getServletContext().setAttribute("cnt", cnt);
    }
}
