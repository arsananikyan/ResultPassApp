package com.picsarttraining.resultpassapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView oldText;
    private TextView textEditText;
    private TextView oldNumber;
    private TextView numberEditText;
    private View goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        oldText = (TextView) findViewById(R.id.old_text);
        oldNumber = (TextView) findViewById(R.id.old_number);
        textEditText = (TextView) findViewById(R.id.text_edit_2);
        numberEditText = (TextView) findViewById(R.id.number_edit_2);
        goBackButton = findViewById(R.id.go_back);
        goBackButton.setOnClickListener(this);
        oldText.setText(getIntent().getStringExtra("text") + "+");
        oldNumber.setText(getIntent().getIntExtra("number", 0)+"+");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("newText",textEditText.getText().toString());
        if(!numberEditText.getText().toString().equals(""))
            intent.putExtra("newNumber",Integer.parseInt(numberEditText.getText().toString()));
        setResult(RESULT_OK, intent);
        finish();
    }
}
