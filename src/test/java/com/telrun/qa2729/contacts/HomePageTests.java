package com.telrun.qa2729.contacts;

import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void openHomePageTest() {
        System.out.println("Site opened!!!");
        //verify to displayed Home Component form
//        System.out.println("Component Form: " + isComponentFormPresent());

        //  isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
        app.getContact().isComponentFormPresent();
    }

}
