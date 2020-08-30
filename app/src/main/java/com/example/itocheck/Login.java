package com.example.itocheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itocheck.databinding.ActivityLoginBinding;
import com.google.android.material.snackbar.Snackbar;

public class Login extends AppCompatActivity {
    private ActivityLoginBinding mBinding;
    private int count=0;
    private String msj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               checkPass(mBinding.etPass.getText().toString());

                if (count>3) {
                    mBinding.btLogin.setVisibility(View.INVISIBLE);
                    msj="Tu cuenta ha sido Bloqueada";
                }

                Snackbar snackbar = Snackbar.make(view, msj, Snackbar.LENGTH_LONG);
                snackbar.setAction("Action", null);
                    View snackbarView = snackbar.getView();
                    snackbar.setTextColor(getColor(R.color.colorPrimaryDark));
                    snackbarView.setBackgroundColor(getColor(R.color.colorAccent));
                    snackbar.show();

            }
        });

        mBinding.btCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });

    }

 public void checkPass (String pass){
       if (pass.equals("123Pass") && count <4 ) next();
       count++;
       msj = "Llevas "+count+" Intentos. Con más de 3 tu cuenta será Bloqueada";
 }

 public void next(){
             Intent intent = new Intent(Login.this, MainActivity.class);
                count=0;
             startActivity(intent);
         }
}