package com.example.noel1.lab6s3;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    SQLiteDatabase db;//DB
    MySQLiteOpenHelper helper;//DB를 도와줄 헬퍼
    EditText name;//입력한 이름.
    EditText studentN;//입력한 학번.

    Button addButton;//추가 버튼
    Button deleteButton;//삭제 버튼
    String stringName;//EditText에서 얻어온 이름 값을 임시 저장하기 위한 변수.
    int stringNumber;//EditText에서 얻어온 학번 값을 임시 저장하기 위한 변수.
   String [] list;//지금 까지 기록한 정보들이 저장되기 위한 list
    ListView studentList;//ListView 변수.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new MySQLiteOpenHelper(MainActivity.this, "person1.db", null, 1);//DB 생성.

        name = findViewById(R.id.sn);//변수들과 아이디 연결.
        studentN = findViewById(R.id.sn2);
        studentList = findViewById(R.id.list1);
addButton = findViewById(R.id.addB);
deleteButton= findViewById(R.id.deleteB);

        addButton.setOnClickListener(new View.OnClickListener() {//추가 버튼을 누르면,
            @Override
            public void onClick(View v) {

                if(name.getText().toString().equals("") || studentN.getText().toString().equals("")) {//이름 또는 학번 둘중 하나라도 입력을 안했다면
                    //Toast 창이 떠서 알려준다.
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해 주세요", Toast.LENGTH_LONG).show();
                }else{//이름과 학번이 다 적혀 있을경우,
                stringName = name.getText().toString();//EditText에서 이름 부분에 입력한 정보를 변수에 저장.
                stringNumber = Integer.parseInt(studentN.getText().toString());////EditText에서 학번 부분에 입력한 정보를 int 로 변환후에 변수에 저장.
                insert(stringName, stringNumber);//insert 함수 호출.
                //Toast.makeText(getApplicationContext(),"입력완료",Toast.LENGTH_LONG).show();
                invalidate();
                name.setText("");//문장 초기화
                studentN.setText("");//문장 초기화
            }

            }
        });

deleteButton.setOnClickListener(new View.OnClickListener(){//삭제 버튼을 누를경우,
public void onClick(View v){
    if(name.getText().toString().equals("")) {//이름칸이 비어져 있을경우,
        Toast.makeText(getApplicationContext(), "이름을 입력해 주세요", Toast.LENGTH_LONG).show();
    }
    else{//이름 칸의 정보가 등록되어 있을 경우
delete(name.getText().toString());//등록한 이름을 인자로 delete 함수 호출.
        invalidate();
        name.setText("");//내용 초기화
        studentN.setText("");//내용 초기화

    }
}


});
    }

    public void select() {
//db=helper.
db=helper.getReadableDatabase();//데이터베이스를 읽기 위해 호출.
Cursor c = db.query("student",null,null,null,null,null,null);//student라는 테이블 지정.
 list=new String[c.getCount()];//table 에 있는 만큼 listView 변수에 저장하기 위해 공간 할당.
int count=0;
while(c.moveToNext()){//table 에 있는 만큼 하나하나 String 배열에 저장
   list[count]=c.getString(c.getColumnIndex("name"))+" "+c.getString(c.getColumnIndex("studentNo"));
//순서대로 String 배열에 저장.
   count++;
}
c.close();//cursor 종료.
    }


    public void insert(String name, int studentNo) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("studentNo",studentNo);
        db.insert("student",null,values);
    }
    public void delete(String name) {
        db = helper.getWritableDatabase();//데이터베이스를 쓰기 위해 호출.
        db.delete("student", "name=?", new String[]{name});//student라는 테이블에 name 의 이름이 있다면 삭제.
    }
    private void invalidate(){
        select();
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
    studentList.setAdapter(adapter);//listView 에 적용.
    }

}

