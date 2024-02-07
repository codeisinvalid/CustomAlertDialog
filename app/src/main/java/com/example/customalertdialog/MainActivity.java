package com.example.customalertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.ButtonSuccess).setOnClickListener(v -> showSuccessDialog());

        findViewById(R.id.ButtonWarning).setOnClickListener(v -> showWarningDialog());


        findViewById(R.id.ButtonError).setOnClickListener(v -> showErrorDialog());


        findViewById(R.id.ButtonNew).setOnClickListener(v -> showImageDialog());
    }

    private void showImageDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.new_alert_dialog,
                (ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);


        AlertDialog alertDialog = builder.create();
        view.findViewById(R.id.deleteButton).setOnClickListener(v -> alertDialog.dismiss());
        view.findViewById(R.id.cancelButton).setOnClickListener(v -> alertDialog.dismiss());

        if (alertDialog.getWindow()!= null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.layout_success_dialog,
                (ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.success_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.dummy_text));
        ((Button) view.findViewById(R.id.actionButton)).setText(getResources().getString(R.string.okay));
        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_success);

        AlertDialog alertDialog = builder.create();
        view.findViewById(R.id.actionButton).setOnClickListener(v -> alertDialog.dismiss());


        if (alertDialog.getWindow()!= null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();

    }
    private void showWarningDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);

        View view = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.layout_warning_dialog,
                (ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );

        builder.setView(view);

        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.warning_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.dummy_text));
        ((Button) view.findViewById(R.id.buttonYes)).setText(getResources().getString(R.string.yes));
        ((Button) view.findViewById(R.id.buttonNo)).setText(getResources().getString(R.string.no));
        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_warning);

        AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonYes).setOnClickListener(v -> alertDialog.dismiss());

        view.findViewById(R.id.buttonNo).setOnClickListener(v -> alertDialog.dismiss());

        if (alertDialog.getWindow()!= null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        alertDialog.show();

    }
    private void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.layout_error_dialog,
                (ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.error_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.dummy_text));
        ((Button) view.findViewById(R.id.actionButton)).setText(getResources().getString(R.string.error));
        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_error);

        AlertDialog alertDialog = builder.create();
        view.findViewById(R.id.actionButton).setOnClickListener(v -> alertDialog.dismiss());

        if (alertDialog.getWindow()!= null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }
}