package com.example.chap10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ex17 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex15);
        setTitle("메인 액티비티");

        Button btnNewActivity = (Button) findViewByID(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
            EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("Num1", Interger.parseInt (edtNum1.getText().toString()));
            intent.putExtra("Num2", Interger.parseInt (edtNum2.getText().toString()));
            startActivityForResult(intent, 0);

        }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(),
                    "합계 :" + hap, Toast.LENGTH_SHORT).show();
        }

    }
}