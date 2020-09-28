package seedu.address.ui;

public enum ModeEnum {
    DASHBOARD {
        @Override
        public String toString() {
            return "dashboard";
        }
    },
    DELIVERABLE {
        @Override
        public String toString() {
            return "deliverable";
        }
    },
    MEETING {
        @Override
        public String toString() {
            return "meeting";
        }
    },
    PERSON {
        @Override
        public String toString() {
            return "contact";
        }
    }
}
