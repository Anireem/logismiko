package com.logismiko.docs_auto_fill.api.constants;

/**
 * Represents routes for all API
 */
public final class ApiRoutes {
    private ApiRoutes() {
    }

    /**
     * Represents routes for firm management APIs.
     */
    public final class Firm {
        private Firm() {
        }
        public static final String FIRM_CONTEXT_PATH = "/api/firms";
    }

    /**
     * Represents routes for contract management APIs.
     */
    public final class Contract {
        private Contract() {
        }
        public static final String CONTRACT_CONTEXT_PATH = "/api/contracts";
    }
}
