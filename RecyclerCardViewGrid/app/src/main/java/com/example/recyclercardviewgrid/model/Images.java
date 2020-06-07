package com.example.recyclercardviewgrid.model;

import com.example.recyclercardviewgrid.R;

import java.util.ArrayList;
import java.util.List;

public class Images {
    private String title;
    private int imageId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public static List<Images> getData(){
        List<Images> data = new ArrayList<>();

        int[] images = {
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image10,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image6,
                R.drawable.image7,
                R.drawable.image8,
                R.drawable.image9,
                R.drawable.image11
        };
        for(int i = 0; i < images.length; i++){
            Images current = new Images();
            current.setTitle("image #" + i);
            current.setImageId(images[i]);
            data.add(current);
        }

        return data;
    }
}

