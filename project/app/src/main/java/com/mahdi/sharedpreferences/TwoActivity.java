package com.mahdi.sharedpreferences;


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.mahdi.sharedpreferences.databinding.ActivityTwoBinding;
import com.mahdi.sharedpreferences.model.ModelTwo;
import com.mahdi.sharedpreferences.viewmodel.Clicks;
import com.mahdi.sharedpreferences.viewmodel.Viewmodel2;



public class TwoActivity extends AppCompatActivity {

    private ActivityTwoBinding binding;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two);
        RelativeLayout relativeLayout = findViewById(R.id.Rel1);


        preferences = getSharedPreferences("share1", MODE_PRIVATE);
        String title = preferences.getString("q1", "0");
        int color = preferences.getInt("q3", 0);
        relativeLayout.setBackgroundColor(color);


        binding.setTwo(new Viewmodel2(new ModelTwo(title)));


        binding.setTwoClick(new Clicks() {
            @Override
            public void ClickOne(View view) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();

                startActivity(new Intent(TwoActivity.this, MainActivity.class));
                finish();
            }
        });


    }
}