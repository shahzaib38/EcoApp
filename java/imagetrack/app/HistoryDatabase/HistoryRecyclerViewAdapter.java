package imagetrack.app.HistoryDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.MyHistoryViewholder> {

   List<HistoryBean> historyBeanArrayList;

    public HistoryRecyclerViewAdapter(List<HistoryBean> historyBeanArrayList){
        this.historyBeanArrayList=historyBeanArrayList; }


    @NonNull
    @Override
    public MyHistoryViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.historyrecyclerview,parent,false);
        return new MyHistoryViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHistoryViewholder holder, int position) {
           HistoryBean historyBean=     historyBeanArrayList.get(position);
           holder.textView.setText(historyBean.getValue()); }

    @Override
    public int getItemCount() {
        return historyBeanArrayList.size();
    }

    public class MyHistoryViewholder extends RecyclerView.ViewHolder{

        TextView textView;


        CardView cardView;
        public MyHistoryViewholder(@NonNull View itemView) {
            super(itemView);

     //       this.itemView=itemView;
       cardView=itemView.findViewById(R.id.cardview);
        textView=itemView.findViewById(R.id.historytextview);
        }
    }

}
