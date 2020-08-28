package com.wimp.springdemo.exception2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.ObjectUtils;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zy
 * @date 2020/8/27
 * <p>
 *  具体返回的异常对象
 */
@Getter
@Setter
@ToString
public class ErrorResponse {
    private int code;
    private int status;
    private String message;
    private String path;
    private Instant timestamp;
    private HashMap<String, Object> data = new HashMap<>();

    public ErrorResponse() {

    }

    public ErrorResponse(int code, int status, String message, String path, Map<String, Object> data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.path = path;
        this.timestamp = Instant.now();
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }

    public ErrorResponse(BaseException ex, String path) {
        this(ex.getError().getCode(), ex.getError().getHttpStatus().value(),
                ex.getError().getMessage(), path, ex.getData());
    }
}
