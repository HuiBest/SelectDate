package com.wt.app.selectdatedemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.wt.app.selectdatedemo.view.SelectData;



public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText.getWindowToken(),0);
                SelectData selectData  = new SelectData(MainActivity.this,true);
                selectData.showAtLocation(editText, Gravity.BOTTOM,0,0);
                selectData.setDateClickListener(new SelectData.OnDateClickListener() {
                    @Override
                    public void onClick(String year, String month, String day, String hour, String minute) {
                        Toast.makeText(MainActivity.this,
                                year + "-" + month + "-" + day+" "+hour+":"+minute,
                                Toast.LENGTH_LONG).show();
                        editText.setText(year + "-" + month + "-" + day+" "+hour+":"+minute);

                    }
                });
            }
        });
    }
}
