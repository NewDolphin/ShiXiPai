package com.shixipai.ui.jobClassify;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shixipai.R;
import com.shixipai.bean.JobClassifyItem;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.common.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/1/23.
 */
public class JobClassifyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<JobClassifyItem> datas;

    private OnItemClickListener onItemClickListener;

    public JobClassifyAdapter(ArrayList<JobClassifyItem> datas,OnItemClickListener onItemClicked) {
        this.datas = datas;
        this.onItemClickListener = onItemClicked;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_job_classify, parent, false);
        viewHolder = new ItemHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final View.OnClickListener onClickListener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClicked(v,position);
            }
        };

        ItemHolder itemHolder = (ItemHolder)holder;
        JobClassifyItem jobClassifyItem = datas.get(position);

        itemHolder.pic_job_classify.setImageDrawable(ResourceHelper.getDrawable(
                jobClassifyItem.getClassifyPic()));
        itemHolder.pic_job_classify.setOnClickListener(onClickListener);

        itemHolder.title_job_classify.setText(jobClassifyItem.getClassifyName());
        itemHolder.title_job_classify.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.pic_job_classify)
        ImageView pic_job_classify;

        @Bind(R.id.title_job_classify)
        TextView title_job_classify;

        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
