package com.example.fikri.list_view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String nama_buah[] = {
            "Manggis", "Apel", "Strawberry", "Durian", "Ceri", "Jambuair", "Alpukat"
    };
    ListView lvdata;
    int gbr[] = {
            R.drawable.manggis, R.drawable.apel, R.drawable.strawberry, R.drawable.durian, R.drawable.ceri, R.drawable.jambuair, R.drawable.alpukat,
    };
    String deskripsi[] = {
            "Ungu Basi Gak enak", "Enak, Buah Khas Malang", "Kecil kecut Mahal, gak enak", "Hitam Kecut Pahit",
            "Buah Enak dan Mahal, jarang ada di bumi", "Buah Enak banget pokoknya", "enak"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CustomListViewActivity.class));
            }
        });
        lvdata = (ListView) findViewById(R.id.lvData);
        CustomAdapter adapter = new CustomAdapter(this, nama_buah, deskripsi, gbr);
        lvdata.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class CustomAdapter extends ArrayAdapter<String> {
        Context context;
        String nama_buah[];
        String deskripsi[];
        int gbr[];

        public CustomAdapter(MainActivity customListViewActivity, String[] nama_buah, String[] deskripsi, int[] gbr) {
            super(customListViewActivity, R.layout.listbuah, nama_buah);
            this.context = customListViewActivity;
            this.nama_buah = nama_buah;
            this.deskripsi = deskripsi;
            this.gbr = gbr;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //memanggil layout listbuah.xml
            View v = getLayoutInflater().inflate(R.layout.listbuah, null, true);
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