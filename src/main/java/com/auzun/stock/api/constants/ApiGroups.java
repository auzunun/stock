package com.auzun.stock.api.constants;

public final class ApiGroups {
    private ApiGroups() {}

    public static final class StockApi {
        public static final String NAME = "stock-api";
        public static final String PATHS = "/api/stocks/**";
    }
}
