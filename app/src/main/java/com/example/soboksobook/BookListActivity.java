package com.example.soboksobook;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BookListActivity extends AppCompatActivity {
    LinearLayout container,Notebook;

    DBHelper helper;
    SQLiteDatabase db;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booklist);


        helper=new DBHelper(this);
        try{
            db=helper.getWritableDatabase();

        }catch (SQLException ex){
            db=helper.getReadableDatabase();
        }

        Cursor cursor;
        cursor=db.rawQuery("SELECT * FROM mybook",null);
        startManagingCursor(cursor);
        String[] from ={"title","date"}; //보여주고 싶은 데이터
        int[] to={android.R.id.text1,android.R.id.text2}; //보여주고 싶은 데이터와 같게
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,cursor,from,to);
        ListView listView=(ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                adapter.notifyDataSetChanged();
                //인텐트로 값을 넘겨서 내용이 보이게 하기
                Toast.makeText(getApplicationContext(), (i+1)+"번째 아이템이 삭제되었습니다.", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(BookListActivity.this,BookListShowActivity.class);
                String title=cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String content=cursor.getString(cursor.getColumnIndexOrThrow("content"));
                String date=cursor.getString(cursor.getColumnIndexOrThrow("date"));

                intent.putExtra("title",title);
                intent.putExtra("content",content);
                intent.putExtra("date",date);


                startActivity(intent);
                

            }
        });








        //Button addBtn= (Button) findViewById(R.id.addBtn);
       /*addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                int book = R.layout.book;


                inflater.inflate(R.layout.book, container, true);

            }
        });*/
    }



}
