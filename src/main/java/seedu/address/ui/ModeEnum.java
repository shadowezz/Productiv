package seedu.address.ui;

public enum ModeEnum {
    DASHBOARD {
        @Override
        public String toString() {
            return "Dashboard";
        }
    },
    DELIVERABLE {
        @Override
        public String toString() {
            return "Deliverable";
        }
    },
    MEETING {
        @Override
        public String toString() {
            return "Meeting";
        }
    },
    PERSON {
        @Override
        public String toString() {
            return "Contact";
        }
    }
}
