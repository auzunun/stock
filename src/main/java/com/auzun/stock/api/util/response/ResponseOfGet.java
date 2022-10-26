package com.auzun.stock.api.util.response;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@ApiModel
public class ResponseOfGet<T> {
    private T result;

    public ResponseOfGet(T result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseOfGet)) return false;
        ResponseOfGet<?> that = (ResponseOfGet<?>) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
