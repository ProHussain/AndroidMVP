package com.hashmac.androidmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hashmac.androidmvp.presenter.MainPresenter;
import com.hashmac.androidmvp.view.MainView;

/**
 * Created by HashMac on 5/17/2023.
 * Purpose: Try to understand the MVP pattern
 * Variables: presenter
 * Methods: onCreate, showProgress, hideProgress, setQuote, onClick
 * How it works:
 * 1. Create a MainPresenter object
 * 2. Implement the MainView interface
 * 3. Override the methods from the MainView interface
 * 4. Set the onClickListener for the buttons
 * 5. Call the methods from the MainPresenter object
 * 6. Call the methods from the MainView interface
 * 7. Run the app
 */

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {
    MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        findViewById(R.id.btn_show_quote).setOnClickListener(this);
        findViewById(R.id.btn_hide_quote).setOnClickListener(this);
        findViewById(R.id.btn_set_quote).setOnClickListener(this);
    }

    @Override
    public void setQuote(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        findViewById(R.id.btn_show_quote).setOnClickListener(view1 -> presenter.showProgress());
        findViewById(R.id.btn_hide_quote).setOnClickListener(view1 -> presenter.hideProgress());
        findViewById(R.id.btn_set_quote).setOnClickListener(view1 -> presenter.setQuote("Hello World!"));
    }
}