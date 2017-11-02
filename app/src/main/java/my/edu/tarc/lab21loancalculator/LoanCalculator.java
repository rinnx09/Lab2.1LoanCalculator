package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoanCalculator extends AppCompatActivity {


    public static final String LOAN_STATUS = "status";
    public static final String LOAN_PAYMENT = "payment";

    private EditText editTextSalary, editTextVP, editTextDP, editTextIR, editTextRM;
    private TextView textViewMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calculator);
    }

    public void calculateLoan(View view){

        double payment;
        String status;

        Intent intent = new Intent(this,Result.class);

        startActivity(intent);

        editTextSalary = (EditText)findViewById(R.id.editTextSalary);
        editTextVP = (EditText)findViewById(R.id.editTextVP);
        editTextDP = (EditText)findViewById(R.id.editTextDP);
        editTextIR = (EditText)findViewById(R.id.editTextIR);
        editTextRM = (EditText)findViewById(R.id.editTextRM);
        textViewMP = (TextView)findViewById(R.id.textViewMP);

        double Salary, VP, DP, IR, RM ,TotalInterest, TotalLoan, MonthlyPayment;

        Salary = Double.parseDouble(editTextSalary.getText().toString());
        VP = Double.parseDouble(editTextVP.getText().toString());
        DP = Double.parseDouble(editTextDP.getText().toString());
        IR = Double.parseDouble(editTextIR.getText().toString());
        RM = Double.parseDouble(editTextRM.getText().toString());


        TotalInterest = (VP-DP) * IR * (RM/12);
        TotalLoan = (VP-DP) + TotalInterest;
        MonthlyPayment = TotalLoan/RM;

        if(MonthlyPayment > (0.3*Salary)){
            status = "REJECTED";
        }else
            status ="Approved";



        //Use to putExtra method to pass data
        //format: putExtra(TAG,value)
        intent.putExtra(LOAN_PAYMENT,MonthlyPayment);
        intent.putExtra(LOAN_STATUS,status);
    }
}
