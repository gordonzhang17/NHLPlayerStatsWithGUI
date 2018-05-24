import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Connection {

    public static Document connect(String completedURL) throws IOException {

        Document document;
        document = Jsoup.connect(completedURL).get();

        if (document.text().contains("NHL") && document.text().contains("ice hockey")) {
            return document;
        } else {
                document = Jsoup.connect(MakeURL.makeNewURLWithIceHockey(completedURL)).get();

        }

        return document;
    }
}