package com.introtoandroid.mortgage_calculator_bradley;

/**
 * Created by Luke Bradley on 3/15/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class PaymentSummary extends AppCompatActivity {

    double homeValue;
    double loanAmount;
    double interestRate;
    int loanTerm;
    int startDate;
    double propertyTax;
    double pmi;
    double homeInsurance;
    double monthlyHOA;

    TextView weeklyPaymentText;
    TextView weeklyInterestText;
    TextView monthlyPaymentText;
    TextView monthlyInterestText;
    TextView yearlyPaymentText;
    TextView yearlyInterestText;

    double weeklyPayment;
    double weeklyInterest;
    double monthlyPayment;
    double monthlyInterest;
    double yearlyPayment;
    double yearlyInterest;

    Button backButton;

    public double weeklyPayment(double loanAmount, int loanTerm) {
        double loanTermDouble = (double) loanTerm;
        double weeks = loanTermDouble * 52.0;
        return loanAmount / weeks;
    }

    public double weeklyInterest(double interestRate, int loanTerm) {
        double loanTermDouble = (double) loanTerm;
        double weeks = loanTermDouble * 52.0;
        return interestRate / weeks;
    }

    public double monthlyPayment(double loanAmount, int loanTerm) {
        double loanTermDouble = (double) loanTerm;
        double months = loanTermDouble * 52.0;
        return loanAmount / months;
    }

    public double monthlyInterest(double interestRate, int loanTerm) {
        double loanTermDouble = (double) loanTerm;
        double months = loanTermDouble * 52.0;
        System.out.println(months);
        return interestRate / months;
    }

    public double yearlyPayment(double loanAmount, int loanTerm) {
        double loanTermDouble = (double) loanTerm;
        return loanAmount / loanTermDouble;
    }

    public double yearlyInterest(double interestRate, int loanTerm) {
        double loanTermDouble = (double) loanTerm;
        return interestRate / loanTermDouble;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_summary);

        Intent transfer = getIntent();
        homeValue = transfer.getDoubleExtra("homeV", homeValue);
        loanAmount = transfer.getDoubleExtra("loanA", loanAmount);
        interestRate = transfer.getDoubleExtra("interR", interestRate);
        loanTerm = transfer.getIntExtra("loanT", loanTerm);
        startDate = transfer.getIntExtra("startD", startDate);
        propertyTax = transfer.getDoubleExtra("propT", propertyTax);
        pmi = transfer.getDoubleExtra("pmi", pmi);
        homeInsurance = transfer.getDoubleExtra("homeI", homeInsurance);
        monthlyHOA = transfer.getDoubleExtra("monthHOA", monthlyHOA);


        weeklyPaymentText = (TextView) findViewById(R.id.weeklyPayment);
        weeklyInterestText = (TextView) findViewById(R.id.weeklyInterest);
        monthlyPaymentText = (TextView) findViewById(R.id.monthlyPayment);
        monthlyInterestText = (TextView) findViewById(R.id.monthlyInterest);
        yearlyPaymentText = (TextView) findViewById(R.id.yearlyPayment);
        yearlyInterestText = (TextView) findViewById(R.id.yearlyInterest);
        backButton = (Button) findViewById(R.id.goBack);

        weeklyPayment = weeklyPayment(loanAmount, loanTerm);
        monthlyPayment = monthlyPayment(loanAmount, loanTerm);
        yearlyPayment = yearlyPayment(loanAmount, loanTerm);

        weeklyInterest = weeklyInterest(interestRate, loanTerm);
        monthlyInterest = monthlyInterest(interestRate, loanTerm);
        yearlyInterest = yearlyInterest(interestRate, loanTerm);

        weeklyPaymentText.setText("Weekly Payment: $" + Double.toString(weeklyPayment));
        monthlyPaymentText.setText("Monthly Payment: $" + Double.toString(monthlyPayment));
        yearlyPaymentText.setText("Yearly Payment: $" + Double.toString(yearlyPayment));

        weeklyInterestText.setText("Weekly Interest: $" + Double.toString(weeklyInterest));
        monthlyInterestText.setText("Monthly Interest: $" + Double.toString(monthlyInterest));
        yearlyInterestText.setText("Yearly Interest: $" + Double.toString(yearlyInterest));


        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(PaymentSummary.this, MainActivity.class);
                goBack.putExtra("homeV", homeValue);
                goBack.putExtra("loanA", loanAmount);
                goBack.putExtra("interR", interestRate);
                goBack.putExtra("loanT", loanTerm);
                goBack.putExtra("startD", startDate);
                goBack.putExtra("propT", propertyTax);
                goBack.putExtra("pmi", pmi);
                goBack.putExtra("homeI", homeInsurance);
                goBack.putExtra("monthlyHOA", monthlyHOA);
                PaymentSummary.this.startActivity(goBack);
            }
        });
    }
}
