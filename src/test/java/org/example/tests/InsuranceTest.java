package org.example.tests;

import org.example.framework.pages.StartPage;
import org.example.tests.base.BaseTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class InsuranceTest extends BaseTests {

    @Test
    @Timeout(20)
    @DisplayName("Check insurance section")
    public void checkInsurance() {

        pageManager.getPage(StartPage.class)
                .checkLogoIsDisplayed()
                .selectBaseMenuByText("Страхование")
                .checkOpenInsuranceSection()
                .clickCalculatedCount()
                .checkOpenFormInsuranceTravel()
                .inputFieldCountry("Швеция")
                .inputFieldDate("23", "07", "2023", "26", "09", "2023")
                .clickButtonCalculated();


    }
}

