package com.trello.api.services;

import com.trello.api.models.Board;
import com.trello.api.models.TrelloList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import com.trello.api.models.Board;
import com.trello.api.models.TrelloList;

public interface BoardServiceTest {

    @GET("board/{boardId}/lists")
    Call<TrelloList> getList(@Path("boardId") String boardId);

    @POST("boards")
    Call<TrelloList> createBoard(@Query("name") String name);

    @DELETE("boards/{id}")
    Call<TrelloList> deleteBoard(@Path("id") String id);

    @PUT("boards/{id}")
    Call<TrelloList> updateBoard(@Path("id") String id, @Body Board board);
}
