package com.trello.api;

import com.trello.api.core.BrowserFactory;
import com.trello.api.core.pages.LoginPage;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.*;

import static jdk.nashorn.internal.objects.NativeJava.type;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class TrelloAddToFavourite extends BrowserFactory {

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
        driver.findElement(By.xpath("//*[@id='header']/div[2]/button[1]/span")).click();
        assertEquals("Create", driver.findElement(By.className("pop-over-header-title")).getText());
        driver.findElement(By.xpath("//*[@class='js-new-board']")).click();
        driver.findElement(By.xpath("//*[@class='subtle-chooser-trigger unstyled-button vis-chooser-trigger']"));
        type((By.xpath("//*[@class='subtle-input']")), "NewBoard");
        driver.findElement(By.xpath("//span[contains(text(),'Create Board')]")).click();
        driver.findElement(By.xpath("//*[@class='js-board-editing-target board-header-btn-text']")).click();
    }

    @Test(priority=3)
    public void makeFavouriteBoard() {
        driver.findElement(By.xpath("//*[@class='icon-sm icon-star board-header-btn-icon']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id='content']//h3")).click();
        assertEquals("Starred Boards", driver.findElement(By.xpath("//h3[contains(text(),'Starred Boards')]")).getText());
    }
}
