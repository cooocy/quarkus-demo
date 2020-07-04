package ink.wulian.home.filter;

import io.vertx.core.http.HttpServerRequest;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

@Slf4j
@Provider
public class RequestFilter implements ContainerRequestFilter {

    @Context
    private UriInfo uriInfo;

    @Context
    private HttpServerRequest request;

    @Override
    public void filter(ContainerRequestContext context) {
        log.info("Request {} {} from IP {}", context.getMethod(), uriInfo.getPath(), request.remoteAddress().host());
    }

}
