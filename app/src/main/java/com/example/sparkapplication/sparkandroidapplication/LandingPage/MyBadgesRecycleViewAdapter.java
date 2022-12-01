package com.example.sparkapplication.sparkandroidapplication.LandingPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sparkapplication.R;

import java.util.List;

public class MyBadgesRecycleViewAdapter extends RecyclerView.Adapter<MyBadgesRecycleViewAdapter.MyViewHolder> {

    private MyBadgesDataClass[] listdata;

    // RecyclerView recyclerView;
    public MyBadgesRecycleViewAdapter(MyBadgesDataClass[] listdata) {
        this.listdata = listdata;
    }
    @NonNull
    @Override
    public MyBadgesRecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.card_mybadges, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyBadgesRecycleViewAdapter.MyViewHolder holder, int position) {
        final MyBadgesDataClass myListData = listdata[position];
        holder.textViewName.setText(listdata[position].getMyBadgesName());
        holder.imageViewIcon.setImageResource(listdata[position].getMyBadgespath());

    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        ImageView imageViewIcon;
        Context context;

        public MyViewHolder(View view) {
            super(view);
            imageViewIcon = (ImageView) view.findViewById(R.id.imageViewIcon);
            textViewName = (TextView) view.findViewById(R.id.textViewName);
            //Setting Item width to 80% of device width
//            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(itemWidth,
//                    RelativeLayout.LayoutParams.WRAP_CONTENT);
//            view.setLayoutParams(layoutParams);
        }
       /* public void bind(final CategoryHorizontalDataClass item, final CategoryHorizontalIyAdapter.OnItemClickListener listener) {
            imageViewIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CategorySelectionFragment someFragment = new CategorySelectionFragment();
                    FragmentTransaction transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.addToBackStack(null);
                    transaction.replace(R.id.fragment_container, someFragment).commit();
                    listener.onItemClick(item,v);
                }
            });
        }*/

    }
}
