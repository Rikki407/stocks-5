package in.codingninjas.stocks.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by manishakhattar on 19/03/17.
 */


public interface ApiInterface {

    @GET("courses")
    Call<CoursesResponse> getCourses();



//    @GET("posts/{id}/{comment_id}")
//    Call<Post> getPost(@Path("comment_id") int comment_id, @Path("id") int id);

//    @GET("comments")
//    Call<> getCommentsForPost(@Query("postId") int post_id, @Query("") String str);


//    @POST("")
//    Call<CoursesResponse> putCourse(@Body )


}
