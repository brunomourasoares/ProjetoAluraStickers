import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        API api = API.IMDB_TOP_SERIES;

        String url = api.getUrl();
        ContentExtractor extractor = api.getExtractor();

        var http = new Http_Client();
        String json = http.searchData(url);

        // exibir e manipular os dados 
        List<Content> contents = extractor.extractContents(json);

        var generator = new StickerGenerator();

        for (int i = 0; i < 3; i++) {

            Content content = contents.get(i);

            InputStream inputStream = new URL(content.urlImage()).openStream();
            String fileName = "out/" + content.title() + ".png";

            generator.create(inputStream, fileName);

            System.out.println(content.title());
            System.out.println();
        }
    }
}