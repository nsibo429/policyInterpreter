package com.example.policyinterpreter;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    TextView resultsView;
    TextView resultsDView;
    TextView textView8;
    TextView textView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle bundle = getIntent().getExtras();
        String results = bundle.getString("results");
        String resultsD = bundle.getString("resultsD");
        String collectText = "Companies collect personal data for a number of reasons: some companies use your personal data to send personal advertisements, better personalize the products and services you use, or better improve machine learning - but did you know that your data can be sold to other companies or hedge funds?";
        String discloseText = "The personal information that you give to a company. This can include things like your phone number, credit card information, or email address, but may also include information like social media posts, health history, location data, and search-engine queries.";
        resultsView = findViewById(R.id.resultsView);
        resultsDView = findViewById(R.id.resultsDView);
        textView8 = findViewById(R.id.textView8);
        textView10 = findViewById(R.id.textView10);
        resultsView.setMovementMethod(new ScrollingMovementMethod());
        resultsDView.setMovementMethod(new ScrollingMovementMethod());

        resultsView.setText(results);
        resultsDView.setText(resultsD);
        textView8.setText(collectText);
        textView10.setText(discloseText);


    }
}
