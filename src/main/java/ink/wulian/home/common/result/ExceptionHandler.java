package ink.wulian.home.common.result;

import ink.wulian.home.common.utils.HttpContextUtils;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Optional;

/**
 * request filter -> resource -> (exception handler) if error -> response filter
 */
@Slf4j
@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

    private static final String EMPTY_MESSAGE = "not found message in exception";

    @Override
    public Response toResponse(Exception exception) {
        String message = Optional.ofNullable(exception.getMessage()).orElse(EMPTY_MESSAGE);
        log.error(message);

        Result<String> result;
        if (exception instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) exception;
            result = serviceException.convert();
        } else {
            result = Result.error(ResultEnum.error, message);
        }

        Response response = Response.status(Response.Status.OK).entity(result).build();
        response.getHeaders().add(HttpContextUtils.CONTENT_TYPE, HttpContextUtils.JSON_UTF8);
        return response;
    }

}
