package com.shixipai.ui.strategy.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shixipai.R;
import com.shixipai.bean.interview.InterviewQuestionItem;
import com.shixipai.bean.strategy.StrategyItem;
import com.shixipai.ui.common.OnItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/6.
 */
public class StrategyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_VIEW_TYPE_ITEM = 0;
    private static final int ITEM_VIEW_TYPE_FOOTER = 1;

    private Context context;
    private OnItemClickListener onItemClicked;

    public ArrayList<StrategyItem> dataSet = new ArrayList<>();

    //用来设置itemCount，以判断是否显示底部进度条（也就是最后一项）
    private boolean useFooter;

    public static class ItemHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.tv_strategy_list_time)
        TextView tv_time;

        @Bind(R.id.layout_strategy_list)
        RelativeLayout layout;

        @Bind(R.id.iv_strategy_list)
        ImageView iv_background;

        @Bind(R.id.tv_strategy_list_title)
        TextView tv_title;

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

    public StrategyListAdapter(Context context, OnItemClickListener onItemClicked){
        this.context = context;
        this.onItemClicked = onItemClicked;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        RecyclerView.ViewHolder viewHolder;

        if(viewType == ITEM_VIEW_TYPE_ITEM){
            View view = inflater.inflate(R.layout.item_strategy_list,viewGroup,false);
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
            StrategyItem item = dataSet.get(position);
            ItemHolder itemHolder = (ItemHolder) viewHolder;

            itemHolder.tv_time.setText(item.getUpdated_at());
            itemHolder.tv_title.setText(item.getTitle());

            Picasso.with(context)
                    .load("http://182.92.11.218/i/shixipai/"+item.getImg())
                    .into(itemHolder.iv_background);

            View.OnClickListener onClickListener = new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    onItemClicked.onItemClicked(v,position);
                }
            };
            itemHolder.layout.setOnClickListener(onClickListener);
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

    public StrategyItem getItem(int position){
        return dataSet.get(position);
    }

    public void addData(List<StrategyItem> items){
        dataSet.addAll(items);
        notifyDataSetChanged();
    }

    public void setUseFooter(boolean useFooter){
        this.useFooter = useFooter;
        notifyDataSetChanged();
    }
}
