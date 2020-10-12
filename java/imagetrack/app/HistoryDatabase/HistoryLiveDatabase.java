package imagetrack.app.HistoryDatabase;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HistoryLiveDatabase extends AndroidViewModel {

    private final Observable<List<HistoryBean>> liveHistoryArrayList;
    HistoryRepository historyRepository;

    public HistoryLiveDatabase(@NonNull Application application) {
        super(application);
    historyRepository=new HistoryRepository(application);

           liveHistoryArrayList =   historyRepository.getHistoryList().toObservable().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }


  public   Observable<List<HistoryBean>> getHistoryList(){
        return liveHistoryArrayList;
    }





}
