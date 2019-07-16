package com.trello.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.trello.api.Test.Lable;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TrelloApi {

    public static final String KEY = "b7c793fddd60739a947f051fdcd4999a";
    public static final String TOKEN = "a11fac1bc9b1347817392650e77c7fa984c2959f4686eef67895f43b4d615ff2";



    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).build();

    public String createLable(String name) throws IOException {

        String idBoard = "123456";
        String color ="yellow";
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
                "{\"idBoard\":\"" + idBoard + "\"\", \"name\":\"" + name + "\", \"color\":\"" + color + "\",\"key\": \"" + KEY + "\", \"token\": \"" + TOKEN + "\"}");

        Request request = new Request.Builder()
                .url("https://api.trello.com/1/labels")
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
        Gson gson = new GsonBuilder().create();
        Lable lable = gson.fromJson(response, Lable.class);
        return lable.id;
    }

    public Lable getLable(String id) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/labels/" + id + "?key=" + KEY + "&token=" + TOKEN)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(response, Lable.class);
    }

    public void updateLable(String id, String name) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
                "{\"name\":\"" + id + "\", \"key\": \"" + KEY + "\", \"token\": \"" + TOKEN + "\"}");

        Request request = new Request.Builder()
                .url("https://api.trello.com/1/labels/" + id)
                .put(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

    public void deleteLable(String id) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/labels/" + id + "?key=" + KEY + "&token=" + TOKEN)
                .delete()
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }
}

