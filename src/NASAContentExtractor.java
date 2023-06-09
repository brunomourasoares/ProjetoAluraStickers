﻿import java.util.List;
import java.util.Map;

public class NASAContentExtractor implements ContentExtractor {

    public List<Content> extractContents(String json) {

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> attributesList = parser.parse(json);

        return attributesList.stream().map(attributes -> new Content(attributes.get("title"), attributes.get("url"))).toList();
    }
}