package seedu.address.model.person.person;

public enum RoleEnum {

    DEVELOPER("Developer", "dev"),
    STAKEHOLDER("Stakeholder", "stk");

    private final String name;
    private final String argument;

    private RoleEnum(String name, String argument) {
        this.name = name;
        this.argument = argument;
    }

    public static RoleEnum getEnumByArgument(String argument) {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (roleEnum.argument.equals(argument)) {
                return roleEnum;
            }
        }
        return null;
    }

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return name;
    }

}
