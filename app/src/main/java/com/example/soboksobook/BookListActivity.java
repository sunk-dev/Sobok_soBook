package com.example.soboksobook;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BookListActivity extends AppCompatActivity {
    LinearLayout container;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booklist);




        container= findViewById(R.id.scroll);
        Button addBtn= (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.book, container, true);

            }
        });
    }


}
