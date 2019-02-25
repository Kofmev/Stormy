package nl.chefkev.stormy.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import nl.chefkev.stormy.R;

/**
 * Created by Kevin Verbeek on 25-02-2019
 * Software development praktijk 1
 */

//Hier wordt een alert dialog gemaakt, die getoond kan worden in de MainActivity
public class AlertDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(R.string.error_title)
                .setMessage(R.string.error_message)
                .setPositiveButton(R.string.error_button_ok, null);

        return builder.create();
    }
}
