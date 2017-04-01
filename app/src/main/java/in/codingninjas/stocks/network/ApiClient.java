package in.codingninjas.stocks.network;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by manishakhattar on 19/03/17.
 */

public class ApiClient {

    static ApiInterface apiInterface;

    public static ApiInterface getApiInterface(){

        if(apiInterface == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://codingninjas.in/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().
                            serializeNulls().create()))
                    .build();

            apiInterface =retrofit.create(ApiInterface.class);;
        }
        return apiInterface;
    }


}
