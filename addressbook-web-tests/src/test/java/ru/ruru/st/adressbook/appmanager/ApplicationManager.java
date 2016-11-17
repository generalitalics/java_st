package ru.ruru.st.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by m.shoshin on 14.11.2016.
 */
public class ApplicationManager {

    protected final ApplicationManager app = new ApplicationManager();
    private final ContactHelper contactHelper = new ContactHelper();

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;

    public void init() {
        contactHelper.wd = new FirefoxDriver();
        contactHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        contactHelper.wd.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(contactHelper.wd);
        navigationHelper = new NavigationHelper(contactHelper.wd);
        sessionHelper = new SessionHelper(contactHelper.wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        contactHelper.wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void gotoContactPage() {
        contactHelper.wd.findElement(By.linkText("add new")).click();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
