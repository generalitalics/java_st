package ru.ruru.st.adressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.ruru.st.adressbook.appmanager.ApplicationManager;

/**
 * Created by m.shoshin on 11.11.2016.
 */
public class TestBase {


    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}

