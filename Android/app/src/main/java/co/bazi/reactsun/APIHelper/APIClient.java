package co.bazi.reactsun.APIHelper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mbasith on 09/02/17.
 */

public class APIClient {

    public static final String BASE_URL = "http://10.195.169.158:8080";
    private static Retrofit retrofit;

    public static Retrofit getAPIClient(){

        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
