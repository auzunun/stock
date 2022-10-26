package com.auzun.stock.api.util.response;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ApiModel
public class ResponseOfGetList<T> {
    private List<T> resultList;

    public ResponseOfGetList() {}

    public ResponseOfGetList(List<T> resultList) {
        this.resultList = resultList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseOfGetList)) return false;
        ResponseOfGetList<?> that = (ResponseOfGetList<?>) o;
        return Objects.equals(resultList, that.resultList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultList);
    }
}
