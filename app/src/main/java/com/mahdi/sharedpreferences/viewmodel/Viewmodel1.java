package com.mahdi.sharedpreferences.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.mahdi.sharedpreferences.BR;
import com.mahdi.sharedpreferences.model.ModelMain;



public class Viewmodel1 extends BaseObservable {

    private String title;

    public Viewmodel1(ModelMain modelMain) {
        this.title = modelMain.title;
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
