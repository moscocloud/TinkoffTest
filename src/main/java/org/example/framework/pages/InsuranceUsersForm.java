package org.example.framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsuranceUsersForm extends BasePage {
    @FindBy(xpath = "//div[@data-field-name='participants_title']")
    private WebElement numberStepBlock;

    @FindBy(xpath = "//input[contains(@name,'Participants_0_fio')]")
    private WebElement inputFirtsAndLastNameParticipants;

    @FindBy(xpath = "//input[contains(@name,'Participants_0_birthdate')]")
    private WebElement inputBirthdateParticipants;

    @FindBy(xpath = "//input[@name='fio']")
    private WebElement inputFullNameBuyer;
    @FindBy(xpath = "//input[@name='birthdate']")
    private WebElement inputBirthdateBuyer;
    @FindBy(xpath = "//input[@name='phone_mobile']")
    private WebElement InputPhoneBuyer;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement inputEmailBuyer;

    @FindBy(xpath = "//button[@name='go_to_options_step']")
    private WebElement buttonNext;

    /**
     * Проверка что блок заполнения страховки сменился
     *
     * @return InsuranceUsersForm т.е. this
     */
    @Step("Смена блока формы (2 Шаг)")
    public InsuranceUsersForm checkBlockChange() {
        LOGGER.info("Проверка перехода на второй шаг заполнения");
        checkOpenWithText("Участники поездки", numberStepBlock);
        return this;
    }

    /**
     * Заполнение имени и фамилии. ОБЯЗАТЕЛЬНО НА ЛАТИНИЦЕ, регистр не важен.
     * В методе выполнена проверка введеных в параметр значений на наличие символов
     * кириллицы.
     * В конце метода проверка на правильность введенных значений
     *
     * @param firstAndLastName имя и фамилия НА ЛАТИНИЦЕ
     * @return InsuranceUsersForm т.е. this
     */
    @Step("Ввод имени и фамилии {firstAndLastName} пользователя")
    public InsuranceUsersForm inputFieldNameParticipants(String firstAndLastName) {
        LOGGER.info("Ввод имени и фамилии");
        boolean isItCyrillic = firstAndLastName
                .chars()
                .mapToObj(Character.UnicodeBlock::of)
                .anyMatch(b -> b.equals(Character.UnicodeBlock.CYRILLIC));
        if (isItCyrillic) {
            throw new RuntimeException("В методе \"inputFieldName\" введите имя и фамилию латиницей");
        } else {
            fillingField(inputFirtsAndLastNameParticipants, firstAndLastName);
            inputFirtsAndLastNameParticipants.sendKeys(Keys.ENTER);
        }
        Assertions.assertEquals(
                inputFirtsAndLastNameParticipants.getAttribute("value"),
                firstAndLastName.toUpperCase()
        );
        return this;
    }

    /**
     * Ввод даты рождения.
     * в конце иетода проверка на введеное значение
     */
    @Step("Ввод даты рождения участника поездки ({day}.{mount}.{year})")
    public InsuranceUsersForm inputFieldBirthdateParticipants(String date) {
        LOGGER.info("Ввод даты рождения участника поездки");
        fillingField(inputBirthdateParticipants, date);
        inputBirthdateParticipants.sendKeys(Keys.ENTER);
        Assertions.assertEquals(
                inputBirthdateParticipants.getAttribute("value"),
                date
        );
        return this;
    }

    @Step("Ввод ФИО покупателя {fullname}")
    public InsuranceUsersForm inputFullnameBuyer(String fullname) {
        LOGGER.info("Ввод ФИО пользователя");
        fillingField(inputFullNameBuyer, fullname);
        return this;
    }


    @Step("Ввод даты рождения покупателя ({day}.{mount}.{year})")
    public InsuranceUsersForm inputFieldBirthdateBuyer(String date) {
        LOGGER.info("Ввод даты рождения покупателя");
        fillingField(inputBirthdateBuyer, date);
        inputBirthdateBuyer.sendKeys(Keys.ENTER);
        Assertions.assertEquals(
                inputBirthdateBuyer.getAttribute("value"),
                date
        );
        return this;
    }

    /**
     * Метод введения мобильного телефона и эмейла
     *
     * @param phone
     * @param email
     * @return
     */
    @Step("Введение номера телефона {phone} и эмейла {email}")
    public InsuranceUsersForm inputPhoneAndEmail(String phone, String email) {
        fillingField(InputPhoneBuyer, phone);
        fillingField(inputEmailBuyer, email);
        return this;
    }

    @Step("Нажатие на кнопку далее")
    public void clickButtonNext() {
        buttonNext.click();
    }

}


