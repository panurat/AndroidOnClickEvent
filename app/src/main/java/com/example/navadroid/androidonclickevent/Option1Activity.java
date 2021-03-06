package com.example.navadroid.androidonclickevent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// TODO: XML onClick attribute & View id
public class Option1Activity extends AppCompatActivity {

    private EditText etInput;
    private TextView tvOutput;
    private Button button_next;
    private Button button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option1);
        button_next = (Button)findViewById(R.id.button_next);
        button_back = (Button)findViewById(R.id.button_back);
        bindView();
    }

    // To bind views to this activity
    private void bindView(){
        etInput = (EditText) findViewById(R.id.et_input_1);
        tvOutput = (TextView) findViewById(R.id.tv_body_1);
    }

    // This "process" method MUST be bound in the layout XML file, "android:onClick="process""
    public void process(View v) {
        if(v.getId() == R.id.btn_process_1) {
            greet();
        }
        else if(v.getId() == R.id.button_next){
            next();
        }
        else if(v.getId() == R.id.button_back){
            back();
        }
        hideKeyboardInput(v);
    }

    public void next() {
        Intent intent = new Intent(this,Option2Activity.class);
        startActivity(intent);

    }
    public void back() {
        Intent intent = new Intent(this,Option5Activity.class);
        startActivity(intent);

    }

    // To greet the user
    private void greet(){
        tvOutput.setText(getString(R.string.greeting) + " " + etInput.getText().toString());
    }

    // To hide Android soft keyboard
    private void hideKeyboardInput(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
