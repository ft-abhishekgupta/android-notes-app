package com.example.abhishek.simplenotes;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.abhishek.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                String[] list={
                        "1: Topic 1",
                        "2: Topic 2",
                        "3: Topic 3",
                        "4: Topic 4",
                        "5: Topic 5"
                };
        lv= (ListView) findViewById(R.id.lv);
        ArrayAdapter<String> ad=new ArrayAdapter<String>(this,R.layout.listviewtext,list);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv= (TextView) view;
        String n=tv.getText().toString();
        Intent i=new Intent(this,Content.class);
        i.putExtra("name",n);
        i.putExtra("pos",position);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i=item.getItemId();
        switch (i) {
            case R.id.rate: {
                Toast.makeText(this, "Thankyou", Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                }
                return true;
            }
            case R.id.about: {
                Intent ii=new Intent(this,About.class);
                startActivity(ii);
                return true;
            }
            case R.id.dev: {
                Intent ii=new Intent(this,Developer.class);
                startActivity(ii);
                return true;
            }
            case R.id.exit: {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}