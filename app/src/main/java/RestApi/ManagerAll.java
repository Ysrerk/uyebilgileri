package RestApi;

import Models.Uye;
import Models.Uyebilgiler;
import retrofit2.Call;

public class ManagerAll extends  BaseManager{

    public Call<Uye> uyeal(String username, String password){
        Call<Uye> uye=getrestapi().getuye(username,password);
        return uye;
    }
    public Call<Uyebilgiler> uyedatayal(String id){
        Call<Uyebilgiler> uyedetay=getrestapi().getuyedetay(id);
        return  uyedetay;
    }
}
