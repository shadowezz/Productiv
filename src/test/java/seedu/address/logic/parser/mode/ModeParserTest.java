package seedu.address.logic.parser.mode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.commons.ModeEnum;
import seedu.address.logic.commands.mode.ExitCommand;
import seedu.address.logic.commands.mode.HelpCommand;
import seedu.address.logic.commands.mode.SwitchCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.testutil.ModeUtil;

public class ModeParserTest {

    private final ModeParser parser = new ModeParser();

    @Test
    public void parseCommand_exit() throws Exception {
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD, ModeEnum.DASHBOARD) instanceof ExitCommand);
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD + " 3", ModeEnum.DASHBOARD) instanceof ExitCommand);
    }

    @Test
    public void parseCommand_help() throws Exception {
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD, ModeEnum.DASHBOARD) instanceof HelpCommand);
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD + " 3", ModeEnum.DASHBOARD) instanceof HelpCommand);
    }

    @Test
    public void parseCommand_switch() throws Exception {
        SwitchCommand command = (SwitchCommand) parser.parseCommand(ModeUtil.getSwitchCommand(ModeEnum.PERSON),
                ModeEnum.DASHBOARD);
        assertEquals(new SwitchCommand(ModeEnum.PERSON), command);
    }

    @Test
    public void parseCommand_unknownCommand_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () ->
                parser.parseCommand("unknownCommand", ModeEnum.DASHBOARD));
    }

    @Test
    public void parseCommand_isModeCommand() {
        assertTrue(parser.isModeCommand(ModeUtil.getSwitchCommand(ModeEnum.PERSON)));
        assertTrue(parser.isModeCommand(ExitCommand.COMMAND_WORD));
        assertTrue(parser.isModeCommand(HelpCommand.COMMAND_WORD));
    }
}
