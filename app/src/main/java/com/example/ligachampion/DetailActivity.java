package com.example.ligachampion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import static java.security.AccessController.getContext;

public class DetailActivity extends AppCompatActivity {

    private ImageView imgPhoto;
    private TextView tv_name;
    private TextView tv_detail;
    private TextView tv_link;

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DETAIL = "extra_detail";
    public static final String EXTRA_LOGO = "extra_logo";
    public static final String EXTRA_LINK = "extra_link";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle intent = getIntent().getExtras();

        String name = intent.getString(EXTRA_NAME);
        String detail = intent.getString(EXTRA_DETAIL);
        String logo = intent.getString(EXTRA_LOGO);
        String link = intent.getString(EXTRA_LINK);

        if (getSupportActionBar() !=null){
            getSupportActionBar().setTitle(name);
        }

        imgPhoto = findViewById(R.id.detail_photo);
        tv_name = findViewById(R.id.detail_name);
        tv_detail = findViewById(R.id.detail_detail);
        tv_link = findViewById(R.id.detai_link);

        Glide.with(this)
                .load(logo)
                .apply(new RequestOptions().override(  550,  550))
                .into(imgPhoto);

        tv_name.setText(name);
        tv_detail.setText(detail);
        tv_link.setText(link);

        tv_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "Buka link video youtube"+ link,Toast.LENGTH_SHORT).show();
                String url = link;
                Intent link = new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse(url));
                startActivity(link);
            }
        });

    }

}