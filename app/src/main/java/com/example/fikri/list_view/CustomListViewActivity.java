package com.example.fikri.list_view;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomListViewActivity extends AppCompatActivity {
    ListView lvData;
    String nama_buah[] = {
            "Manggis", "Apel", "Strawberry", "Durian", "Ceri", "Jambuair","Alpukat"
    };
    ListView lvdata;
    int gbr [] = {
            R.drawable.manggis,R.drawable.apel,R.drawable.strawberry,R.drawable.durian,R.drawable.ceri,R.drawable.jambuair,R.drawable.alpukat,
    };
    String deskripsi[] = {
            "Ungu Basi Gak enak","Enak, Buah Khas Malang","Kecil kecut Mahal, gak enak", "Hitam Kecut Pahit",
            "Buah Enak dan Mahal, jarang ada di bumi","Buah Enak banget pokoknya","enak"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        lvdata = (ListView)findViewById(R.id.lvData);
        CustomAdapter adapter = new CustomAdapter(this, nama_buah,deskripsi,gbr);
        lvdata.setAdapter(adapter);
        lvdata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent a = new Intent(getApplicationContext(),DetailActivity.class);
                a.putExtra("judul",nama_buah[position]);
                a.putExtra("gbr",gbr[position]);
                a.putExtra("deskripsi",deskripsi[position]);
                startActivity(a);
            }
        });
    }



    private class CustomAdapter extends ArrayAdapter<String> {
        Context context;
        String nama_buah[];
        String deskripsi[];
        int gbr[];

        public CustomAdapter(CustomListViewActivity customListViewActivity, String[] nama_buah,String[] deskripsi,int [] gbr) {
            super(customListViewActivity, R.layout.listbuah, nama_buah);
            this.context=customListViewActivity;
            this.nama_buah = nama_buah;
            this.deskripsi = deskripsi;
            this.gbr=gbr;
        }



        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //memanggil layout listbuah.xml
            View v = getLayoutInflater().inflate(R.layout.listbuah,null,true);
            //casting id yg ada pada listbuah
            ImageView clIvgbr = (ImageView) v.findViewById(R.id.clivgbr);
            TextView cltxtbuah = (TextView) v.findViewById(R.id.cltxtnamabuah);
            TextView cltxtdesc = (TextView) v.findViewById(R.id.cltxtdeskripsi);
            //isi data sesuai index array
            clIvgbr.setImageResource(gbr[position]);
            cltxtbuah.setText(nama_buah[position]);
            cltxtdesc.setText(deskripsi[position]);
            return v;
        }
    }
}
