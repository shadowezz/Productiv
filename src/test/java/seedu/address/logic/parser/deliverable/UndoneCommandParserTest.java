package seedu.address.logic.parser.deliverable;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.deliverable.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.deliverable.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.deliverable.UndoneCommand;

public class UndoneCommandParserTest {
    private UndoneCommandParser parser = new UndoneCommandParser();

    @Test
    void parse_validArgs_returnsUndoneCommand() {
        assertParseSuccess(parser, "1", new UndoneCommand(INDEX_FIRST));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT, UndoneCommand.MESSAGE_USAGE));
    }


}
