package com.example.policyinterpreter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    TextView resultsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Bundle bundle = getIntent().getExtras();
        String results = bundle.getString("results");
        resultsView = findViewById(R.id.resultsView);
        resultsView.setText(results);

    }
}
