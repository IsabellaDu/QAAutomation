package com.hillel.core.data;

import org.testng.annotations.DataProvider;

public class DataProviderMethods {
    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"Ivan", "Ivanov", "Ukraine", "123456789", "ivanov@mail.com", "od", "Meta", "QA engineer", "linkedin.com/ivanov"},
                {"Anna", "Bevz", "Albania", "456789123", "bevz@mail.com", "online", "Amazon", "Senior Kotlin Android developer", "linkedin.com/bevz"},
                {"Oleg", "Koz", "Canada", "878965347", "koz@mail.com", "kh", "Nix", "Junior Java developer", "linkedin.com/koz"}
        };
    }
}
