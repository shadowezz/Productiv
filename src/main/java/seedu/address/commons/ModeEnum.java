package seedu.address.commons;

import static seedu.address.commons.util.StringUtil.getStringJoinedBySeparator;

import java.util.Arrays;

public enum ModeEnum {

    DASHBOARD("Dashboard", "dashboard"),
    DELIVERABLE("Deliverable", "deliverable"),
    MEETING("Meeting", "meeting"),
    PERSON("Contact", "contact");

    private final String name;
    private final String argument;

    ModeEnum(String name, String argument) {
        this.name = name;
        this.argument = argument;
    }

    public static ModeEnum getEnumByArgument(String argument) {
        for (ModeEnum modeEnum : ModeEnum.values()) {
            if (modeEnum.argument.equals(argument)) {
                return modeEnum;
            }
        }
        return null;
    }

    public static String getModeOptions() {
        return getStringJoinedBySeparator(Arrays.stream(ModeEnum.values()).map(role -> role.getArgument()),
                " or ");
    }

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return name;
    }

}
