package com.trello.api.core.pages;

import com.trello.api.core.Elem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardsPage {

    private static final String PATH = "loliktest4/boards";


    public Elem boardByUrlName(String urlName){
        return new Elem(By.cssSelector(".board-tile[href*='"+urlName+"']"), urlName);
    }


    public void open(){

    }

    public void isOpened(){

    }

    public void openBoard(String urlName){
        boardByUrlName(urlName).click();
    }


}

