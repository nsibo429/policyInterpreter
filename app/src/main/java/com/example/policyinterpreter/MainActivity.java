package com.example.policyinterpreter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button analyzeButton;
    String results;
    String resultsD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        analyzeButton = (Button) findViewById(R.id.analyze_button);
        textView = findViewById(R.id.titleAnalyze);

        analyzeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    ReadTextFile(v);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //going to another activity
                Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                intent.putExtra("results", results);
                intent.putExtra("resultsD", resultsD);
                startActivity(intent);
                finish();
            }
        });
    }

    public void ReadTextFile(View view) throws IOException {
        String string = "";
        StringBuilder stringBuilder = new StringBuilder();
        InputStream is = this.getResources().openRawResource(R.raw.sample);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        while (true) {
            try {
                if ((string = reader.readLine()) == null) break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(string).append("\n");
            //textView.setText(stringBuilder);
        }
        is.close();
        results = MatchPolicy(stringBuilder.toString());
        resultsD = DisclosureMatchPolicy(stringBuilder.toString());
        //Toast.makeText(getBaseContext(), results,
          //      Toast.LENGTH_LONG).show();
    }

    public String MatchPolicy(String policyData){
        Pattern pattern = Pattern.compile("[^\\.]* collect [^\\.]*.");
        Matcher matcher = pattern.matcher(policyData);
        if (matcher.find())
        {
            Log.d("pattern",matcher.group());
        }

        return matcher.group();
    }

    public String DisclosureMatchPolicy(String policyData){
        Pattern pattern = Pattern.compile("[^\\.]* disclose [^\\.]*.");
        Matcher matcher = pattern.matcher(policyData);
        if (matcher.find())
        {
            Log.d("pattern",matcher.group());
        }

        return matcher.group();
    }
}
