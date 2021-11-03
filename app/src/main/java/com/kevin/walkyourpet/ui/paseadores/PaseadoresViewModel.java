package com.kevin.walkyourpet.ui.paseadores;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PaseadoresViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PaseadoresViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}