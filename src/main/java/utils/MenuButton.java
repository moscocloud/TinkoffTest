package utils;

public enum MenuButton {
    INSURANCE("Страхование"),
    DEBIT_CARDS("Дебетовые карты"),
    CREDITS("Кредиты"),
    DEPOSITS_AND_ACCOUNTS("Вклады и счета"),
    INVESTMENTS("Инвестиции"),
    SIM_CARD("Сим-карта"),
    TRIPS("Путешествия"),
    BUSINESS("Бизнес");

    private final String data;

    MenuButton(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

