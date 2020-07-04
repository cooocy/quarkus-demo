package ink.wulian.home.resource;

import cn.hutool.core.util.StrUtil;
import ink.wulian.home.common.result.Result;
import ink.wulian.home.common.result.ResultEnum;
import ink.wulian.home.common.result.ServiceException;
import ink.wulian.home.common.utils.HttpContextUtils;
import lombok.Data;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.Map;

@Path("/health")
@Produces(MediaType.APPLICATION_JSON)
public class HealthResource extends BaseResource {

    @ConfigProperty(name = "app.name")
    private String appName;

    @Path("")
    @GET
    public Result<Health> check() {
        Health health = new Health();
        health.serverName = appName;
        health.serverTime = LocalDateTime.now();
        health.serverInfo = "server by quarkus";
        health.requestHeaders = HttpContextUtils.getHeaders(request);
        health.requestIP = request.remoteAddress().toString();
        return Result.ok(health);
    }

    @Path("/error")
    @GET
    public void error(@QueryParam("message") String message) {
        if (StrUtil.isEmpty(message)) {
            throw new ServiceException(ResultEnum.error);
        } else {
            throw new ServiceException(ResultEnum.error, message);
        }
    }

    @Data
    public static class Health {

        private String serverName;

        private LocalDateTime serverTime;

        private String serverInfo;

        private Map<String, String> requestHeaders;

        private String requestIP;

    }

}
