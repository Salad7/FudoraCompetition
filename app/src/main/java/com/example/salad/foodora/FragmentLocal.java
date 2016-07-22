package com.example.salad.foodora;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by salad on 2/5/16.
 */
public class FragmentLocal extends Fragment {

    private UserAdapter mUser;
    private RecyclerView mUserRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_local, container, false);
        mUserRecyclerView = (RecyclerView) v.findViewById(R.id.rv);
        mUserRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return v;
    }

    private void updateUI() {
        UserSingleton userSingleton = UserSingleton.get(getActivity());
        List<User> users = userSingleton.getUsers();
        mUser= new UserAdapter(users);
        mUserRecyclerView.setAdapter(mUser);
    }

    private class UserHolder extends RecyclerView.ViewHolder {

        public TextView mTitle;
        public TextView mDesc;
        public TextView mDate;
        public CheckBox mIsParking;
        public CheckBox mIsFood;
        public Button mIcon;
        public TextView mTextView;

        public UserHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.custom_title);
            mDesc = (TextView) itemView.findViewById(R.id.custom_desc);
            mDate = (TextView) itemView.findViewById(R.id.custom_date);
            mIsParking = (CheckBox) itemView.findViewById(R.id.custom_isparking);
            mIsFood = (CheckBox) itemView.findViewById(R.id.custom_isfood);
            mIcon = (Button) itemView.findViewById(R.id.custom_logo);
            mTextView = (TextView) itemView.findViewById(R.id.custom_cate);


        }


    }
    
    

    private class UserAdapter extends RecyclerView.Adapter<UserHolder> {

        private List<User> mUsers;
        public UserAdapter(List<User> users) {
            mUsers = users;
        }

        @Override
        public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.custom_list_item, parent, false);
            return new UserHolder(view);
        }
        @Override
        public void onBindViewHolder(UserHolder holder, int position) {
            User user = mUsers.get(position);
            holder.mTitle.setText(user.getTitle());
            holder.mDesc.setText(user.getDesc());
            holder.mDate.setText(user.getDate());
            holder.mIsParking.setChecked(user.isParking());
            holder.mIsFood.setChecked(user.isFood());
            //holder.mTextView.setText(user.);
        }
        @Override
        public int getItemCount() {
            return mUsers.size();
        }

    }


}
