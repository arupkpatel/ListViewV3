package com.dtrix.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Soumya on 12-06-2017.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    private Context mcontext=null;
    private int mLayoutResourceid;
    private Place[] mdata =null;

    public PlaceAdapter(Context context, int resource, Place[] objects) {
        super(context, resource, objects);
        this.mcontext=context;
        this.mLayoutResourceid=resource;
        this.mdata=objects;
    }

    @Nullable
    @Override
    public Place getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row =convertView;
        PlaceHolder holder=null;

        //if no row is available
        if(row==null){
            //Inflating the rows
            LayoutInflater inflater = LayoutInflater.from(mcontext);
            row=inflater.inflate(mLayoutResourceid,parent,false);

            holder = new PlaceHolder();

            //reference time
            holder.nameview=(TextView)row.findViewById(R.id.textView);
            holder.zipView=(TextView)row.findViewById(R.id.textView2);
            holder.imageView=(ImageView)row.findViewById(R.id.imageView);

            row.setTag(holder);
        }else{
            holder=(PlaceHolder) row.getTag();
        }

        Place place = mdata[position];

        //modifying holder data
        holder.nameview.setText(place.getName());
        holder.zipView.setText(String.valueOf(place.getZip()));
        int resid=mcontext.getResources().getIdentifier("icon","mipmap",mcontext.getPackageName());
        holder.imageView.setImageResource(resid);

        //setting up popups
        holder.imageView.setOnClickListener(popup);
        holder.imageView.setTag(position);

        return row;
    }

    //setting up the Listener
    private View.OnClickListener popup = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int pos =(int) v.getTag();
            Place place = mdata[pos];
            Toast.makeText(getContext(),place.getPopup(),Toast.LENGTH_SHORT).show();
        }
    };

    public static class PlaceHolder{
        TextView nameview;
        TextView zipView;
        ImageView imageView;
    }
}
