package benjamin.gu.contacttest;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private ResultPojo dataSet;

    CustomListener listener;

    public void setDataSet(ResultPojo dataSet){
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout
        .item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.onBindViewHolder(dataSet.contacts.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.contacts.size() : 0;
    }

    public void setListener(CustomListener listener) {
        this.listener = listener;
    }
}
