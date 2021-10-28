package com.example.android.labwork_2_1_10;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MyDialog extends Dialog {

    interface TextViewListener {
        void nameEntered(String name);
    }

    public Context context;
    private MyDialog.TextViewListener listener;
    private EditText userName;

    public MyDialog(Context context, MyDialog.TextViewListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_dialog_layout);
        this.userName = findViewById(R.id.username);
        Button buttonOk = findViewById(R.id.buttonOk);
        Button buttonNo = findViewById(R.id.buttonNo);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonOkClick();
            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonNoClick();
            }
        });

    }

    private void buttonOkClick() {
        String name = this.userName.getText().toString();

        this.dismiss();
        if (this.listener != null) {
            this.listener.nameEntered(name);
        }
    }

    private void buttonNoClick() {
        this.dismiss();
    }
}
