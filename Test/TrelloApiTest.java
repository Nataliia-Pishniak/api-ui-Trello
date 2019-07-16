package com.trello.api.Test;



import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TrelloApiTest
{
    @Test
    public void testGetLable() throws IOException {

        TrelloApi trelloApi= new TrelloApi();

        String name = "abcd";
        String idBoard = "5d2e347caee9355604b186e8";
        String color ="yellow";
        String lableId = trelloApi.createLable(name);


       Assert.assertNotEquals(lableId, "");

        Lable lable = trelloApi.getLable(lableId);

        Assert.assertEquals(lable.name, name);

        name = "qwer";

        trelloApi.updateLable(lableId, name);

        lable = trelloApi.getLable(lableId);

        Assert.assertEquals(lable.name, name);

       trelloApi.deleteLable(lableId);


    }


}

