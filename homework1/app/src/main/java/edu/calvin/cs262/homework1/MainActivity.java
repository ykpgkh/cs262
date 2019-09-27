package edu.calvin.cs262.homework1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void doCalculate( View v) {
//        EditText e1=(EditText) findViewById(R.id.value1);
//        EditText e2=(EditText) findViewById(R.id.value2);
//        TextView t1=(TextView) findViewById(R.id.result);
//        int num1=Integer.parseInt(e1.getText().toString());
//        int num2=Integer.parseInt(e2.getText().toString());
//
////        int sum=num1+num2;
//        t1.setText(Integer.toString(doSum()));

//    }

//A lot of help was gotten from this youtube video to create the buttons https://www.youtube.com/watch?v=GRrhryjOrL8
    public void doSum( View v) {
        //stores the first and second values in e1 and e2
        EditText e1=(EditText) findViewById(R.id.value1);
        EditText e2=(EditText) findViewById(R.id.value2);
        //it saves the results in t1 then pushes it to the result window
        TextView t1=(TextView) findViewById(R.id.result);
        int num1=Integer.parseInt(e1.getText().toString());
        int num2=Integer.parseInt(e2.getText().toString());

        //does the actual math. It does the operation for the first two values
        //stores them in sum, and them sum is used in t1
        int sum=num1+num2;
        t1.setText(Integer.toString(sum));

    }
    public void doSub( View v) {
        EditText e1=(EditText) findViewById(R.id.value1);
        EditText e2=(EditText) findViewById(R.id.value2);
        TextView t1=(TextView) findViewById(R.id.result);
        int num1=Integer.parseInt(e1.getText().toString());
        int num2=Integer.parseInt(e2.getText().toString());

        int sum=num1-num2;
        t1.setText(Integer.toString(sum));

    }
    public void doMul( View v) {
        EditText e1=(EditText) findViewById(R.id.value1);
        EditText e2=(EditText) findViewById(R.id.value2);
        TextView t1=(TextView) findViewById(R.id.result);
        int num1=Integer.parseInt(e1.getText().toString());
        int num2=Integer.parseInt(e2.getText().toString());

        int sum=num1*num2;
        t1.setText(Integer.toString(sum));

    }
    public void doDiv( View v) {
        EditText e1=(EditText) findViewById(R.id.value1);
        EditText e2=(EditText) findViewById(R.id.value2);
        TextView t1=(TextView) findViewById(R.id.result);
        int num1=Integer.parseInt(e1.getText().toString());
        int num2=Integer.parseInt(e2.getText().toString());

        int sum=num1/num2;
        t1.setText(Integer.toString(sum));

    }




    }

