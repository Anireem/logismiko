package com.logismiko.docs_auto_fill.api.constants;

public class ApiRoutes {

    private ApiRoutes() {
        throw new IllegalStateException(Error.UTILITY_CLASS);
    }

    public class Organization {

        private Organization() {
            throw new IllegalStateException(Error.UTILITY_CLASS);
        }

        public static final String ORGANIZATION_CONTEXT_PATH = "/api/organizations";
    }

    public class Error {

        private Error() {
            throw new IllegalStateException(UTILITY_CLASS);
        }

        public static final String UTILITY_CLASS = "Utility class";
    }
}
