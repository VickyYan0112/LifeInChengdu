package com.yan.LifeinChengdu.Food;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yan.LifeinChengdu.R;

public class FoodActivity extends AppCompatActivity {

    private TextView addressText;
    private Button navigationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        addressText = (TextView) findViewById(R.id.id_address);
        navigationButton = (Button) findViewById(R.id.id_navigation);
        navigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = "address=" + addressText.getText().toString();
                /**调用百度地图Web页面
                 * address=LocaltionAddress&src=YourAppName
                 */
                String uristr = "http://api.map.baidu.com/geocoder?" + address
                        + "&output=html&src=yhc";
                Uri uri = Uri.parse(uristr);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }


        });
    }

    public void onClick8(View view){
        Intent intent = new Intent();
        intent.setClass(FoodActivity.this,HotPotActivity.class);
        startActivity(intent);
    }




}
