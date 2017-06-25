package com.dtrix.listview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private String arr[]={"Sambalpur","Chennai","Delhi","Kolkata","Gujurat","Pondicherry",
            "Mahabalipuram","Space","Mars","Venus","Jupiter","Saturn","Unranus","Neptune"};
    private Place parr[]={new Place(arr[0],768004,"My Home"),
            new Place(arr[1],768004,"My House"),
            new Place(arr[2],768005,"My College"),
            new Place(arr[3],768006,"My Uncle's house"),
            new Place(arr[4],768007,"My friend's house"),
            new Place(arr[5],768008,"My friend's house"),
            new Place(arr[6],768009,"Tourism"),
            new Place(arr[7],768010,"Tourism"),
            new Place(arr[8],768011,"Tourism"),
            new Place(arr[9],768012,"My Winter Home"),
            new Place(arr[10],768013,"My Winter Home 2"),
            new Place(arr[11],768014,"My Adventure Home"),
            new Place(arr[12],768015,"My Summer Home"),
            new Place(arr[13],768016,"My Summer Home2")
    };
    private TextView mtv1 =null;
    private PlaceAdapter placeAdapter =null;
    private ListView lv1= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1=(ListView)findViewById(R.id.listview);
        mtv1=(TextView)findViewById(R.id.tv1);
        placeAdapter=new PlaceAdapter(getApplicationContext(),R.layout.row,parr);

        if(lv1!=null){
            lv1.setAdapter(placeAdapter );
        }
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("Place",parr[position].getName());
            }
        });
    }
}
