package com.example.user.firebase_firebase;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        firebaseAuth=FirebaseAuth.getInstance();

         progressDialog=new ProgressDialog(this);

        buttonRegister=findViewById(R.id.buttonRegister);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);
        textViewSignup=findViewById(R.id.textviewSigning);




        buttonRegister.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);









    }


    private void registerUser(){

        String email =editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){

            Toast.makeText(this,"please enter your email..",Toast.LENGTH_LONG).show();
            return;


        }
        if(TextUtils.isEmpty(password)){


            Toast.makeText(this,"please enter your password..",Toast.LENGTH_LONG).show();
            return;



        }




        progressDialog.setMessage("Registering user....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    Toast.makeText(MainActivity.this,"registered successfull",Toast.LENGTH_LONG).show();
                }else{

                    Toast.makeText(MainActivity.this,"could not register please try again......",Toast.LENGTH_LONG).show();


                }




            }
        });




    }







    @Override
    public void onClick(View v) {

        if(v==buttonRegister){

            registerUser();

        }
        if(v==textViewSignup){



        }






    }
}
