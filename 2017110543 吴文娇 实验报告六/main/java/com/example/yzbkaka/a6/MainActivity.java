package com.example.yzbkaka.a6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button create;

    private Button add;

    private Button update;

    private Button delete;

    private Button query;

    private MyDatabaseHelpeer myDatabaseHelpeer;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create = (Button)findViewById(R.id.create);
        add = (Button)findViewById(R.id.add);
        update = (Button)findViewById(R.id.update);
        delete = (Button)findViewById(R.id.delete);
        query = (Button)findViewById(R.id.query);
        listView = (ListView)findViewById(R.id.list_view);

        create.setOnClickListener(this);
        add.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        query.setOnClickListener(this);

        myDatabaseHelpeer = new MyDatabaseHelpeer(this,"Person.db",null,1);
    }

    @Override
    public void onClick(View view) {
        SQLiteDatabase db = myDatabaseHelpeer.getWritableDatabase();
        switch (view.getId()){
            case R.id.create:
                myDatabaseHelpeer.getWritableDatabase();
                Toast.makeText(this, "创建数据库成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add:
                ContentValues values1 = new ContentValues();
                values1.put("name","lzy");
                values1.put("age",20);
                db.insert("Person",null,values1);
                values1.put("name","yzbkaka");
                values1.put("age",27);
                db.insert("Person",null,values1);
                break;
            case R.id.update:
                ContentValues values2 = new ContentValues();
                values2.put("age",21);
                db.update("Person",values2,"name = ?",new String[]{"lzy"});
                break;
            case R.id.delete:
                db.delete("Person","name = ?",new String[]{"yzbkaka"});
                break;
            case R.id.query:
                String sql = "select _id,name,age from Person";
                Cursor cursor = db.rawQuery(sql,null);
                SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                        R.layout.list_view_item, cursor, new String[] { "name", "age" },
                        new int[] { R.id.name, R.id.age }, 0);
                listView.setAdapter(adapter);
                break;
        }
    }
}
