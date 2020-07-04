package ink.wulian.home.common.result;

import lombok.Data;
import lombok.NonNull;

@Data
public class Result<T> {

    private Boolean success;

    private String code;

    private String message;

    private T data;

    private Result() {
    }

    public static <T> Result<T> ok(T data) {
        Result<T> result = ok();
        result.data = data;
        return result;
    }

    public static Result ok() {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultEnum.ok.getCode());
        result.setMessage(ResultEnum.ok.getMessage());
        return result;
    }

    protected static Result<String> error(@NonNull ResultEnum resultEnum) {
        Result<String> result = new Result();
        result.setSuccess(false);
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }

    protected static Result<String> error(@NonNull ResultEnum resultEnum, @NonNull String message) {
        Result<String> error = error(resultEnum);
        error.setMessage(message);
        return error;
    }

}
