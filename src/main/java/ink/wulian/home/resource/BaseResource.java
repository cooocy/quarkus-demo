package ink.wulian.home.resource;

import io.vertx.core.http.HttpServerRequest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

public abstract class BaseResource {

    @Context
    protected UriInfo uriInfo;

    @Context
    protected HttpServerRequest request;

}
