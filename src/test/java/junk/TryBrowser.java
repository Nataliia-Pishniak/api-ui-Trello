package junk;

import com.trello.api.core.BrowserFactory;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
@Epic("")
@Feature("")
@Story("JACK")
public class TryBrowser extends BrowserFactory {


    @Test
    public void openClose(){
        driver().get("https://google.com");
    }


}