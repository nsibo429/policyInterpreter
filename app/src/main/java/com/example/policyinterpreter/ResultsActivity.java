package com.example.policyinterpreter;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    TextView resultsView;
    TextView resultsDView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Bundle bundle = getIntent().getExtras();
        String results = bundle.getString("results");
        String resultsD = bundle.getString("resultsD");
        resultsView = findViewById(R.id.resultsView);
        resultsDView = findViewById(R.id.resultsDView);
        resultsView.setMovementMethod(new ScrollingMovementMethod());
        resultsDView.setMovementMethod(new ScrollingMovementMethod());
        resultsView.setText(results);
        resultsDView.setText(resultsD);


    }
}
