package com.example.recyclerviewstudy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder> {

    private static final String TAG = GreenAdapter.class.getName();

    private static int viewHolderCount;

    private int mNumberItems;

    final private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }


    public GreenAdapter(int numberOfItem, ListItemClickListener listener) {
        mNumberItems = numberOfItem;
        mOnClickListener = listener;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.number_list_view;
        LayoutInflater inFlater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inFlater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        viewHolder.listItemStringView.setText("ViewHolder index: " + viewHolderCount);
        int backgroundColorForViewHolder = ColorUtils
                .getViewHolderBackgroundColorFromInstance(context, viewHolderCount);
        viewHolder.itemView.setBackgroundColor(backgroundColorForViewHolder);

        viewHolderCount++;
        Log.d(TAG, "onCreateViewHolder : number of viewHolders created : " + viewHolderCount);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder, int position) {
        numberViewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView listItemNumberView;
        TextView listItemStringView;

        public NumberViewHolder(View itemView) {
            super(itemView);

            listItemNumberView = (TextView) itemView.findViewById(R.id.number_list_view);
            listItemStringView = (TextView) itemView.findViewById(R.id.number_list_string);
            itemView.setOnClickListener(this);
        }
        void bind(int listIndex) {
            Log.d(TAG, "Bind Function : " + String.valueOf(listIndex));
            listItemNumberView.setText(String.valueOf(listIndex));
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
            Log.d(TAG, "Clieck Number : " + clickedPosition);
        }
    }
}
