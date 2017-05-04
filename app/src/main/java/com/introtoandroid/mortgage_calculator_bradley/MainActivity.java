package com.introtoandroid.mortgage_calculator_bradley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    TextView homeValueText;
    TextView loanAmountText;
    TextView interestRateText;
    TextView loanTermText;
    TextView startDateText;
    TextView propertyTaxText;
    TextView pMIText;
    TextView homeInsurText;
    TextView monthlyHOAText;

    EditText homeVEdit;
    Double homeValue = new Double(0);
    EditText loanAEdit;
    Double loanAmount = new Double(0);
    EditText interREdit;
    Double interestRate = new Double(0);
    EditText loanTEdit;
    Integer loanTerm = new Integer(0);
    EditText startDEdit;
    Integer startDate = new Integer(0);
    EditText propertyTEdit;
    Double propertyTax = new Double(0);
    EditText pMIEdit;
    Double pmi = new Double(0);
    EditText homeIEdit;
    Double homeInsurance = new Double(0);
    EditText monthlyHOEdit;
    Double monthlyHOA = new Double(0);

    Button goCalculate;
    Button goSummary;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeVEdit = (EditText) findViewById(R.id.HomeValueeditText);
        homeVEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence d, int a, int b, int c) {

            }
            public void onTextChanged(CharSequence d, int a, int b, int c) {

            }

            public void afterTextChanged(Editable e) {
                if (e.length() > 0) {
                    homeValue = Double.valueOf(e.toString());
                }
                else {
                    homeValue = 0.0;
                    System.out.println("nope");
                }
            }
        });
        loanAEdit = (EditText) findViewById(R.id.LoanAmounteditText);
        loanAEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence d, int a, int b, int c) {

            }
            public void onTextChanged(CharSequence d, int a, int b, int c) {

            }

            public void afterTextChanged(Editable e) {
                if (e.length() > 0) {
                    loanAmount = Double.valueOf(e.toString());
                }
                else {
                    loanAmount = 0.0;
                }
            }
        });
        interREdit = (EditText) findViewById(R.id.InterRateeditText);
        interREdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence d, int a, int b, int c) {

            }
            public void onTextChanged(CharSequence d, int a, int b, int c) {

            }

            public void afterTextChanged(Editable e) {
                if (e.length() > 0) {
                    interestRate = Double.valueOf(e.toString());
                }
                else {
                    interestRate = 0.0;
                }
            }
        });
        loanTEdit = (EditText) findViewById(R.id.LoanTermeditText);
        loanTEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence d, int a, int b, int c) {

            }
            public void onTextChanged(CharSequence d, int a, int b, int c) {

            }

            public void afterTextChanged(Editable e) {
                if (e.length() > 0) {
                    loanTerm = Integer.valueOf(e.toString());
                }
                else {
                    loanTerm = 0;
                }
            }
        });
        startDEdit = (EditText) findViewById(R.id.StartDateeditText);
        startDEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence d, int a, int b, int c) {

            }
            public void onTextChanged(CharSequence d, int a, int b, int c) {

            }

            public void afterTextChanged(Editable e) {
                if (e.length() > 0) {
                    startDate = Integer.valueOf(e.toString());
                }
                else {
                    startDate = 0;
                }
            }
        });
        propertyTEdit = (EditText) findViewById(R.id.PropertyTaxeditText);
        propertyTEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence d, int a, int b, int c) {

            }
            public void onTextChanged(CharSequence d, int a, int b, int c) {

            }

            public void afterTextChanged(Editable e) {
                if (e.length() > 0) {
                    propertyTax = Double.valueOf(e.toString());
                }
                else {
                    propertyTax = 0.0;
                }
            }
        });
        pMIEdit = (EditText) findViewById(R.id.PMIeditText);
        pMIEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence d, int a, int b, int c) {

            }
            public void onTextChanged(CharSequence d, int a, int b, int c) {

            }

            public void afterTextChanged(Editable e) {
                if (e.length() > 0) {
                    pmi = Double.valueOf(e.toString());
                }
                else {
                    pmi = 0.0;
                }
            }
        });
        homeIEdit = (EditText) findViewById(R.id.HomeInsuranceeditText);
        homeIEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence d, int a, int b, int c) {

            }
            public void onTextChanged(CharSequence d, int a, int b, int c) {

            }

            public void afterTextChanged(Editable e) {
                if (e.length() > 0) {
                    homeInsurance = Double.valueOf(e.toString());
                }
                else {
                    homeInsurance = 0.0;
                }
            }
        });
        monthlyHOEdit = (EditText) findViewById(R.id.MonthlyHOAeditText);
        monthlyHOEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence d, int a, int b, int c) {

            }
            public void onTextChanged(CharSequence d, int a, int b, int c) {

            }

            public void afterTextChanged(Editable e) {
                if (e.length() > 0) {
                    monthlyHOA = Double.valueOf(e.toString());
                }
                else {
                    monthlyHOA = 0.0;
                }
            }
        });

        goCalculate = (Button) findViewById(R.id.calculateButton);
        goSummary = (Button) findViewById(R.id.paymentButton);


        goCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculate = new Intent(MainActivity.this, CalculateSummary.class);

                calculate.putExtra("homeV", homeValue);
                calculate.putExtra("loanA", loanAmount);
                calculate.putExtra("interR", interestRate);
                calculate.putExtra("loanT", loanTerm);
                calculate.putExtra("startD", startDate);
                calculate.putExtra("propT", propertyTax);
                calculate.putExtra("pmi", pmi);
                calculate.putExtra("homeI", homeInsurance);
                calculate.putExtra("monthHOA", monthlyHOA);

                MainActivity.this.startActivity(calculate);
            }

        });

        goSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent summary = new Intent(MainActivity.this, PaymentSummary.class);

                summary.putExtra("homeV", homeValue);
                summary.putExtra("loanA", loanAmount);
                summary.putExtra("interR", interestRate);
                summary.putExtra("loanT", loanTerm);
                summary.putExtra("startD", startDate);
                summary.putExtra("propT", propertyTax);
                summary.putExtra("pmi", pmi);
                summary.putExtra("homeI", homeInsurance);
                summary.putExtra("monthHOA", monthlyHOA);

                MainActivity.this.startActivity(summary);
            }
        });
    }
    protected void onSaveInstanceState (Bundle outState)
        {
            super.onSaveInstanceState(outState);

            outState.putDouble("hv", homeValue);
            outState.putDouble("la", loanAmount);
            outState.putDouble("ir", interestRate);
            outState.putInt("lt", loanTerm);
            outState.putInt("sd", startDate);
            outState.putDouble("pt", propertyTax);
            outState.putDouble("pmi", pmi);
            outState.putDouble("hi", homeInsurance);
            outState.putDouble("mhoa", monthlyHOA);

        }

        protected void onRestoreInstanceState(Bundle savedInstanceState)
        {
            super.onRestoreInstanceState(savedInstanceState);

            homeValue = savedInstanceState.getDouble("hv", homeValue);
            loanAmount = savedInstanceState.getDouble("la", loanAmount);
            interestRate = savedInstanceState.getDouble("ir", interestRate);
            loanTerm = savedInstanceState.getInt("lt", loanTerm);
            startDate = savedInstanceState.getInt("sd", startDate);
            propertyTax = savedInstanceState.getDouble("pt", propertyTax);
            pmi = savedInstanceState.getDouble("pmi", pmi);
            homeInsurance = savedInstanceState.getDouble("hi", homeInsurance);
            monthlyHOA = savedInstanceState.getDouble("mhoa", monthlyHOA);

            homeVEdit.setText(Double.toString(homeValue));
            loanAEdit.setText(Double.toString(loanAmount));
            interREdit.setText(Double.toString(interestRate));
            loanTEdit.setText(Integer.toString(loanTerm));
            startDEdit.setText(Integer.toString(startDate));
            propertyTEdit.setText(Double.toString(propertyTax));
            pMIEdit.setText(Double.toString(pmi));
            homeIEdit.setText(Double.toString(homeInsurance));
            monthlyHOEdit.setText(Double.toString(monthlyHOA));

        }

}
