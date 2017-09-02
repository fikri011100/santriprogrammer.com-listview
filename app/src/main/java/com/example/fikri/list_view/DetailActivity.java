package com.example.fikri.list_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    TextView txtNamaBuah,txtDeskripsi;
    ImageView ivGambar,imgBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtNamaBuah = (TextView)findViewById(R.id.txtNamaBuah);
        txtDeskripsi= (TextView)findViewById(R.id.txtDeskripsi);
        imgBuah=(ImageView)findViewById(R.id.imgBuah);
        txtNamaBuah.setText(getIntent().getStringExtra("judul"));
        txtDeskripsi.setText(getIntent().getStringExtra("deskripsi"));
        Toast.makeText(getApplicationContext(), getIntent().getIntExtra("gbr",0), Toast.LENGTH_LONG).show();
        imgBuah.setImageResource(getIntent().getIntExtra("gbr",0));
    }
}
