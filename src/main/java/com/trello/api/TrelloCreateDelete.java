package com.trello.api;


import com.trello.api.core.BrowserFactory;
import com.trello.api.core.pages.LoginPage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


import static jdk.nashorn.internal.objects.NativeJava.type;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;


public class TrelloCreateDelete extends BrowserFactory {

    @Test(priority=1)
    public void trelloLogin() {

        LoginPage loginPage = new LoginPage();
        loginPage.open();
        assertNotNull(loginPage);
        assertEquals(driver.getCurrentUrl(), "https://trello.com/login");
        assertEquals("Log in to Trello", driver.findElement(By.tagName("h1")).getText());
        loginPage.login("npishnyak123@gmail.com", "nat180884");
    }

    @Test(priority=2)
    public void createNewBoard() throws ClassNotFoundException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("Personal Boards", driver.findElement(By.xpath("//*[@id='content']//h3")).getText());
        driver.findElement(By.xpath("//*[@id='header']/div[5]/a[1]/span")).click();
        assertEquals("Create", driver.findElement(By.className("pop-over-header-title")).getText());
        driver.findElement(By.xpath("//*[@class='js-new-board']")).click();
        driver.findElement(By.xpath("//*[@class='subtle-chooser-trigger unstyled-button vis-chooser-trigger']"));
        type((By.xpath("//*[@class='subtle-input']")), "NewBoard");
        driver.findElement(By.xpath("//span[contains(text(),'Create Board')]")).click();
        driver.findElement(By.xpath("//*[@class='js-board-editing-target board-header-btn-text']")).click();
    }

    @Test(priority=3)
    public void deleteNewBoard() {
        assertEquals("Menu", driver.findElement(By.xpath("//*[@class='board-menu-header-title js-board-menu-title-text']")).getText());
        driver.findElement(By.xpath("//*[@class='board-menu-navigation-item-link js-open-more']")).click();
        driver.findElement(By.xpath("//*[@class='board-menu-navigation-item-link js-close-board']")).click();
        driver.findElement(By.xpath("//*[@class='js-confirm full negate']")).click();
        assertEquals("NewBoard is closed.", driver.findElement(By.tagName("h1")).getText());
    }
}