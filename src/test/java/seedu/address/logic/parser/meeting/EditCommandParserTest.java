//package seedu.address.logic.parser.meeting;
//
////import static org.junit.jupiter.api.Assertions.*;
//import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
//import static seedu.address.logic.commands.person.CommandTestUtil.NAME_DESC_AMY;
//import static seedu.address.logic.commands.person.CommandTestUtil.VALID_NAME_AMY;
//import static seedu.address.logic.parser.meeting.CommandParserTestUtil.assertParseFailure;
//
//import org.junit.jupiter.api.Test;
//
//import seedu.address.logic.commands.meeting.EditCommand;
//
//class EditCommandParserTest {
//
//    private static final String EMPTY = " ";
//
//    private static final String MESSAGE_INVALID_FORMAT =
//            String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE);
//
//    private EditCommandParser parser = new EditCommandParser();
//
//    @Test
//    void parse() {
//        // no index specified
//        assertParseFailure(parser, VALID_NAME_AMY, MESSAGE_INVALID_FORMAT);
//
//        // no field specified
//        assertParseFailure(parser, "1", EditCommand.MESSAGE_NOT_EDITED);
//
//        // no index and no field specified
//        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
//    }
//
//    @Test
//    public void parse_invalidPreamble_failure() {
//        // TODO:Create Meeting Templates
//        // negative index
//        assertParseFailure(parser, "-5" + NAME_DESC_AMY, MESSAGE_INVALID_FORMAT);
//
//        // TODO:Create Meeting Templates
//        // zero index
//        assertParseFailure(parser, "0" + NAME_DESC_AMY, MESSAGE_INVALID_FORMAT);
//
//        // invalid arguments being parsed as preamble
//        assertParseFailure(parser, "1 some random string", MESSAGE_INVALID_FORMAT);
//
//        // invalid prefix being parsed as preamble
//        assertParseFailure(parser, "1 i/ string", MESSAGE_INVALID_FORMAT);
//    }
//}
