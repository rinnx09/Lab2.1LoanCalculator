package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        //To get intent
        Intent intent = getIntent();
        double payment = intent.getDoubleExtra(LoanCalculator.LOAN_PAYMENT,0);
        String status = intent.getStringExtra(LoanCalculator.LOAN_STATUS);

        //// TODO: 2/11/2017 :display outputs


    }

    public void closeActivity(View view){
        //Terminate an activity
        finish();

    }
}
