package imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.TranslateRetrofit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis.LanguageSupportmodel;

public final class SharedViewmodel extends ViewModel {
  private   MutableLiveData<LanguageSupportmodel> liveData =new MutableLiveData<>();
    public void setLiveData(LanguageSupportmodel name){ liveData.setValue(name); }
    public LiveData<LanguageSupportmodel>  getliveData(){return liveData; }





}
