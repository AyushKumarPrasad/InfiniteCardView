package com.example.ayushkumar.infinitecardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.bakerj.infinitecards.InfiniteCardView;
import com.bakerj.infinitecards.transformer.DefaultTransformerToBack;
import com.bakerj.infinitecards.transformer.DefaultTransformerToFront;
import com.bakerj.infinitecards.transformer.DefaultZIndexTransformerCommon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    Button btnPre, btnNext ;
    InfiniteCardView infiniteCardView;
    CardAdapter cardAdapter;
    List<Integer> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPre = (Button) findViewById(R.id.pre);
        btnNext= (Button) findViewById(R.id.next);

        infiniteCardView = (InfiniteCardView) findViewById(R.id.view);

        images.add(R.drawable.one);
        images.add(R.drawable.two);

        images.add(R.drawable.three);

        images.add(R.drawable.four);

        images.add(R.drawable.five);

        cardAdapter = new CardAdapter(this, images);
        infiniteCardView.setClickable(true);

        infiniteCardView.setAnimType(InfiniteCardView.ANIM_TYPE_FRONT);
        infiniteCardView.setAnimInterpolator(new LinearInterpolator());

        infiniteCardView.setTransformerToFront(new DefaultTransformerToFront());
        infiniteCardView.setTransformerToBack(new DefaultTransformerToBack());

        infiniteCardView.setZIndexTransformerToBack(new DefaultZIndexTransformerCommon());
        infiniteCardView.setAdapter(cardAdapter);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                infiniteCardView.bringCardToFront(1);
            }
        });

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                infiniteCardView.bringCardToFront(cardAdapter.getCount()-1);
            }
        });


    }
}
