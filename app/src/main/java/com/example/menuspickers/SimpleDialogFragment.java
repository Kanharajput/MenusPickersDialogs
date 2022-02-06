package com.example.menuspickers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class SimpleDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstaceState) {
        ArrayList selectedItems = new ArrayList<Integer>();     // arrayList to store which items are checked

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_title);

        // making to choose multiple options
        builder.setMultiChoiceItems(R.array.color_list, null, new DialogInterface.OnMultiChoiceClickListener() {
            // after eveery click this method is called and if it's checked we add index of the item to arrayList(for further operations)
            // and if not checked we remove
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked) {
                    selectedItems.add(which);    // add the checked item index
                }

                else if(selectedItems.contains(which)) {     // if clicked but not checked mean user unchecked someItem so remove that
                    selectedItems.remove(which);
                }
            }
        });

        builder.setPositiveButton(R.string.ok_string, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),selectedItems.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton(R.string.cancel_string, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),R.string.cancel_string,Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
}
