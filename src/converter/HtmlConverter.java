package converter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class HtmlConverter {

    static final String HTML_HEAD = """
        <!DOCTYPE html>
        <html lang="en">
          <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <title>HTML 5 Boilerplate</title>
            <link rel="stylesheet" href="style.css">
          </head>
          <body>
    """;

    static final String HTML_FOOT = """
            <script src="index.js"></script>
          </body>
        </html>
    """;

    private final String htmlFilePath;
    public HtmlConverter(String file) {
        this.htmlFilePath = file;
    }

    public void convertToHtml(ArrayList<String> parsedList) {
        Path path = Paths.get(htmlFilePath);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(HTML_HEAD);
            for (String line : parsedList) {
                writer.write("        ");
                writer.write(line);
                writer.newLine();
            }
            writer.write(HTML_FOOT);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}