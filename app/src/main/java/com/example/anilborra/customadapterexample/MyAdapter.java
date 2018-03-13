package com.example.anilborra.customadapterexample;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

/**
 * Created by AnilBorra on 09-Mar-18.
 */

public class MyAdapter extends BaseAdapter {

    String path = "/storage/emulated/0/WhatsApp/Media/WhatsApp Images/";
    File f = new File(path);

    String[] files = f.list();

    @Override
    public int getCount() {
        return files.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(MainActivity.mainActivity);

        View view = inflater.inflate(R.layout.indi_view,null);

        ImageView imageView = view.findViewById(R.id.iView);
        TextView textView1 = view.findViewById(R.id.name);
        TextView textView2 = view.findViewById(R.id.size);

        Button button = view.findViewById(R.id.b1);

        final File f_new=new File(path+files[position]);
        if (f_new.isFile()){
            imageView.setImageURI(Uri.fromFile(f_new));
        }
        textView1.setText(files[position]);
        textView2.setText(String.valueOf(f_new.length()/1024)+"kb");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f_new.delete();
                files = f.list();
                MyAdapter.this.notifyDataSetChanged();
            }
        });

        return view;
    }
}
