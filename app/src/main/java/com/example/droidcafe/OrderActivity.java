package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String message =  intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.oder_textview);
        textView.setText(message);
    }


    /**
     * Método que ejecuta un mensaje personalizado segun el producto clickeado
     * @param view
     */
    public void onRadioButtonClicked(View view) {
        //esta sleccionado un boton en este momento?
        boolean checked = ((RadioButton) view).isChecked();

        if (view.getId() == R.id.sameday && checked) {
            displayToast(getString(R.string.same_day_messenger_service));

        } else if (view.getId() == R.id.nextday && checked) {
            displayToast(getString(R.string.next_day_ground_delivery));

        } else if (view.getId() == R.id.pickup && checked) {
            displayToast(getString(R.string.pick_up));

        }

        /*
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)

                 //   displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if (checked)
                    //displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
               //     displayToast(getString(R.string.pick_up));
                break;
            default:
                //nada

                break;
        }

         */
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

}