package com.aptron.cordinator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class HomeworkActivity extends AppCompatActivity {
    Spinner catagory_spinner,class_spinner,section_spinner,usercatagory_spinner;
    EditText text;
    Button submit;
    ImageButton attach_btn,camara_btn,video_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);
        catagory_spinner = findViewById(R.id.catagary_spinn);
        class_spinner = findViewById(R.id.class_spinn);
        section_spinner = findViewById(R.id.section_spinn);
        usercatagory_spinner = findViewById(R.id.userCatagory_spinn);

        text = findViewById(R.id.editTextHmwrk);
        submit = findViewById(R.id.submit_button);
        attach_btn= findViewById(R.id.attach_button);
        camara_btn = findViewById(R.id.cam_button);
        video_btn = findViewById(R.id.video_button);

        catagory_spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.notice_category)));
        class_spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.select_class)));
        section_spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.section)));
        usercatagory_spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.user_catagory)));

        attach_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int reqCode = 1;
                Intent action = new Intent(Intent.ACTION_GET_CONTENT);
                action = action.setType("*/*").addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(action, reqCode);
            }
        });

        camara_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, 0);
            }
        });

        video_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, 0);
            }
        });

    }
}
