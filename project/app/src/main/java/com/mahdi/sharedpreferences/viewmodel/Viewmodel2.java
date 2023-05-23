package com.mahdi.sharedpreferences.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.mahdi.sharedpreferences.BR;
import com.mahdi.sharedpreferences.model.ModelMain;
import com.mahdi.sharedpreferences.model.ModelTwo;

public class Viewmodel2 extends BaseObservable {

    private String title;

    public Viewmodel2(ModelTwo modelTwo) {
        this.title = modelTwo.title;
    }


    @Bindable
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }


}
