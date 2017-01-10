package com.wt.app.selectdatedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wt.app.selectdatedemo.view.SelectData;


public class MainActivity extends AppCompatActivity {
    private EditText editText1,editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.edit_text1);


        editText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SelectData selectData  = new SelectData(MainActivity.this,true);
                selectData.showAtLocation(editText1, Gravity.BOTTOM,0,0);
                selectData.setDateClickListener(new SelectData.OnDateClickListener() {
                    @Override
                    public void onClick(String year, String month, String day, String hour, String minute) {
                        Toast.makeText(MainActivity.this,
                                year + "-" + month + "-" + day+" "+hour+":"+minute,
                                Toast.LENGTH_LONG).show();
                        editText1.setText(year + "-" + month + "-" + day+" "+hour+":"+minute);

                    }
                });
            }
        });



        editText2 = (EditText) findViewById(R.id.edit_text2);

        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SelectData selectData  = new SelectData(MainActivity.this,false);
                selectData.showAtLocation(editText2, Gravity.BOTTOM,0,0);
                selectData.setDateClickListener(new SelectData.OnDateClickListener() {
                    @Override
                    public void onClick(String year, String month, String day, String hour, String minute) {
                        Toast.makeText(MainActivity.this,
                                year + "-" + month + "-" + day,
                                Toast.LENGTH_LONG).show();
                        editText2.setText(year + "-" + month + "-" + day);

                    }
                });
            }
        });
    }
}
