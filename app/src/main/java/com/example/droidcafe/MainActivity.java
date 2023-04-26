package com.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.droidcafe.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String mOrderMessage;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    public static final String EXTRA_MESSAGE = "com.example.android.droidcafe.EXTRA_MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        appBarConfiguration = new AppBarConfiguration.Builder().build();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_order ) {
            Intent intent = new Intent(MainActivity.this, OrderActivity.class);
            intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.action_status ) {
            displayToast(getString(R.string.action_order_message));
            return true;
        } else if (item.getItemId() == R.id.action_favorites ) {
            displayToast(getString(R.string.action_favorites_message));
            return true;
        } else if (item.getItemId() == R.id.action_contact ) {
            displayToast(getString(R.string.action_contact_message));
            return true;
        }

        return super.onOptionsItemSelected(item);
        /*
        switch (item.getItemId()) {
            case R.id.action_order:
                displayToast(getString(R.string.action_order_message));
                return true;
            case R.id.action_status:
                displayToast(getString(R.string.action_order_message));
                return true;
            case R.id.action_favorites:
                displayToast(getString(R.string.action_favorites_message));
                return true;
            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                return true;
            default:
                // Do nothing
        }
         */
    }

    /**
     * Show a toast with the string that receive as parameter
     *
     * @param message
     */
    public void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showDonutOrder(View view) {

        mOrderMessage =  getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
        displayToast(getString(R.string.donut_order_message));
    }

    public void showIceCreamOrder(View view) {
        mOrderMessage =  getString(R.string.ice_cream_order_message);
        displayToast(mOrderMessage);
        displayToast(getString(R.string.ice_cream_order_message));
    }

    public void showFroyoOrder(View view) {
        mOrderMessage =  getString(R.string.froyo_order_message);
        displayToast(mOrderMessage);
        displayToast(getString(R.string.froyo_order_message));
    }


}