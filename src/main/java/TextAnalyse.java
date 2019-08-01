public class TextAnalyse {


    /*
    Добавить:
    * Количество слов	38
Количество уникальных слов	27
Количество значимых слов	16
Количество стоп-слов	9
Вода	57.9 %
Количество грамматических ошибок	4
Классическая тошнота документа	2.00
Академическая тошнота документа
    * */

    private String text;

    public TextAnalyse(String text) {
        this.text = text;
    }

    public int getCharactersWithSpaces() {
        int characters = 0;
        for (int i = 0; i < text.length(); i++) {
            characters++;
        }

        return characters;
    }

    public int getCharactersWithoutSpaces() {
        int characters = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') characters++;
        }

        return characters;
    }

    public int getWords(){
        // Исправить ошибку с "онлайн — профессиональный" = 3 слова
        int characters = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') characters++;
        }

        return characters;
    }


}
