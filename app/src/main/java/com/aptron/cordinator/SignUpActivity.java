package com.aptron.cordinator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class SignUpActivity extends AppCompatActivity {
    EditText email_signup,pass_signup;
    RadioButton admin_signup,parent_signup,teacher_signup;
    Button button_signup;
    RadioGroup radioGroup;
    DbHelper dbHelper;
    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email_signup = findViewById(R.id.txtemail_signup);
        pass_signup = findViewById(R.id.txtpass_signup);

        admin_signup = findViewById(R.id.rd_btn_admin_signup);
        teacher_signup = findViewById(R.id.rd_btn_teacher_signup);
        parent_signup = findViewById(R.id.rd_btn_parent_signup);
    dbHelper = new DbHelper(this);
        button_signup = findViewById(R.id.btn_signup);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.txtemail_signup, Patterns.EMAIL_ADDRESS, R.string.email_error);
      //  awesomeValidation.addValidation(this, R.id.rbgroup_singup, "", R.string.emailerror);

        awesomeValidation.addValidation(this, R.id.txtpass_signup, PASSWORD_PATTERN, R.string.pass_error);


        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = email_signup.getText().toString();
                String pass = pass_signup.getText().toString();
                String type = null;
                if(admin_signup.isChecked())
                type = "admin";
                else if(parent_signup.isChecked())
                    type = "parent";
                else if(teacher_signup.isChecked())
                    type = "teacher";

                if (awesomeValidation.validate()) {

                   long id = dbHelper.insertData(email,pass,type);

                   if(id>0) {

                Toast.makeText(SignUpActivity.this, "Validation Successfull", Toast.LENGTH_LONG).show();


                   }


                }
            }
        });
    }
}
