package com.example.shiibataichi.mytoratora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    final int TORATORA_BBA = 1;
    final int TORATORA_KATOU = 2;
    final int TORATORA_TIGER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int myToratora = 0;
        Intent intent = getIntent();
        int id = intent.getIntExtra("MY_TORATORA",0);

        ImageView myToratoraImageView = (ImageView) findViewById(R.id.my_toratora_image);
        switch(id){
            case R.id.bba:
                myToratoraImageView.setImageResource(R.drawable.bba);
                myToratora = TORATORA_BBA;
                break;
            case R.id.katou:
                myToratoraImageView.setImageResource(R.drawable.katou);
                myToratora = TORATORA_KATOU;
                break;
            case R.id.tiger:
                myToratoraImageView.setImageResource(R.drawable.tora);
                myToratora = TORATORA_TIGER;
                break;
            default:
                myToratora = TORATORA_BBA;
                break;
        }

        int comToratora = (int)(Math.random() * 3);
        ImageView comToratoraImageView = (ImageView)findViewById(R.id.com_toratora_image);
        switch(comToratora){
            case TORATORA_BBA:
                comToratoraImageView.setImageResource(R.drawable.bba);
                break;
            case TORATORA_KATOU:
                comToratoraImageView.setImageResource(R.drawable.katou);
                break;
            case TORATORA_TIGER:
                comToratoraImageView.setImageResource(R.drawable.tora);
                break;
        }

        TextView resultLabel = (TextView) findViewById(R.id.result_label);
        int gameResult = (comToratora - myToratora + 3) % 3;
        switch(gameResult){
            case 0:
                resultLabel.setText(R.string.result_draw);
                break;
            case 1:
                resultLabel.setText(R.string.result_win);
                break;
            case 2:
                resultLabel.setText(R.string.result_lose);
                break;
        }
    }

    public void onBackButtonTapped(View view){
        finish();
    }
}
