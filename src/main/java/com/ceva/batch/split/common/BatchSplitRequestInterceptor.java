package com.ceva.batch.split.common;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class BatchSplitRequestInterceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    if (request.getHeader(BatchSplitLoggerUtils.REQUEST_ID) != null) {
      MDC.put(BatchSplitLoggerUtils.REQUEST_ID, request.getHeader(BatchSplitLoggerUtils.REQUEST_ID));
    } else {
      MDC.put(BatchSplitLoggerUtils.REQUEST_ID, UUID.randomUUID().toString().replace("-", ""));
    }
    return true;

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {

    MDC.remove(BatchSplitLoggerUtils.REQUEST_ID);

  }
}
