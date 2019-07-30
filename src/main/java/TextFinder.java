import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.IOException;
import java.net.URL;

public class TextFinder {

    public Document getPage(String url) throws IOException {
        // Добавить антиспам фильтр

        if(url.substring(0,4).equals("http")) {
            // Парсит страницу

            // 3000?
            Document page = Jsoup.parse(new URL(url), 3000);
            return page;
        }
        else return null;

    }

    public String getText(Document document) throws IOException {

        Elements elements = new Elements();
        // Определять текст статьи от остального
        for (Element element : document.select("p")){

            // Через массив лучше?
            elements.add(element);
            /*strText+=element.text();
            System.out.println(element.text());*/

        }

        return elements.text();
    }




    public static void main(String[] args) throws IOException {
        //Document page = getPage("https://bazis-stan.ru/produkciya/setka/avarijnaya-setka");

        // Парсит только таблтцу
       //Elements tableWth = page.select("p");
        //getText(page);
    }
}
