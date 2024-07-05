package com.example.myprject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button login;
    FirebaseAuth auth;

    String eml="abc@gmail.com";
    String pass="1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        email = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextText2);
        login = findViewById(R.id.button3);
//        signup = findViewById(R.id.button4);
        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                login(email.getText().toString(),password.getText().toString());

                String nm=String.valueOf(email.getText());
                String pa=String.valueOf(password.getText());

                if((eml.equals(nm) && (pass.equals(pa)))){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Toast.makeText(LoginActivity.this,"loging success", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginActivity.this,"loging failed", Toast.LENGTH_LONG).show();
                }
            }
        });

//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(i);
//            }
//        });

    }

//    public void login(String email,String password){
//        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                    Toast.makeText(LoginActivity.this,"loging success", Toast.LENGTH_LONG).show();
//                }else {
//                    Toast.makeText(LoginActivity.this,"loging failed", Toast.LENGTH_LONG).show();
//                }
//
//            }
//        });
//    }


//    public void login(View v){
//        String nm=String.valueOf(text1.getText());
//        String pass=String.valueOf(text2.getText());
//        if((name.equals(nm) && (password.equals(pass)))){
//            Intent i=new Intent(getApplicationContext(), Success.class);
//            startActivity(i);
//            Toast.makeText(MainActivity.this,"Login successful", Toast.LENGTH_LONG).show();
//        }else{
//            Intent i=new Intent(getApplicationContext(), Fail.class);
//            startActivity(i);
//            Toast.makeText(MainActivity.this,"Login failed", Toast.LENGTH_LONG).show();
//        }
//   }


}