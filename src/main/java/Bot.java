import org.jsoup.nodes.Document;

import java.io.IOException;

public class Bot {

    public static void main(String[] args) throws IOException {
        TextFinder textFinder = new TextFinder();
        Document document = textFinder.getPage("https://bazis-stan.ru/produkciya/setka/avarijnaya-setka");
        String text = textFinder.getText(document);

        TextAnalyse textAnalyse = new TextAnalyse(text);
        System.out.println(textAnalyse.getCharactersWithSpaces());
        System.out.println(textAnalyse.getCharactersWithoutSpaces());

        String s = "Семантический анализ текста Адвего для SEO онлайн — профессиональный инструмент для оценки качества текстов, seo оптимизации статей и поиска ключевых слов в тексте. Проверьте количество символов, тошноту и водность, плотность ключевых слов и фраз онлайн, семантическое ядро текста бесплатно!";
        TextAnalyse textAnalyse2 = new TextAnalyse(s);
        System.out.println(textAnalyse2.getCharactersWithoutSpaces()+" "+textAnalyse2.getCharactersWithSpaces());




    }
}
