package org.example.tests;

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
                .inputFieldNameParticipants("Morgan Artur")
                .inputFieldBirthdateParticipants("21.11.1997")
                .inputFullnameBuyer("Морган Артур Иванович")
                .inputFieldBirthdateBuyer("21.11.1997")
                .inputPhoneAndEmail("9877446770", "Morgan992@gmail.com")
                .clickButtonNext();
    }
}

