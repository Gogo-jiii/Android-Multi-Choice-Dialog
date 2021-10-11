package com.example.multichoicedialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnShowMultiChoiceDialog;
    String[] data = {"a", "b", "c"};
    boolean[] selectedData = new boolean[]{false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowMultiChoiceDialog = findViewById(R.id.btnShowMultiChoiceDialog);
        btnShowMultiChoiceDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiChoiceDialog alertDialog = new MultiChoiceDialog(MainActivity.this, data, selectedData);
                alertDialog.show(getSupportFragmentManager(), "multi choice dialog");
                alertDialog.setCancelable(false);
            }
        });
    }
}