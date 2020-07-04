package ink.wulian.home.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {

    ok("10000", "ok"),
    error("10010", "error"),
    apiNotExist("10030", "api not exist"),
    paramIllegal("10040", "param illegal"),
    ;

    private final String code;

    private final String message;

}
