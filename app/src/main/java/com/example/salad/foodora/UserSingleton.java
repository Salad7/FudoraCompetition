package com.example.salad.foodora;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by salad on 2/5/16.
 */
public class UserSingleton {
    private static UserSingleton sUserSingleton;
    private List<User> mUsers;


    public static UserSingleton get(Context ctx)
    {
        if(sUserSingleton == null)
        {
            sUserSingleton = new UserSingleton(ctx);
        }
        return sUserSingleton;
    }

    private UserSingleton (Context ctx)
    {
        mUsers = new ArrayList<User>();
        String[] randomDates = {"2/9 - 4:30PM WW Hall","2/13 - 2:30PM WW Hall","2/12 - 1:00PM WW Hall","2/10 - 3:30PM WW Hall"
                ,"2/10 - 3:30PM WW Hall","2/23 - 7:30PM Mceinry","2/9 - 11:00AM Atkins"};
        String[] titles = {"Stars","49SD","Debate","Soccer","UWalk","Epic","C.Fair"};

        //Drawable[] images = {getDrawable(R.drawable.restaurant);R.drawable.premium}

        //String[]

        for (int i = 0; i < 6; i++) {
            User user = new User();
            Random r  = new Random();
            Random v = new Random();
            user.setTitle(titles[i]);
            user.setDesc("School Event");
            if(r.nextInt(35) % 2 == 0) {
                user.setIsFood(true);
            }
            else user.setIsFood(false);
            if(v.nextInt(42) % 2 == 1) {
                user.setIsParking(true);
            }
            else user.setIsParking(false);
            user.setDate(randomDates[i]);
            mUsers.add(user);
        }
        mUsers.add(new User(titles[6],"School Event","2/9 11:00AM Atkins",true,true));

    }

    public List<User> getUsers()
    {
        return mUsers;
    }

    private User getUser(UUID id)
    {
        for (int i = 0; i < mUsers.size(); i++)
        {
            if(id.equals(mUsers.get(i).mId))
            {
                return mUsers.get(i);
            }
        }
        return null;
    }
}
