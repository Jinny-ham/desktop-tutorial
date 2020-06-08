package com.example.recyclercardview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclercardview.R;
import com.example.recyclercardview.model.Landscape;

import java.util.List;
import java.util.zip.Inflater;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private static final String TAG = RecyclerAdapter.class.getSimpleName();

    private static final int PRIME_ROW = 0;
    private static final int NON_PRIME_ROW = 1;

    private List<Landscape> mDataList;
    private LayoutInflater inflater;

    @Override
    public int getItemViewType(int position) {
        Landscape landscape = mDataList.get(position);
        if (landscape.isPrime()) return PRIME_ROW;
        else return NON_PRIME_ROW;
    }

    public RecyclerAdapter(Context context, List<Landscape> data) {
        this.mDataList = data;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Log.d(TAG, "onCreateViewHolder");
//        View view = inflater.inflate(R.layout.list_item, parent, false);
//        MyViewHolder holder = new MyViewHolder(view);
//        return holder;

        switch (viewType){
            case PRIME_ROW:
                ViewGroup primeRow = (ViewGroup) inflater.inflate(R.layout.list_item_prime, parent, false);
                MyViewHolder_PRIME holderPrime = new MyViewHolder_PRIME(primeRow);
                return holderPrime;

            case NON_PRIME_ROW:
                ViewGroup nonPrimeRow = (ViewGroup) inflater.inflate(R.layout.list_item_not_prime, parent,false);
                MyViewHolder_NON_PRIME holderNonPrime = new MyViewHolder_NON_PRIME(nonPrimeRow);
                return holderNonPrime;
            default:
                ViewGroup defaultRow = (ViewGroup) inflater.inflate(R.layout.list_item_not_prime,parent, false);
                MyViewHolder_NON_PRIME holderDefault = new MyViewHolder_NON_PRIME(defaultRow);
                return holderDefault;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder " + position);
        Landscape current = mDataList.get(position);
//        holder.setData(current, position);
//        holder.setListeners();

        switch (holder.getItemViewType()){
            case PRIME_ROW:
                MyViewHolder_PRIME holder_prime = (MyViewHolder_PRIME) holder;
                holder_prime.setData(current);
                break;
            case NON_PRIME_ROW:
                MyViewHolder_NON_PRIME holder_non_prime = (MyViewHolder_NON_PRIME) holder;
                holder_non_prime.setData(current);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void removeItem(int position) {
        mDataList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mDataList.size());
        //notifyDataSetChanged(); //no animation
    }

    public void addItem(int position, Landscape landscape) {
        mDataList.add(position, landscape);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, mDataList.size());

        //notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView imgThumb, imgDelete, imgAdd;
        int position;
        Landscape current;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            imgThumb = (ImageView) itemView.findViewById(R.id.img_row);
            imgDelete = (ImageView) itemView.findViewById(R.id.img_row_delete);
            imgAdd = (ImageView) itemView.findViewById(R.id.img_row_add);
        }

        public void setData(Landscape current, int position) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            this.position = position;
            this.current = current;
        }

        @Override
        public void onClick(View v) {
            Log.i(TAG, "onClick before operation at Position : " + position + " size : " + mDataList.size());
            switch (v.getId()) {
                case R.id.img_row_delete:
                    removeItem(position);
                    break;
                case R.id.img_row_add:
                    addItem(position, current);
                    break;
            }
            Log.i(TAG, "onClick after operation - size " + mDataList.size() + "\n\n" + mDataList.toString());
        }

        public void setListeners() {
            imgDelete.setOnClickListener(MyViewHolder.this);
            imgAdd.setOnClickListener(MyViewHolder.this);
        }
    }

    public class MyViewHolder_PRIME extends MyViewHolder{
        TextView title;
        ImageView imgThumb, imgRowType;

        public MyViewHolder_PRIME(View itemView){
            super(itemView);

            title = itemView.findViewById(R.id.tvTitle);
            imgThumb = itemView.findViewById(R.id.img_row);
            imgRowType = itemView.findViewById(R.id.img_row_prime);
        }

        public void setData(Landscape current){
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            this.imgRowType.setImageResource(R.drawable.prime);
        }
    }

    public class MyViewHolder_NON_PRIME extends MyViewHolder{
        TextView title;
        ImageView imgThumb, imgRowType;

        public MyViewHolder_NON_PRIME(View itemView){
            super(itemView);

            title = itemView.findViewById(R.id.tvTitle);
            imgThumb = itemView.findViewById(R.id.img_row);
            imgRowType = itemView.findViewById(R.id.img_row_not_prime);
        }

        public void setData(Landscape current){
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            this.imgRowType.setImageResource(R.drawable.not_prime);
        }

    }
}
