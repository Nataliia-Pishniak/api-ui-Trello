package com.trello.api;

import org.testng.annotations.Test;

import java.io.IOException;

public class TrelloApiTest
{
    @Test
    public void testGetBoardLists() throws IOException {

        TrelloApi trelloApi= new TrelloApi();
        

        String boardList = trelloApi.getBoardLists("u3tc6fPT");


        trelloApi.createCard("xxx");
        System.out.println(boardList);
    }


}

