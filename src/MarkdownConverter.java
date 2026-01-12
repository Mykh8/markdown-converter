import converter.HtmlConverter;
import input.InputHandler;
import parser.MarkdownParser;

import java.util.ArrayList;


public class MarkdownConverter {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        if (!inputHandler.isValidAmountOfArgs(args.length)) {
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        if (!inputHandler.areValidFileTypes(inputFile, outputFile)) {
            return;
        }

        if (!inputHandler.inputFileExists(inputFile)) {
            return;
        }

        MarkdownParser markdownParser = new MarkdownParser(inputFile);
        ArrayList<String> parsedList = markdownParser.parseFile();

        HtmlConverter htmlConverter = new HtmlConverter(outputFile);
        htmlConverter.convertToHtml(parsedList);
    }
}
