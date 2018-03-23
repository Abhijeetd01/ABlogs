package io.hasura.ablogs;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// created By Abhijeet Das on 21.03.2018 on Intellij IDEA............................................

public class AuthenticationActivity extends AppCompatActivity {

     EditText username,password;
   //  ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);

        Button signInButton=(Button)findViewById(R.id.signInButton);
          signInButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  if(isFormValid()){
                      performSignin();
                      // perform signIn operation...................
                  } }
          });
        Button registerButton=(Button) findViewById(R.id.registerButton);
         registerButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
         //        if(isFormValid()){
                 performRegistration();
                     // perform registration operation...................

             }
         });
    }
    private Boolean isFormValid() {
        if(username.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Username cannot be empty",Toast.LENGTH_LONG).show();
            return false; }

        if (password.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Password cannot be empty",Toast.LENGTH_LONG).show();
            return false;
        }
   return true;
    }
    private void performSignin(){
        new SignInTask().execute(username.getText().toString(),password.getText().toString());

        //mock signIn API call
    }
    private void performRegistration(){


        //mock registration API call
    }
    private void showProgressDialog(Boolean shouldShould){

    }
    private void showAlert(String title,String message){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
         builder.setTitle(title);
         builder.setMessage(message);
         builder.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 dialog.dismiss();
             }
         });
                               builder.show();
    }
    class SignInTask extends AsyncTask<String,Void ,Boolean>{
        // setting mock username and password values for the application
           String mockUsername ="test";
           String mockPassword ="password";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
              if(aBoolean)
              {
                      showAlert("Welcome","You have successfully logged in ");
              }
                 else
              {
                      showAlert("Failed","Username/Password is incorrect");
              }
        }

        @Override
        protected Boolean doInBackground(String... strings) {
              String username=strings[0];
              String password=strings[1];

  // do something with this and
              return username.contentEquals(mockUsername)&& username.contentEquals(mockPassword);
        }
    }
}
