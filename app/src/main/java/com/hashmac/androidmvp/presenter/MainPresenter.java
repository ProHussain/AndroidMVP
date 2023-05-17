package com.hashmac.androidmvp.presenter;

import com.hashmac.androidmvp.model.Main;
import com.hashmac.androidmvp.view.MainView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HashMac on 5/17/2023.
 * Purpose: Try to understand the MVP pattern
 * Variables: view
 * Methods: showProgress, hideProgress, setQuote
 * How it works:
 * 1. Create a MainView object
 * 2. Create a constructor that takes a MainView object
 * 3. Implement the methods from the MainView interface
 * 4. Call the methods from the MainView object
 * 5. Run the app
 */

public class MainPresenter {

    MainView view;
    List<Main> mainList;
    public MainPresenter(MainView view) {
        this.view = view;
        mainList = new ArrayList<>();
    }

    public void showProgress() {
        view.setQuote(mainList.get(mainList.size()-1).getQuote());
    }

    public void hideProgress() {
        if (mainList.size() > 0) {
            mainList.remove(mainList.size()-1);
        }
    }

    public void setQuote(String string) {
        mainList.add(new Main(string+" "+mainList.size()));
    }
}
