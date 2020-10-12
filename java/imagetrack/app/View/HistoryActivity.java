package imagetrack.app.View;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

import imagetrack.app.HistoryDatabase.HistoryBean;
import imagetrack.app.HistoryDatabase.HistoryDatabase;
import imagetrack.app.HistoryDatabase.HistoryLiveDatabase;
import imagetrack.app.HistoryDatabase.HistoryRecyclerViewAdapter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class HistoryActivity extends AppCompatActivity {

    String TAG=HistoryActivity.class.getSimpleName();
    CompositeDisposable compositeDisposable;
    private RecyclerView recyclerView;
    private List<HistoryBean> myHistoryArray;
   private HistoryRecyclerViewAdapter historyRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historyactivity);
    compositeDisposable =new CompositeDisposable();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(HistoryActivity.this,DividerItemDecoration.VERTICAL));

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        init();
    }

    private void init() {
        HistoryLiveDatabase historyLiveDatabase =new HistoryLiveDatabase(this.getApplication());
        Observable<List<HistoryBean>> observable= historyLiveDatabase.getHistoryList();
        observable.subscribe(new io.reactivex.Observer<List<HistoryBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

                compositeDisposable.add(d);
            }

            @Override
            public void onNext(List<HistoryBean> historyBeans) {
               myHistoryArray =   historyBeans;
                historyRecyclerViewAdapter =new HistoryRecyclerViewAdapter(historyBeans);
                historyRecyclerViewAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(historyRecyclerViewAdapter);
            }

            @Override
            public void onError(Throwable e) {

                Log.i(TAG, "onError: "+e.getMessage());

            }

            @Override
            public void onComplete() {
                compositeDisposable.clear();
                Log.i(TAG, "onComplete: ");
            }
        });

    }

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(final RecyclerView.ViewHolder viewHolder, int swipeDir) {

           CardView cardView= viewHolder.itemView.findViewById(R.id.cardview);
            cardView.setRadius(12.2f);

            viewHolder.itemView.setBackgroundColor(getColor(R.color.colorAccent));

            int position = viewHolder.getAdapterPosition();

                     final HistoryBean historyBean=   myHistoryArray.get(position);

                     myHistoryArray.remove(position);

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            HistoryDatabase historyDatabase =HistoryDatabase.getInstance(HistoryActivity.this);
                            historyDatabase.userDao().delete(historyBean);
                        }
                    }).start();

            historyRecyclerViewAdapter.notifyDataSetChanged();

        }
    };
}
