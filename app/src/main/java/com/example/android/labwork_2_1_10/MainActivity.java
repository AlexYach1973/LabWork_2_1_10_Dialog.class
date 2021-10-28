package com.example.android.labwork_2_1_10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAlert, btnFragment;
    TextView textView, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        btnAlert = findViewById(R.id.buttonAlert);
        btnFragment = findViewById(R.id.buttonFragment);

        // Alert
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRatingDialog();
            }
        });

        // use extends Dialog
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void showRatingDialog() {
        final AlertDialog.Builder ratingDialog = new AlertDialog.Builder(this);

        final RatingBar rating = new RatingBar(this);
        // НЕ работает
//        rating.setMax(6);
//        rating.setNumStars(5);
//        rating.setStepSize((float) 1.0);

        ratingDialog.setIcon(android.R.drawable.btn_star_big_on);
        ratingDialog.setTitle("Голосуем!");
        ratingDialog.setView(rating);

        ratingDialog.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                textView2.setText(String.valueOf(rating.getProgress()));
                dialog.dismiss();
            }
        });

        ratingDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = ratingDialog.create();
        alertDialog.show();
    }

    // use extends Dialog
    private void openDialog() {
        MyDialog.TextViewListener listener = new MyDialog.TextViewListener() {
            @Override
            public void nameEntered(String name) {

                textView.setText(name);
            }
        };
        final MyDialog dialog = new MyDialog(this, listener);
        dialog.show();


    }

}