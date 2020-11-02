package seedu.address.logic.parser.mode;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.mode.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.mode.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.logic.parser.mode.SwitchCommandParser.SAME_MODE_MESSAGE;

import org.junit.jupiter.api.Test;

import seedu.address.commons.ModeEnum;
import seedu.address.logic.commands.mode.SwitchCommand;

class SwitchCommandParserTest {

    private SwitchCommandParser parser = new SwitchCommandParser(ModeEnum.DASHBOARD);

    @Test
    public void parse_validArgs_returnsSwitchCommand() {
        assertParseSuccess(parser, ModeEnum.PERSON.getArgument(), new SwitchCommand(ModeEnum.PERSON));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT, SwitchCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_sameMode_throwsParseException() {
        assertParseFailure(parser, ModeEnum.DASHBOARD.getArgument(), String.format(SAME_MODE_MESSAGE, ModeEnum.DASHBOARD));
    }
}
