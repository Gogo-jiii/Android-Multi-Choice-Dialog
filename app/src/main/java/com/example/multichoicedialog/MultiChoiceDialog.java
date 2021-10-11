package com.example.multichoicedialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MultiChoiceDialog extends DialogFragment {

    private AlertDialog.Builder builder;
    private Dialog dialog;
    private Context context;
    private String[] data;
    private boolean[] selectedData;

    public MultiChoiceDialog(Context context, String[] data, boolean[] selectedData) {
        super();
        this.context = context;
        this.data = data;
        this.selectedData = selectedData;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        builder = new AlertDialog.Builder(context);
        builder.setTitle("Multi Choice Alert Dialog");

        builder.setMultiChoiceItems(data, selectedData, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                selectedData[i] = b;
                String currentItem = data[i];
                Toast.makeText(context, "Current Item: " + currentItem, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int j) {
                dialogInterface.dismiss();
                for (int i = 0; i < data.length; i++) {
                    if (selectedData[i] == true) {
                        Toast.makeText(context, "Selected: " + data[i], Toast.LENGTH_SHORT).show();
                        selectedData[i] = false;
                    }
                }
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Toast.makeText(context, "Cancelled.", Toast.LENGTH_LONG).show();
            }
        });
        return builder.create();
    }
}
