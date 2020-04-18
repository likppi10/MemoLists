package com.example.memo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddDataActivity extends AppCompatActivity {

    EditText etmemo;
    private Button btn_save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        etmemo=(EditText)findViewById(R.id.editmemo);
        btn_save=(Button)findViewById(R.id.btn_add);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String memo=etmemo.getText().toString();
                MemoDatalist memoDataList=new MemoDatalist();
                memoDataList.setMemo(memo);
                memoDataList.setAlarm(1);
                int ID_len = memoDataList.getId();
                Fragment1.memoDatabase.memoDao().addData(memoDataList);
                Toast.makeText(getApplicationContext(),"일정이 추가되었습니다.",Toast.LENGTH_LONG).show();

                SharedPreferences sp = getSharedPreferences("myFile",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("ID_len",ID_len);

                etmemo.setText("");

                ((Fragment1) Fragment1.mContext).Review();



            }
        });


    }
}
