package imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.TranslateRetrofit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis.LanguageSupportmodel;

public final class translateViewmodel extends ViewModel {


    private MutableLiveData<List<LanguageSupportmodel>>  languageSupportmodelMutableLiveData ;
    public LiveData<List<LanguageSupportmodel>>  getLiveFata(){
        if(languageSupportmodelMutableLiveData ==null){
            languageSupportmodelMutableLiveData =new MutableLiveData<>();
            languageSupportmodelMutableLiveData.setValue(LanguageArray.Arrayvalues()); }
        return languageSupportmodelMutableLiveData; }




}
