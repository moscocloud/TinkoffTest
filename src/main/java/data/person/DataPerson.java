package data.person;

import com.ibm.icu.text.Transliterator;

public class DataPerson {

    /**
     * Получение имени и фамилии пользователя
     *
     * @return строку формата "Имя Фамилия"
     */
    public static String getFirstAndLastNameUser() {
        return GetJson.getUser().getName();
    }

    /**
     * Получение эмейла пользователя
     *
     * @return эмеил
     */
    public static String getEmailUser() {
        return GetJson.getUser().getEmail();
    }

    /**
     * Номер телефона в формате 1-770-736-8031 x56442.
     * Далее номер преобразуется до формата 9234567890
     *
     * @return номер телефона
     */
    public static String getPhoneUser() {
        return "9" + GetJson.getUser()
                .getPhone()
                .replaceAll("[^0-9]", "")
                .substring(0, 9);
    }

    /**
     * Получение полного ФИО пользователя, т.к.
     * в источнике нет отчества в качестве него выступает никнейм
     * Полученая строка переводится на русский язык при помощи библитеки icu4j.
     *
     * @return строку формата "Имя Фамилия Никнейм"
     */
    public static String getFullNameUser() {

        String fullname = GetJson.getUser().getName() + " " + GetJson.getUser().getUsername();
        Transliterator toEngRus = Transliterator.getInstance("Latin-Russian/BGN");
        return toEngRus.transliterate(fullname);
    }

    public static String getBirthdate() {
        int numDay = (1 + (int) (Math.random() * 28));
        int numMount = 1 + (int) (Math.random() * 12);
        String day = numDay < 10 ? "0" + numDay : String.valueOf(numDay);
        String mount = numMount < 10 ? "0" + numMount : String.valueOf(numMount);
        int year = 1960 + (int) (Math.random() * 50);
        return String.format("%s.%s.%d", day, mount, year);
    }
}
