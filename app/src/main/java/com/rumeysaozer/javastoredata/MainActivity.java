package com.rumeysaozer.javastoredata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.rumeysaozer.javastoredata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        sharedPreferences = this.getSharedPreferences("com.rumeysaozer.javastoredata",
                Context.MODE_PRIVATE);
        String age = sharedPreferences.getString("age", "");
        if (age == "") {
            binding.textView.setText("");
        }else{
            binding.textView.setText(age);
        }
        save();
        delete();


    }
    public void save(){
        binding.button.setOnClickListener(v->{
            if(!binding.editTextNumber.getText().toString().matches("")){
                String age =binding.editTextNumber.getText().toString();
                binding.textView.setText(age);
                sharedPreferences.edit().putString("age",age).apply();
            }
        });
    }
    public void delete(){
       binding.button2.setOnClickListener(v->{
           String age = sharedPreferences.getString("age","");
           if(age != ""){
               sharedPreferences.edit().remove("age").apply();
               binding.textView.setText("");
           }
       });
    }




}