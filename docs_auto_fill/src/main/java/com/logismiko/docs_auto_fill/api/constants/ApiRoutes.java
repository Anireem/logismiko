package com.logismiko.docs_auto_fill.api.constants;

/**
 * Предоставляет роуты для всех API
 */
public final class ApiRoutes {
    private ApiRoutes() {
    }

    /**
     * Предоставляет роуты для API по управлению организациями.
     */
    public final class Organization {
        private Organization() {
        }
        public static final String ORGANIZATION_CONTEXT_PATH
                = "/api/organizations";
    }
}
