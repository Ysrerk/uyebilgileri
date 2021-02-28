package com.example.uyebilgileri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity {
    String uyeidvv,uyeadivv,uyeemailvv,uyeresimvv;
    TextView uyeid,uyeadi,uyeemail;
    ImageView uyeresim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tanimla();
        degerlerial();
    }
    public void tanimla(){
        uyeid=findViewById(R.id.uyeid);
        uyeadi=findViewById(R.id.uyeadi);
        uyeemail=findViewById(R.id.uyeemail);
        uyeresim=findViewById(R.id.imageview);

    }


    public void degerlerial(){

        Bundle bundle=getIntent().getExtras();
        uyeidvv=bundle.getString("uyeid");
        uyeadivv=bundle.getString("uyeadi");
        uyeemailvv=bundle.getString("uyeemail");
        uyeresimvv=bundle.getString("uyeresim");

        uyeid.setText(uyeidvv);
        uyeadi.setText(uyeadivv);
        uyeemail.setText(uyeemailvv);
        Picasso.get().load("https://alexkanada.000webhostapp.com/arabalarim/"+uyeresimvv).into(uyeresim);




    }
}