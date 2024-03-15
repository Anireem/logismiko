package com.logismiko.docs_auto_fill.api.constants;

/**
 * Represents routes for all API
 */
public final class ApiRoutes {
    private ApiRoutes() {
    }

    /**
     * Represents routes for organization management APIs.
     */
    public final class Organization {
        private Organization() {
        }
        public static final String ORGANIZATION_CONTEXT_PATH
                = "/api/organizations";
    }
}
