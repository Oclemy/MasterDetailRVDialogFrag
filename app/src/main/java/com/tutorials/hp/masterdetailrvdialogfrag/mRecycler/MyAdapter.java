package com.tutorials.hp.masterdetailrvdialogfrag.mRecycler;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tutorials.hp.masterdetailrvdialogfrag.R;
import com.tutorials.hp.masterdetailrvdialogfrag.mData.SpaceCraft;
import com.tutorials.hp.masterdetailrvdialogfrag.mFragment.SpacecraftFragment;

import java.util.ArrayList;

/**
 * Created by Oclemy on 5/12/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<SpaceCraft> spaceCrafts;
    FragmentManager fm;

    public MyAdapter(Context c, ArrayList<SpaceCraft> spaceCrafts, FragmentManager fm) {
        this.c = c;
        this.spaceCrafts = spaceCrafts;
        this.fm = fm;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        TextView nameTxt=holder.nameTxt;
        ImageView img=holder.img;

        final String name=spaceCrafts.get(position).getName();
        final int image=spaceCrafts.get(position).getImage();

        nameTxt.setText(name);
        img.setImageResource(image);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openDialogFragment(name,image);
                Toast.makeText(c,name,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return spaceCrafts.size();
    }

    //OPEN FRAGENT
    private void openDialogFragment(String name,int image)
    {
        //BUNDLE data
        Bundle b=new Bundle();
        b.putString("NAME_KEY", name);
        b.putInt("IMAGE_KEY", image);

        SpacecraftFragment spacecraftFragment=new SpacecraftFragment();
        spacecraftFragment.setArguments(b);
        spacecraftFragment.show(fm,"mTag");
    }
}















