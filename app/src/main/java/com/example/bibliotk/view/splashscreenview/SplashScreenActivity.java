package com.example.bibliotk.view.splashscreenview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.bibliotk.R;
import com.example.bibliotk.databinding.ActivitySplashScreenBinding;
import com.example.bibliotk.utils.Utils;
import com.example.bibliotk.view.loginscreenview.LoginScreenActivity;


public class SplashScreenActivity extends AppCompatActivity {

private ActivitySplashScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Glide
                .with(this)
                .load(R.drawable.gif_libro)
                .centerInside()
                .into(binding.ivSplashScreen);
        cambiarPantalla();
        }

    private void cambiarPantalla() {
        new Handler().postDelayed(()->{
            Intent intent=new Intent(SplashScreenActivity.this,
                    LoginScreenActivity.class);
            startActivity(intent);
            finish();
        },new Utils().getDuracionSplashScreen());
    }
}