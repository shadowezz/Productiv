package seedu.address.logic.parser.mode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.mode.ExitCommand;
import seedu.address.logic.commands.mode.HelpCommand;
import seedu.address.logic.commands.mode.SwitchCommand;
import seedu.address.logic.commands.person.AddCommand;
import seedu.address.logic.commands.person.ClearCommand;
import seedu.address.logic.commands.person.DeleteCommand;
import seedu.address.logic.commands.person.EditCommand;
import seedu.address.logic.commands.person.EditCommand.EditPersonDescriptor;
import seedu.address.logic.commands.person.FindCommand;
import seedu.address.logic.commands.person.ListCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.person.AddressBookParser;
import seedu.address.model.person.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.person.Person;
import seedu.address.testutil.EditPersonDescriptorBuilder;
import seedu.address.testutil.ModeUtil;
import seedu.address.testutil.PersonBuilder;
import seedu.address.testutil.PersonUtil;
import seedu.address.ui.ModeEnum;

public class ModeParserTest {

    private final ModeParser parser = new ModeParser();

    @Test
    public void parseCommand_exit() throws Exception {
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD) instanceof ExitCommand);
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD + " 3") instanceof ExitCommand);
    }

    @Test
    public void parseCommand_help() throws Exception {
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD) instanceof HelpCommand);
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD + " 3") instanceof HelpCommand);
    }

    @Test
    public void parseCommand_switch() throws Exception {
        SwitchCommand command = (SwitchCommand) parser.parseCommand(ModeUtil.getSwitchCommand(ModeEnum.PERSON));
        assertEquals(new SwitchCommand(ModeEnum.PERSON), command);
    }

    @Test
    public void parseCommand_unknownCommand_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> parser.parseCommand("unknownCommand"));
    }

    @Test
    public void parseCommand_isModeCommand() {
        assertTrue(parser.isModeCommand(ModeUtil.getSwitchCommand(ModeEnum.PERSON)));
        // TODO add more modes here
        assertTrue(parser.isModeCommand(ExitCommand.COMMAND_WORD));
        assertTrue(parser.isModeCommand(HelpCommand.COMMAND_WORD));
    }
}
