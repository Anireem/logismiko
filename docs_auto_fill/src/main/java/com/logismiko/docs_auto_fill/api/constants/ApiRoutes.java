package com.logismiko.docs_auto_fill.api.constants;

public final class ApiRoutes {

    private ApiRoutes() {
        throw new IllegalStateException("Utility class");
    }

    public final class Organization {

        private Organization() {
            throw new IllegalStateException("Utility class");
        }

        public static final String ORGANIZATION_CONTEXT_PATH
                = "/api/organizations";
    }
}
