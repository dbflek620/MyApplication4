package com.example.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.com.myapplication.R.drawable.*;

public class MainActivity extends AppCompatActivity {

    TextView textView,textView2;
    Switch switch1;
    RadioGroup rgroup1;
    RadioButton radioButton,radioButton2,radioButton3;
    Button button,button2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("안드로이드 사진보기");

        textView = (TextView) findViewById(R.id.textView);
        switch1 = (Switch) findViewById(R.id.switch1);

        textView2 = (TextView) findViewById(R.id.textView2);
        rgroup1 = (RadioGroup) findViewById(R.id.rgroup1);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        imageView = (ImageView) findViewById(R.id.imageView);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //On
                    textView2.setVisibility(View.VISIBLE);
                    rgroup1.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                    rgroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            switch (rgroup1.getCheckedRadioButtonId()) {
                                case R.id.radioButton:
                                    imageView.setImageResource(R.drawable.jellybeen);break;
                                case R.id.radioButton2:
                                    imageView.setImageResource(R.drawable.kitkat);break;
                                case R.id.radioButton3:
                                    imageView.setImageResource(R.drawable.lollipop);
                            }
                        }
                    });
                } else {
                    //Off
                    textView2.setVisibility(View.INVISIBLE);
                    rgroup1.setVisibility(View.INVISIBLE);
                    button.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);

                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
