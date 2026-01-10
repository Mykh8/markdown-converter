package input;

import java.nio.file.Files;
import java.nio.file.Path;

public class InputHandler {

    private static final String USAGE =
            "Usage: java Main <input.md> <output.html>";

    public boolean isValidAmountOfArgs(int argsAmount) {
        if (argsAmount != 2) {
            System.err.println("Error: expected 2 arguments, got " + argsAmount);
            System.err.println(USAGE);
            return false;
        }
        return true;
    }

    public boolean areValidFileTypes(String input, String output) {
        if (!input.endsWith(".md")) {
            System.err.println("Error: input file must end with .md: " + input);
            return false;
        }

        if (!output.endsWith(".html")) {
            System.err.println("Error: output file must end with .html: " + output);
            return false;
        }

        return true;
    }

    public boolean inputFileExists(String mdFilePath) {
        Path path = Path.of(mdFilePath).toAbsolutePath();

        if (!Files.exists(path)) {
            System.err.println("Error: file not found: " + path);
            return false;
        }

        return true;
    }
}
