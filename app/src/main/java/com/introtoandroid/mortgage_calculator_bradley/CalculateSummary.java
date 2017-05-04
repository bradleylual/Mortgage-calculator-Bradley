package com.introtoandroid.mortgage_calculator_bradley;

/**
 * Created by Luke Bradley on 3/14/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class CalculateSummary extends AppCompatActivity {

    TextView yearlyTaxText;
    TextView monthlyFeesText;
    TextView totalAmountText;
    Button backButton;

    Double homeValue = new Double(0);
    Double loanAmount = new Double(0);
    Double interestRate = new Double(0);
    Integer loanTerm = new Integer(0);
    Integer startDate = new Integer(0);
    Double propertyTax = new Double(0);
    Double pmi = new Double(0);
    Double homeInsurance = new Double(0);
    Double monthlyHOA = new Double(0);

    Double yearlyTax = new Double(0);
    Double monthlyFee = new Double(0);
    Double totalMortgage = new Double(0);

    public double yearlyTax(double homeValue, double propertyTax)
    {
        double decimal = propertyTax / 100.0;
        return decimal * homeValue;
    }

    public double monthlyFees(double yearlyTax, double monthlyHOA) {
        return ((yearlyTax / 12.00) + monthlyHOA);
    }

    public double totalAmount(double loanAmount, double interestRate, int loanTerm) {
        return (loanAmount * interestRate) / loanTerm;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_summary);

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


        yearlyTaxText = (TextView) findViewById(R.id.yearlyTaxText);
        monthlyFeesText = (TextView) findViewById(R.id.monthlyFeesText);
        totalAmountText = (TextView) findViewById(R.id.totalAmountText);
        backButton = (Button) findViewById(R.id.backButton);

        yearlyTax = yearlyTax(homeValue, propertyTax);
        monthlyFee = monthlyFees(yearlyTax, monthlyHOA);
        totalMortgage = totalAmount(loanAmount, interestRate, loanTerm);

        yearlyTaxText.setText("Yearly Tax: $" + Double.toString(yearlyTax));
        monthlyFeesText.setText("Monthly Fees: $" + Double.toString(monthlyFee));
        totalAmountText.setText("Total Mortgage: $" + Double.toString(totalMortgage));


        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(CalculateSummary.this, MainActivity.class);
                goBack.putExtra("homeV", homeValue);
                goBack.putExtra("loanA", loanAmount);
                goBack.putExtra("interR", interestRate);
                goBack.putExtra("loanT", loanTerm);
                goBack.putExtra("startD", startDate);
                goBack.putExtra("propT", propertyTax);
                goBack.putExtra("pmi", pmi);
                goBack.putExtra("homeI", homeInsurance);
                goBack.putExtra("monthlyHOA", monthlyHOA);
                CalculateSummary.this.startActivity(goBack);
            }
        });
    }
}
