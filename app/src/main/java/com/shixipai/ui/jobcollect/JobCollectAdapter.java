package com.shixipai.ui.jobcollect;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shixipai.R;
import com.shixipai.bean.JobItem;
import com.shixipai.db.DBHelper;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.common.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/26.
 */
public class JobCollectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_VIEW_TYPE_ITEM = 0;
    private static final int ITEM_VIEW_TYPE_FOOTER = 1;

    private Context context;
    private OnItemClickListener onItemClicked;

    private ArrayList<JobItem> dataSet = new ArrayList<>();

    //用来设置itemCount，以判断是否显示底部进度条（也就是最后一项）
    private boolean useFooter;

    public static class ItemHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.cardview_job_list_item)
        CardView cardView;

        @Bind(R.id.tv_job_item_place)
        TextView tv_place;

        @Bind(R.id.tv_job_item_time)
        TextView tv_time;

        @Bind(R.id.tv_job_item_postion)
        TextView tv_position;

        @Bind(R.id.tv_job_item_company)
        TextView tv_company;

        @Bind(R.id.tv_job_item_money)
        TextView tv_momey;

        @Bind(R.id.bt_job_item_commit)
        Button bt_commit;


        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class FooterHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.pb_footer_load_more)
        ProgressBar pbLoadMore;

        public FooterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public JobCollectAdapter(Context context, OnItemClickListener onItemClicked){
        this.context = context;
        this.onItemClicked = onItemClicked;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        RecyclerView.ViewHolder viewHolder;

        if(viewType == ITEM_VIEW_TYPE_ITEM){
            View view = inflater.inflate(R.layout.item_job_list,viewGroup,false);
            viewHolder = new ItemHolder(view);
        }else{
            View view = inflater.inflate(R.layout.recyclerview_footer_load_more,viewGroup,false);
            viewHolder = new FooterHolder(view);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
//        viewHolder.setIsRecyclable(false);

        if(getItemViewType(position) == ITEM_VIEW_TYPE_ITEM){
            JobItem jobItem = dataSet.get(position);
            ItemHolder itemHolder = (ItemHolder) viewHolder;

            itemHolder.tv_place.setText(jobItem.getArea());
            itemHolder.tv_time.setText(jobItem.getStart_time());
            itemHolder.tv_position.setText(jobItem.getTitle());
            itemHolder.tv_momey.setText(jobItem.getSalary());
            itemHolder.tv_company.setText(jobItem.getCompany());

            View.OnClickListener onClickListener = new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    onItemClicked.onItemClicked(v,position);
                }
            };
            if (DBHelper.checkJobPosted(jobItem.getId())){
//                itemHolder.bt_commit.setClickable(false);
                itemHolder.bt_commit.setBackground(ResourceHelper.getDrawable(R.drawable.background_bt_posted));
                itemHolder.bt_commit.setText("已投递");
            }else {
//                itemHolder.bt_commit.setOnClickListener(onClickListener);
                itemHolder.bt_commit.setBackground(ResourceHelper.getDrawable(R.drawable.item_job_list_btn));
                itemHolder.bt_commit.setText("投递简历");
            }
            itemHolder.cardView.setOnClickListener(onClickListener);
        }
    }

    @Override
    public int getItemCount() {
        int count = dataSet.size();
        return useFooter? ++count:count;
    }

    @Override
    public int getItemViewType(int position) {
        return position < dataSet.size() ? ITEM_VIEW_TYPE_ITEM:ITEM_VIEW_TYPE_FOOTER;
    }

    public JobItem getItem(int position){
        return dataSet.get(position);
    }

    public void updateData(List<JobItem> items){
        dataSet.clear();
        dataSet.addAll(items);
        notifyDataSetChanged();
    }

    public void addData(List<JobItem> items){
        dataSet.addAll(items);
        notifyDataSetChanged();
    }

    public void setUseFooter(boolean useFooter){
        this.useFooter = useFooter;
        notifyDataSetChanged();
    }
}
