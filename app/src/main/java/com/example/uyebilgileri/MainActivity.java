package com.example.uyebilgileri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Models.Uye;
import Models.Uyebilgiler;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button gonder;
    String idv;
    String uyeidv,uyeadiv,uyeemailv,uyeresimv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimlama();
        gonder();
    }
    public void tanimlama(){

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        gonder=findViewById(R.id.gonder);
    }


    public  void gonder(){
        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernamev=username.getText().toString();
                String passwordv=password.getText().toString();
                ManagerAll managerAll=new ManagerAll();
                Call<Uye> uyeCall=managerAll.uyeal(usernamev,passwordv);
                uyeCall.enqueue(new Callback<Uye>() {
                    @Override
                    public void onResponse(Call<Uye> call, Response<Uye> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getApplicationContext(),response.body().getPassword(),Toast.LENGTH_LONG).show();
                        }
                        idv=String.valueOf(response.body().getId());
                        gecisyap(idv);

                    }

                    @Override
                    public void onFailure(Call<Uye> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"bilgileri kontrol edin",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }


    public void gecisyap(String idv){

        ManagerAll managerAll=new ManagerAll();
        Call<Uyebilgiler> uyebilgilerCall=managerAll.uyedatayal(idv);
        uyebilgilerCall.enqueue(new Callback<Uyebilgiler>() {
            @Override
            public void onResponse(Call<Uyebilgiler> call, Response<Uyebilgiler> response) {

                Log.i("detayy",response.body().toString());
                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                uyeidv=response.body().getUyeid();
                uyeadiv=response.body().getUyeadi();
                uyeemailv=response.body().getUyeemail();
                uyeresimv=response.body().getUyeresim();
                intent.putExtra("uyeid",uyeidv);
                intent.putExtra("uyeadi",uyeadiv);
                intent.putExtra("uyeemail", uyeemailv);
                intent.putExtra("uyeresim",uyeresimv);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<Uyebilgiler> call, Throwable t) {

            }
        });
    }
}