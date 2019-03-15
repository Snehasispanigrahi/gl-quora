package com.greatlearning.quora.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<ApiSubError> subErrors;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    ApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    ApiError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    abstract static class ApiSubError {
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    @AllArgsConstructor
    public static class ApiValidationError extends ApiSubError {
        private String object;
        private String field;
        private Object rejectedValue;
        private String message;

        ApiValidationError(String object, String message) {
            this.object = object;
            this.message = message;
        }
    }

    class LowerCaseClassNameResolver extends TypeIdResolverBase {

        @Override
        public String idFromValue(Object value) {
            return value.getClass().getSimpleName().toLowerCase();
        }

        @Override
        public String idFromValueAndType(Object value, Class<?> suggestedType) {
            return idFromValue(value);
        }

        @Override
        public JsonTypeInfo.Id getMechanism() {
            return JsonTypeInfo.Id.CUSTOM;
        }
    }
}
