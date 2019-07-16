package com.trello.api.Test;

import com.trello.api.core.BrowserFactory;
import com.trello.api.core.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNotSame;

public class TrelloLoginLogout extends BrowserFactory {

    @Test(priority = 1)
    public void checkLogin() {

        LoginPage loginPage = new LoginPage();
        loginPage.open();
        assertNotNull(loginPage);
        assertEquals(driver.getCurrentUrl(), "https://trello.com/login");
        assertEquals("Log in to Trello", driver.findElement(By.tagName("h1")).getText());
        loginPage.login("npishnyak123@gmail.com", "nat180884");
    }

    @Test(priority = 2)
    public void checkBoard() {
        assertEquals("Personal Boards", driver.findElement(By.className("boards-page-board-section-header-name")).getText());
        //      driver.findElement(By.className("member-initials")).click();
        driver.findElement(By.xpath("//*[@id='header']/div[2]/button[3]")).click();
        assertEquals("npishnyak (npishnyak)", driver.findElement(By.xpath("//*[@id='layer-manager-popover']/div/div[1]/span")).getText());
        assertNotSame("Recently Viewed", driver.findElement(By.className("boards-page-board-section-header-name")).getText());
    }

    @Test(priority = 3)
    public void Logout() {
        assertEquals("Log Out", driver.findElement(By.xpath("//*[@id='header']/div[2]/button[3]")).getText());
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/button[3]")).click();
        assertEquals("Logged out of Trello", driver.getTitle());
        assertEquals("Thanks for using Trello.", driver.findElement(By.tagName("h1")).getText());

    }
}