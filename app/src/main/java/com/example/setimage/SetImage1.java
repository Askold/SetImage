package com.example.setimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class SetImage1 extends AppCompatActivity {

    String url = "https://www.meme-arsenal.com/memes/8d0bb7c5dc3acc3a92eb9a206027edfb.jpg";
    URL ImgURL = new URL(url);

    public SetImage1() throws MalformedURLException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ImageView DownloadImage = new ImageView(this);
        setContentView(DownloadImage);
        Thread thread = new Thread()  {
            @Override
            public void run() {
                try {
                    final Bitmap result = BitmapFactory.decodeStream((InputStream) ImgURL.getContent());
                    DownloadImage.post(new Runnable() {
                        @Override
                        public void run() {
                            DownloadImage.setImageBitmap(result);
                        }
                    });
                } catch (Exception e) { e.printStackTrace(); }
            };
        };
        thread.start();


/*
        try {
            image.setImageBitmap(BitmapFactory.decodeStream((InputStream) ImgURL.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

    }
}