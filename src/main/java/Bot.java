import org.jsoup.nodes.Document;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    public static void main(String[] args) throws IOException {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


        TextFinder textFinder = new TextFinder();
        Document document = textFinder.getPage("https://bazis-stan.ru/produkciya/setka/avarijnaya-setka");
        String text = textFinder.getText(document);

        TextAnalyse textAnalyse = new TextAnalyse(text);
        System.out.println(textAnalyse.getCharactersWithSpaces());
        System.out.println(textAnalyse.getCharactersWithoutSpaces());

        String s = "Семантический анализ текста Адвего для SEO онлайн — профессиональный инструмент для оценки качества текстов, seo оптимизации статей и поиска ключевых слов в тексте. Проверьте количество символов, тошноту и водность, плотность ключевых слов и фраз онлайн, семантическое ядро текста бесплатно!";
        TextAnalyse textAnalyse2 = new TextAnalyse(s);
        System.out.println(textAnalyse2.getCharactersWithoutSpaces()+" "+textAnalyse2.getCharactersWithSpaces()
        +" Words:"+ textAnalyse2.getWords()+" UWords:"+ textAnalyse2.getUniqWords() );






    }

    public void onUpdateReceived(Update update) {

    }

    public void sendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);

    }

    public void onUpdatesReceived(Update update) {

        Message message = update.getMessage();
        if (message != null && message.hasText()){
            switch (message.getText()){
                case "/help":
                    sendMsg(message, "How can i help you? ");
                    break;
                case "/setting":
                    sendMsg(message, "What you will customize?");
                    break;
                default:
                    sendMsg(message, "How can i help you? ");


            }
        }
    }

    public String getBotUsername() {
        return "SemanticPageAnalysisBot";
    }

    public String getBotToken() {
        return "936028498:AAErOoUBjQsDNMJUlCL-uTDmMoaSg0hFqmo";
    }
}
