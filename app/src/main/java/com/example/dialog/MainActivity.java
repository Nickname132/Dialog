package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnFon;
    ConstraintLayout constraintLayout;
    Context Context;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //связываем переменные с компонентами
        btnFon = (Button)findViewById(R.id.background_button);
        constraintLayout = (ConstraintLayout)findViewById(R.id.relativelayout);
        Context = MainActivity.this;

        btnFon.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        final CharSequence [] items = {getText(R.string.red),getText(R.string.yellow),getText(R.string.green)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.message);

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0:
                        constraintLayout.setBackgroundResource(R.color.redColor);
                        Toast.makeText(Context, R.string.red, Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        constraintLayout.setBackgroundResource(R.color.yellowColor);
                        Toast.makeText(Context, R.string.yellow, Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        constraintLayout.setBackgroundResource(R.color.greenColor);
                        Toast.makeText(Context, R.string.green, Toast.LENGTH_LONG).show();
                        break;
                }


            }
        })
        ;
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
