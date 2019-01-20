package com.aptron.cordinator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class LoginActivity extends AppCompatActivity {
    EditText email_login,pass_login;
    RadioButton admin_button,parent_button,teacher_button;
    Button login_button;
    TextView singup_page;
    private AwesomeValidation awesomeValidation;
    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
    private static final String USER_TYPE  = "type";
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_login = findViewById(R.id.txtemail_login);
        pass_login = findViewById(R.id.txtpass_login);

        dbHelper = new DbHelper(this);
        admin_button = findViewById(R.id.rd_btn_admin_login);
        teacher_button = findViewById(R.id.rd_btn_teacher_login);
        parent_button = findViewById(R.id.rd_btn_parent_login);

        login_button = findViewById(R.id.btn_login);
        singup_page = findViewById(R.id.signup);
       awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.txtemail_login, Patterns.EMAIL_ADDRESS, R.string.email_error);
        //  awesomeValidation.addValidation(this, R.id.rbgroup_singup, "", R.string.emailerror);

        awesomeValidation.addValidation(this, R.id.txtpass_login, PASSWORD_PATTERN, R.string.pass_error);

          singup_page.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
              }
          });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = null;
                String email = email_login.getText().toString();
                String pass = pass_login.getText().toString();
                if (admin_button.isChecked())
                    type = "admin";
                else if (parent_button.isChecked())
                    type = "parent";
                else if (teacher_button.isChecked())
                    type = "teacher";

                if (awesomeValidation.validate()) {

                   boolean status = dbHelper.authUser(email, pass, type);
                    Intent intent;
                    if(status && type=="admin")
                    {
                        intent = new Intent(LoginActivity.this,DashBoard.class);
                        intent.putExtra(USER_TYPE,"admin");
                       startActivity(intent);

                    }
                    else if(status && type=="parent")
                    {
                        intent = new Intent(LoginActivity.this,DashBoard.class);
                        intent.putExtra(USER_TYPE,"parent");
                        startActivity(intent);

                    }
                    else  if(status && type=="teacher")
                    {
                        intent = new Intent(LoginActivity.this,DashBoard.class);
                        intent.putExtra(USER_TYPE,"teacher");
                        startActivity(intent);

                    }


                }
            }

        });

    }
}
