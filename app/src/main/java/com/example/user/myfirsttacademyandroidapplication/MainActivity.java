package com.example.user.myfirsttacademyandroidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    String operand;
    String temp;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.text_view);
        operand = "";
        temp = "";
        operator = "";
        ArrayList<Button> list = new ArrayList<>();
        list.add((Button)findViewById(R.id.one));
        list.add((Button)findViewById(R.id.two));
        list.add((Button)findViewById(R.id.three));
        list.add((Button)findViewById(R.id.four));
        list.add((Button)findViewById(R.id.five));
        list.add((Button)findViewById(R.id.six));
        list.add((Button)findViewById(R.id.seven));
        list.add((Button)findViewById(R.id.eight));
        list.add((Button)findViewById(R.id.nine));
        list.add((Button)findViewById(R.id.clear));
        list.add((Button)findViewById(R.id.zero));
        list.add((Button)findViewById(R.id.equal));
        list.add((Button)findViewById(R.id.add));
        list.add((Button)findViewById(R.id.subtraction));
        list.add((Button)findViewById(R.id.multiply));
        for(Button b : list)
            b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.clear:
                tv.setText("");
                operand = "";
                temp = "";
                operator = "";
                break;
            case R.id.equal:
                switch(operator){
                    case "+":
                        tv.setText("" + (Integer.parseInt(temp) + Integer.parseInt(operand)));
                        break;
                    case "-":
                        tv.setText("" + (Integer.parseInt(temp) - Integer.parseInt(operand)));
                        break;
                    case "*":
                        tv.setText("" + (Integer.parseInt(temp) * Integer.parseInt(operand)));
                        break;
                }
                operand = tv.getText().toString();
                temp = "";
                operator = "";
                break;
            case R.id.add:
                temp += operand;
                operand = "";
                operator = "+";
                break;
            case R.id.subtraction:
                if(operand.equals("") == true) {
                    operand += "-";
                    tv.setText(operand);
                } else {
                    temp += operand;
                    operand = "";
                    operator = "-";
                }
                break;
            case R.id.multiply:
                temp += operand;
                operand = "";
                operator = "*";
                break;
            default:
                operand += ((Button)findViewById(v.getId())).getText();
                tv.setText(operand);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
