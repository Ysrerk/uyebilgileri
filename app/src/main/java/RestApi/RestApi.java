package RestApi;

import Models.Uye;
import Models.Uyebilgiler;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {
    @FormUrlEncoded
    @POST("/uyeler.php")
    Call<Uye>getuye(@Field("username") String username,@Field("password") String password);

    @FormUrlEncoded
    @POST("/uyebilgiler.php")
    Call<Uyebilgiler>getuyedetay(@Field("id") String id);

}
