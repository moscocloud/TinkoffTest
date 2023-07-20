package org.example.tests;

import data.person.DataPerson;
import org.example.framework.pages.StartPage;
import org.example.tests.base.BaseTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static utils.MenuButton.INSURANCE;

public class InsuranceTest extends BaseTests {

    @Test
    @Timeout(20)
    @DisplayName("Check insurance section")
    public void checkInsurance() {
        String birthdate = DataPerson.getBirthdate();

        pageManager.getPage(StartPage.class)
                .checkLogoIsDisplayed()
                .selectBaseMenuByText(INSURANCE.getData())
                .checkOpenInsuranceSection()
                .clickCalculatedCount()
                .checkOpenFormInsuranceTravel()
                .inputFieldCountry("Швеция")
                .inputFieldDate("23.07.2023", "26.09.2023")
                .clickButtonCalculated()
                .checkBlockChange()
                .inputFieldNameParticipants(DataPerson.getFirstAndLastNameUser())
                .inputFieldBirthdateParticipants(birthdate)
                .inputFullnameBuyer(DataPerson.getFullNameUser())
                .inputFieldBirthdateBuyer(birthdate)
                .inputPhoneAndEmail(DataPerson.getPhoneUser(), DataPerson.getEmailUser())
                .clickButtonNext();
    }
}

