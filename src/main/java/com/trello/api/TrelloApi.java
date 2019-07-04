package com.trello.api;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TrelloApi {

    public static final String KEY="b7c793fddd60739a947f051fdcd4999a";
    public static final String TOKEN="a11fac1bc9b1347817392650e77c7fa984c2959f4686eef67895f43b4d615ff2";

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).build();


    public String getBoardLists(String boardId) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/boards/"+boardId+"/lists?cards=none&fields=all&key="+KEY+"&token="+TOKEN)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
        return response;
    }



    public void createCard(String listId) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "");
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/cards?idList="+listId+"&keepFromSource=all&key="+KEY+"&token="+TOKEN)
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

}
