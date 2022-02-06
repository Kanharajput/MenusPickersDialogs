package com.example.menuspickers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class SimpleDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstaceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_title);
        // setting a list from which only one item can be selected
        builder.setItems(R.array.color_list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == 0) {      // which is the index no. of the selected item in array
                    Toast.makeText(getActivity(),"yellow_clicked",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return builder.create();
    }
}
