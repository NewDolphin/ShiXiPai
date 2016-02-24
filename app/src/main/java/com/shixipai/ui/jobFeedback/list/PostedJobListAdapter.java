package com.shixipai.ui.jobFeedback.list;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shixipai.R;
import com.shixipai.bean.JobItem;
import com.shixipai.bean.jobfeedback.JobFeedBack;
import com.shixipai.db.DBHelper;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.common.OnItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/22.
 */
public class PostedJobListAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_VIEW_TYPE_ITEM = 0;
    private static final int ITEM_VIEW_TYPE_FOOTER = 1;

    private Context context;
    private OnItemClickListener onItemClicked;

    public ArrayList<JobFeedBack> dataSet = new ArrayList<>();

    //用来设置itemCount，以判断是否显示底部进度条（也就是最后一项）
    private boolean useFooter;

    public static class ItemHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.cardview_job_feedback_list)
        CardView cardView;

        @Bind(R.id.iv_job_feedback_item)
        ImageView iv_job_feedback_item;

        @Bind(R.id.tv_job_title)
        TextView tv_job_title;

        @Bind(R.id.tv_job_area)
        TextView tv_job_area;

        @Bind(R.id.tv_job_salary)
        TextView tv_job_salary;

        @Bind(R.id.tv_job_time)
        TextView tv_job_time;

        @Bind(R.id.tv_job_state)
        TextView tv_job_state;

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

    public PostedJobListAdapter(Context context, OnItemClickListener onItemClicked){
        this.context = context;
        this.onItemClicked = onItemClicked;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        RecyclerView.ViewHolder viewHolder;

        if(viewType == ITEM_VIEW_TYPE_ITEM){
            View view = inflater.inflate(R.layout.item_job_feedback_list,viewGroup,false);
            viewHolder = new ItemHolder(view);
        }else{
            View view = inflater.inflate(R.layout.recyclerview_footer_load_more,viewGroup,false);
            viewHolder = new FooterHolder(view);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        if(getItemViewType(position) == ITEM_VIEW_TYPE_ITEM){
            JobFeedBack jobItem = dataSet.get(position);
            ItemHolder itemHolder = (ItemHolder) viewHolder;

            Picasso.with(context)
                    .load(jobItem.getCompany_image())
                    .into(itemHolder.iv_job_feedback_item);
            itemHolder.tv_job_title.setText(jobItem.getIntern_title());
            itemHolder.tv_job_area.setText(jobItem.getArea());
            itemHolder.tv_job_salary.setText(jobItem.getSalary());
            if (jobItem.getStart_time()!=null){
                String jobTime = jobItem.getStart_time().substring(0,10);
                itemHolder.tv_job_time.setText(jobTime);
            }

            if (jobItem.getState3_title()!= null){
                itemHolder.tv_job_state.setText(jobItem.getState3_keyword());
            }else if (jobItem.getState2_title()!= null){
                itemHolder.tv_job_state.setText(jobItem.getState2_keyword());
            }else {
                itemHolder.tv_job_state.setText(jobItem.getState1_keyword());
            }

            View.OnClickListener onClickListener = new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    onItemClicked.onItemClicked(v,position);
                }
            };
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

    public JobFeedBack getItem(int position){
        return dataSet.get(position);
    }

    public void updateData(List<JobFeedBack> items){
        dataSet.clear();
        dataSet.addAll(items);
        notifyDataSetChanged();
    }

    public void addData(List<JobFeedBack> items){
        dataSet.addAll(items);
        notifyDataSetChanged();
    }

    public void setUseFooter(boolean useFooter){
        this.useFooter = useFooter;
        notifyDataSetChanged();
    }
}
