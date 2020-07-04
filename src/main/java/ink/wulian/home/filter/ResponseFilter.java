package ink.wulian.home.filter;

import cn.hutool.core.util.StrUtil;
import ink.wulian.home.common.utils.HttpContextUtils;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

/**
 * execute order of response filter:
 * Priority(20) -> Priority(10)
 */
@Slf4j
@Priority(10)
@Provider
public class ResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        MediaType mediaType = (MediaType) headers.getFirst(HttpContextUtils.CONTENT_TYPE);
        // set charset if is json
        if (StrUtil.equals(mediaType.getSubtype(), HttpContextUtils.JSON)) {
            headers.remove(HttpContextUtils.CONTENT_TYPE);
            headers.add(HttpContextUtils.CONTENT_TYPE, HttpContextUtils.JSON_UTF8);
        }
        log.info("Response success, length is {}", responseContext.getLength());
    }

}
