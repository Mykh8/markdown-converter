package parser;

import java.util.HashMap;
import java.util.Map;

public class MarkdownPatterns {
    static final Map<String, String> MARKDOWN_PATTERNS = new HashMap<>();
    static {
        MARKDOWN_PATTERNS.put("#", "h1");
        MARKDOWN_PATTERNS.put("##", "h2");
        MARKDOWN_PATTERNS.put("###", "h3");
        MARKDOWN_PATTERNS.put("####", "h4");
        MARKDOWN_PATTERNS.put("#####", "h5");
        MARKDOWN_PATTERNS.put("######", "h6");
        MARKDOWN_PATTERNS.put(">", "q");
    }

}
