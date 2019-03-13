package io.ameal.lesson04_localizationlandscape;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    private Button previous;
    private Button next;
    private ImageView imageView;
    private int[] images = new int[4];
    private int imageCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
        previous = findViewById(R.id.previousButton);
        previous.setText(R.string.previous);
        next = findViewById(R.id.nextButton);
        next.setText(R.string.next);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.img0);

        images[0] = R.drawable.img0;
        images[1] = R.drawable.img1;
        images[2] = R.drawable.img2;
        images[3] = R.drawable.img3;

        previous.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                goToPreviousImage();
            }
        });

        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                goToNextImage();
            }
        });
    }

    private void goToNextImage()
    {
        imageCounter++;
        imageCounter = imageCounter % images.length;
        imageView.setImageResource(images[imageCounter]);
    }

    private void goToPreviousImage()
    {
        imageCounter--;
        if(imageCounter < 0)
        {
            imageCounter = images.length -1;
        }
        imageView.setImageResource(images[imageCounter]);
    }
}
