package com.vladimirvozar.loveapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.vladimirvozar.loveapp.R;
import com.vladimirvozar.loveapp.databinding.ActivityMainBinding;
import com.vladimirvozar.loveapp.models.HeartData;

public class MainActivity extends AppCompatActivity {

    private HeartData heartData;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        heartData = new ViewModelProvider(this).get(HeartData.class);
        mainBinding.setMaindatabinder(heartData);
        mainBinding.setLifecycleOwner(this);

//        heartData.getTextVisible().observe(this, new Observer<Boolean>() {
//            @Override
//            public void onChanged(Boolean aBoolean) {
//                Toast.makeText(MainActivity.this, "Promenjen textVisible", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}