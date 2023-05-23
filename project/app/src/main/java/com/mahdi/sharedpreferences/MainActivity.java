package com.mahdi.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.mahdi.sharedpreferences.databinding.ActivityMainBinding;
import com.mahdi.sharedpreferences.model.ModelMain;
import com.mahdi.sharedpreferences.viewmodel.Clicks;
import com.mahdi.sharedpreferences.viewmodel.Viewmodel1;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SharedPreferences sharedPreferences;
    private CheckBox checkBox;
    private Boolean aBoolean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        checkBox = findViewById(R.id.check1);
        sharedPreferences = getSharedPreferences("share1", MODE_PRIVATE);
        aBoolean = sharedPreferences.getBoolean("q2", false);


        Viewmodel1 viewmodel1 = new Viewmodel1(new ModelMain("SharedPreferences"));
        binding.setMain(viewmodel1);


        if (aBoolean) {
            startActivity(new Intent(MainActivity.this, TwoActivity.class));
            finish();
        }


        binding.setMainClick(new Clicks() {
            @Override
            public void ClickOne(View view) {

                String title = viewmodel1.getTitle();
                Boolean bool1 = checkBox.isChecked();
                int color = Color.parseColor("#A4E657");

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("q1", title);
                editor.putBoolean("q2", bool1);
                editor.putInt("q3", color);
                editor.apply();

                startActivity(new Intent(MainActivity.this, TwoActivity.class));
                finish();
            }
        });


    }
}