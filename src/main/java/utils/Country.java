package utils;


public enum Country {
    USA("Соединенные Штаты Америки"),
    ALBANIA("Албания"),
    ALGERIA("Алжир"),
    ANDORRA("Андорра"),
    BRAZIL("Бразилия"),
    CANADA("Канада"),
    EGYPT("Египет"),
    FRANCE("Франция"),
    GERMANY("Германия"),
    GREECE("Греция"),
    INDIA("Индия"),
    ISRAEL("Израиль"),
    ITALY("Италия"),
    JAPAN("Япония"),
    MEXICO("Мексика"),
    RUSSIA("Россия"),
    SINGAPORE("Сингапур"),
    SPAIN("Испания"),
    SWEDEN("Швеция"),
    THAILAND("Тайланд"),
    TURKEY("Турция"),
    VIETNAM("Вьетная");

    private String country;

    Country(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

}
