package com.shixipai.ui.interview;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shixipai.R;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.common.OnItemClickListener;

import java.util.ArrayList;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/1/30.
 */
public class InterviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private OnItemClickListener onItemClicked;

    private ArrayList<Drawable> background_pic = new ArrayList<>();
    private ArrayList<Drawable> classify_pic = new ArrayList<>();
    private String[] titles = ResourceHelper.getStringArrays(R.array.interview_title);

    //用来设置itemCount，以判断是否显示底部进度条（也就是最后一项）
    private boolean useFooter;

    public static class ItemHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.layout_interview)
        RelativeLayout layout_interview;

        @Bind(R.id.iv_interview)
        ImageView iv_interview;

        @Bind(R.id.tv_interview)
        TextView tv_interview;

        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public InterviewAdapter( OnItemClickListener onItemClicked){
        this.onItemClicked = onItemClicked;

        background_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_group1));
        background_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_group2));
        background_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_group3));
        background_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_group4));
        background_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_group5));
        background_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_group6));
        background_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_group7));
        background_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_group8));
        background_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_group9));

        classify_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_pic1));
        classify_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_pic2));
        classify_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_pic3));
        classify_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_pic4));
        classify_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_pic5));
        classify_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_pic6));
        classify_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_pic7));
        classify_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_pic8));
        classify_pic.add(ResourceHelper.getDrawable(R.mipmap.ic_interview_pic9));

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        RecyclerView.ViewHolder viewHolder;

        View view = inflater.inflate(R.layout.item_interview,viewGroup,false);
        viewHolder = new ItemHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {

        ItemHolder itemHolder = (ItemHolder) viewHolder;

        itemHolder.layout_interview.setBackground(background_pic.get(position));
        itemHolder.iv_interview.setImageDrawable(classify_pic.get(position));
        itemHolder.tv_interview.setText(titles[position]);

        View.OnClickListener onClickListener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onItemClicked.onItemClicked(v,position);
            }
        };
        itemHolder.layout_interview.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return background_pic.size();
    }

}
