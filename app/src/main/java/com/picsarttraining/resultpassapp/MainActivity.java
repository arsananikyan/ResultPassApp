package com.picsarttraining.resultpassapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int SEC_ACT_CODE = 12345;
    private TextView textEditText;
    private TextView numberEditText;
    private View passInfoButton;
    private TextView newText;
    private TextView newNumber;
    private String textString;
    private int numberString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textEditText = (TextView) findViewById(R.id.text_edit_1);
        numberEditText = (TextView) findViewById(R.id.number_edit_1);
        passInfoButton = findViewById(R.id.pass_info_button);
        newText = (TextView) findViewById(R.id.new_text);
        newNumber = (TextView) findViewById(R.id.new_number);
        passInfoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        textString = textEditText.getText().toString();
        numberString = Integer.parseInt(numberEditText.getText().toString());
        Intent secondActivityIntent = new Intent(this, SecondActivity.class);
        secondActivityIntent.putExtra("text", textString);
        secondActivityIntent.putExtra("number", numberString);
        startActivityForResult(secondActivityIntent, SEC_ACT_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SEC_ACT_CODE && resultCode == RESULT_OK
                && null != data) {
            newText.setText(textString + data.getStringExtra("newText"));
            newNumber.setText(data.getIntExtra("newNumber",0)+numberString+"");
        }
    }

}
