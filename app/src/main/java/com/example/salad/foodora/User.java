package com.example.salad.foodora;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.util.UUID;

/**
 * Created by salad on 2/5/16.
 */
public class User {

    public String mTitle;
    public String mDesc;
    public String mDate;
    public boolean mIsParking;
    public boolean mIsFood;
    public Drawable mIcon;
    public UUID mId;

    User()
    {

    }
    User(String title, String desc, String date, boolean isFood, boolean isParking)
    {
        mTitle = title;
        mDesc = desc;
        mDate = date;
        mId = UUID.randomUUID();
        mIsFood = isFood;
        mIsParking = isParking;
       // this.mIcon = mIcon;
    }

    public String getTitle()
    {
        return  mTitle;
    }

    public String getDesc()
    {
        return mDesc;
    }

    public String getDate()
    {
        return mDate;
    }

    public boolean isFood()
    {
        return mIsFood;
    }

    public Drawable getImage(){return mIcon;}
    public boolean isParking()
    {
        return mIsParking;
    }
    public void setTitle(String title)
    {
        mTitle = title;
    }

    public void setDesc(String desc)
    {
        mDesc = desc;
    }

    public void setDate(String date)
    {
        mDate = date;
    }

    public void setIsParking(boolean i)
    {
        mIsParking = i;
    }

    public void setIsFood(boolean f)
    {
        mIsFood = f;
    }

    public void setIcon(Drawable d)
    {
        this.mIcon = d;
    }
}
