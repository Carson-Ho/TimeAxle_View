package scut.carson_ho.timeaxle_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Carson_Ho on 17/6/8.
 */
public class MyAdapter extends RecyclerView.Adapter {
    private LayoutInflater inflater;
    private ArrayList<HashMap<String, Object>> listItem;

    //构造函数，传入数据
    public MyAdapter(Context context, ArrayList<HashMap<String, Object>> listItem) {
        inflater = LayoutInflater.from(context);
        this.listItem = listItem;
    }


    //定义Viewholder
    class Viewholder extends RecyclerView.ViewHolder  {
        private TextView Title, Text;

        public Viewholder(View root) {
            super(root);
            Title = (TextView) root.findViewById(R.id.Itemtitle);
            Text = (TextView) root.findViewById(R.id.Itemtext);

        }

        public TextView getTitle() {
            return Title;
        }

        public TextView getText() {
            return Text;
        }


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(inflater.inflate(R.layout.list_cell, null));
    }//在这里把ViewHolder绑定Item的布局

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Viewholder vh = (Viewholder) holder;
        // 绑定数据到ViewHolder里面
        vh.Title.setText((String) listItem.get(position).get("ItemTitle"));
        vh.Text.setText((String) listItem.get(position).get("ItemText"));
    }

    //返回Item数目
    @Override
    public int getItemCount() {
        return listItem.size();
    }


}
