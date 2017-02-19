package com.hackingbuzz.loginemailpasswordvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

     EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        // initilize a button without a name..coz we using inner class..we dont need button anywhere..

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String emailAdd = email.getText().toString();
                if(!isValidEmail(emailAdd))   // not expression (!) in if..shows creates a boolean method..//
                email.setError("Invalid Email"); // we creating boolean method..coz we are required check between two condition
                // that email is valid or not....// we creating a method for this if..coz we have two task
                // 1. we gotta know if email is valid or not ( true or false result ) n we need to compare it with exression ( validatin condtion)
                // so..we creating a method..to do that ...more than one thing we need when we use if..we create method for that..


                final String psswd = password.getText().toString();
                if(!isPasswordValid(psswd))
                    password.setError("Invalid Password"); // password is editText see above..where we showing this error
            }
        });
    }

    private boolean isPasswordValid(String psswd) {

        if(psswd != null && psswd.length() > 6) {
            return true;
        }
        return false;

    }

    private boolean isValidEmail(String emailAdd) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(emailAdd);
        return matcher.matches();  // matches is a boolean method returning boolean value // returning this value make the condition true
        // so it will not show error
    }

}
