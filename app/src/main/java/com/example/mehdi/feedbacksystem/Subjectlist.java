package com.example.mehdi.feedbacksystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Subjectlist extends AppCompatActivity {

    int[] IMAGES = {R.drawable.book, R.drawable.book, R.drawable.book,R.drawable.book,R.drawable.book,R.drawable.book,R.drawable.book,R.drawable.book,R.drawable.book,R.drawable.book,};
    String[] NAMES ={"Teacher1","Teacher2","Teacher3","Teacher4","Teacher5","Teacher6","Teacher7","Teacher8","Teacher9","Teacher10"};
    String[] DESCRIPTIONS ={"aaaaaaa","bbbbb","cccccc","ddddd","eeeeee","ffffff","gggg","hhhhh","iiiii","jjjj"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjectlist);


        ListView listView=(ListView)findViewById(R.id.ListView);

        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);


    }
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
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
        public View getView(int i, View view, ViewGroup parent) {
            view= getLayoutInflater().inflate(R.layout.customlayout,null);
            ImageView imageView=(ImageView)view.findViewById(R.id.imageview);
            TextView textView1=(TextView)view.findViewById(R.id.text1);
            TextView textView=(TextView)view.findViewById(R.id.text2);
            imageView.setImageResource(IMAGES[i]);

            textView1.setText(NAMES[i]);
            textView.setText(DESCRIPTIONS[i]);
            return view;
        }
    }
}

