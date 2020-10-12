package imagetrack.app.HistoryDatabase;

import android.app.Application;

import java.util.List;

import io.reactivex.Flowable;

public class HistoryRepository {

    private final Flowable<List<HistoryBean>> historyLiveData;
    private HistoryDao historyDao;



 public HistoryRepository(Application application){

      HistoryDatabase historyDatabase =HistoryDatabase.getInstance(application);

   historyDao=   historyDatabase.userDao();
        historyLiveData = historyDao.getAll();

  }



    Flowable<List<HistoryBean>>   getHistoryList(){
      return historyLiveData;
  }



   void setValue(HistoryBean... historyBeans){

      historyDao.insert(historyBeans);


  }







}
