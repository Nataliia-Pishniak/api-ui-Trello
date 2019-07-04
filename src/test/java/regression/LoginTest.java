package regression;

import com.trello.api.core.BrowserFactory;
import com.trello.api.core.pages.BoardsPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import com.trello.api.core.pages.LoginPage;

@Epic("Trello")
@Feature("Trello login")
public class LoginTest extends BrowserFactory {

    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();

    @Story("Positive login")
    @Test
    public void login() {
        loginPage.open();
        loginPage.login("npishnyak123@gmail.com", "nat180884");
        boardsPage.openBoard("ABC");
    }

}