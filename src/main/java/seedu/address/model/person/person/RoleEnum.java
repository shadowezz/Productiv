package seedu.address.model.person.person;

public enum RoleEnum {
    DEVELOPER {
        @Override
        public String toString() {
            return "Developer";
        }
        @Override
        public String getArgument() {
            return "dev";
        }
    },
    STAKEHOLDER {
        @Override
        public String toString() {
            return "Stakeholder";
        }
        @Override
        public String getArgument() {
            return "stk";
        }
    };
    public abstract String getArgument();
}
