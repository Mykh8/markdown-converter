package parser;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import static parser.MarkdownPatterns.MARKDOWN_PATTERNS;

public class MarkdownParser{
    private final Path mdFilePath;
    private final ArrayList<String> parsedHtmlLines = new ArrayList<>();

    public MarkdownParser(String mdFilePath) {
        this.mdFilePath = Path.of(mdFilePath).toAbsolutePath();
    }

    public ArrayList<String> parseFile() {
        try (Scanner reader = new Scanner(mdFilePath)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                if (line.isBlank()) {
                    continue;
                }

                String[] parts = line.split(" ");
                String firstPart = parts[0];

                if (MARKDOWN_PATTERNS.containsKey(firstPart)) {
                    String text = line.replace(firstPart, "").strip();
                    text = processInlineFormatting(text);
                    String tag = MARKDOWN_PATTERNS.get(firstPart);
                    parsedHtmlLines.add(String.format("<%s>%s</%s>", tag, text, tag));
                } else {
                    String text = processInlineFormatting(line.strip());
                    parsedHtmlLines.add(String.format("<p>%s</p>", text));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return parsedHtmlLines;
    }

    private String processInlineFormatting(String text) {
        // bold: **text** or __text__
        text = text.replaceAll("\\*\\*(.*?)\\*\\*", "<strong>$1</strong>");
        text = text.replaceAll("__(.*?)__", "<strong>$1</strong>");

        // italic: *text* or _text_
        text = text.replaceAll("\\*(.*?)\\*", "<em>$1</em>");
        text = text.replaceAll("_(.*?)_", "<em>$1</em>");

        // inline code: `code` (use backtick, not quote)
        text = text.replaceAll("`(.*?)`", "<code>$1</code>");

        return text;
    }
}