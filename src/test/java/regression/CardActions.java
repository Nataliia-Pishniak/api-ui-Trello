package regression;

import com.trello.api.TrelloRestClient;
import com.trello.api.core.BrowserFactory;
import com.trello.api.core.pages.BoardsPage;
import com.trello.api.core.pages.CardPage;
import com.trello.api.core.pages.LoginPage;
import com.trello.api.models.Card;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;

import java.util.Date;

public class CardActions extends BrowserFactory {

    public TrelloRestClient client = new TrelloRestClient();

    public LoginPage loginPage = new LoginPage();
    public BoardsPage boardsPage = new BoardsPage();
    public CardPage cardPage = new CardPage();

    Card card = new Card("Test_Card_"+new Date().getTime());

    @BeforeTest
    public void prepareData() throws IOException {
        card = client.cardsService.createCard("5d1243d7c2b5517f63f3a07a", card).execute().body();
    }

    @AfterTest
    public void clearData() throws IOException {
        client.cardsService.deleteCard(card.id).execute();
    }

    @Test
    public void login(){
        loginPage.open();
        loginPage.login("npishnyak123@gmail.com", "nat180884");
        // boardsPage.openBoard("jacksparrowtitle");
    }

    @Test
    public void openCard(){
        loginPage.open();
    }

    @Test
    public void moveCard(){
        //   cardPage.moveToList(""):

    }

    @Test
    public void rename(){

    }




}
