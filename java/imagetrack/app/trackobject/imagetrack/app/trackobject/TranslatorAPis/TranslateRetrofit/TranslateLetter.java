package imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.TranslateRetrofit;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.example.myapplication.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import imagetrack.app.HistoryDatabase.HistoryBean;
import imagetrack.app.HistoryDatabase.HistoryDatabase;
import imagetrack.app.HistoryDatabase.HistoryRepository;
import imagetrack.app.SaveSharedPreferences.LanguageSavePreference;
import imagetrack.app.trackobject.Constants.Constants;
import imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit.AudioBinder;
import imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit.AudioConfig;
import imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit.AudioRequestBody;
import imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit.AudioResponseData;
import imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit.AudioTextToSpeechComponent;
import imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit.DaggerAudioTextToSpeechComponent;
import imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit.FindLocalLanguage;
import imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit.Input;
import imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit.InterfaceDetectTextToAudio;
import imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit.PlayMediaService;
import imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit.Voice;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis.Data;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis.TranslateDetect;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis.Translation;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.ITranslateApis.DaggerRetrofitComponent;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.ITranslateApis.DetectApi;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.ITranslateApis.ITranslateLetter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.Retrofit;
import static imagetrack.app.trackobject.Constants.Constants.KEY;


public final class TranslateLetter extends ViewModel implements ITranslateLetter {

     private String TAG =TranslateLetter.class.getSimpleName();
     private String name;
     private Context context;
     private CompositeDisposable compositeDisposable;
     private PlayMediaService mService;
     private FindLocalLanguage findLocalLanguage;

     private TranslateLetter(){}
    public static TranslateLetter getTranslateLetterInstance(){ return new TranslateLetter();}



   @Override
  public void  TranslateWords(String stringBuffer , final Context context){
      compositeDisposable =new CompositeDisposable();

       this.context =context;
      findLocalLanguage =new FindLocalLanguage();
      LanguageSavePreference languageSavePreference =LanguageSavePreference.getPrefeerencesInstance(context);
                              name = languageSavePreference.getSharedData();

      Log.i(TAG, "TranslateWords: "+name);
      DetectApi service= DaggerRetrofitComponent.builder().build().getRetrofit().create(DetectApi.class);
      Map<String ,String> postParameters =new HashMap<>();
      postParameters.put("q" ,stringBuffer);
      postParameters.put("target",name);
      postParameters.put("key" ,KEY);

      Observable<Response<TranslateDetect>>  translateLetterObservable= service.getData(postParameters).toObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
      translateLetterObservable.subscribe(new Observer<Response<TranslateDetect>>() {
           @Override
           public void onSubscribe(Disposable d) {
               compositeDisposable.add(d); }
               @Override
           public void onNext(Response<TranslateDetect> translateDetectResponse) {



               TranslateDetect translateDetect =   translateDetectResponse.body();
               if (translateDetect!=null) {
                   Data data = translateDetect.getData();

                   String translateText = null;

                   for (Translation translations : data.getTranslations()) {
                       translateText = translations.getTranslatedText();
                   }
                   AlertBoxForTranslateText(translateText);
                   DetectTheSentence(translateText, name);
               }
               }
           @Override
           public void onError(Throwable e) { AlertBoxForTranslateText(e.getMessage()); }
           @Override
           public void onComplete() {

           }});




    }

    @Override
    public void DetectTheSentence(String translateText,String DetectLanguage) {
         BindService();
         String Textlanguage=   findLocalLanguage.InternationalLocalLanguage(DetectLanguage);
         compositeDisposable=new CompositeDisposable();
         AudioTextToSpeechComponent audioTextToSpeechComponent = DaggerAudioTextToSpeechComponent.builder().build();
         Retrofit retrofit=  audioTextToSpeechComponent.getRetrofit();
         InterfaceDetectTextToAudio interfaceDetectTextToAudio = retrofit.create(InterfaceDetectTextToAudio.class);
         List<String> list =new ArrayList<>();
         list.add("handset-class-device");
         Input input =new Input(translateText);
        Voice voice =new Voice(Textlanguage,Textlanguage+"-Standard-B");

        final AudioConfig audioConfig =new AudioConfig( "MP3",list ,0 ,1);
        final AudioRequestBody audioRequestBody =new AudioRequestBody(audioConfig,input,voice);

        Observable<AudioResponseData> audioResponseDataObservable= interfaceDetectTextToAudio.getResposeBody(audioRequestBody).toObservable().subscribeOn(Schedulers.io());
        audioResponseDataObservable.subscribe(new io.reactivex.Observer<AudioResponseData>() {
            @Override
            public void onSubscribe(Disposable d) {

              compositeDisposable.add(d);
            }

            @Override
            public void onNext(AudioResponseData audioResponseData) {

                try {
                    mService.OnInitialized(context ,audioResponseData.getAudioContent());
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.i(TAG, "onNext: "+e.getMessage());
                }

            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError: "+e.getCause()); }

            @Override
            public void onComplete() {
              compositeDisposable.clear();
                Log.i(TAG, "onComplete: ");
            }
        });



    }

    @Override
    public void BindService() {

        Intent intent = new Intent(context, PlayMediaService.class);
        context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);

    }

    @Override
    public void AlertBoxForTranslateText(final String translateText) {


        new AlertDialog.Builder(context)
                .setTitle("Translated Text")
                .setMessage(translateText)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {



                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                HistoryDatabase historyDatabase =HistoryDatabase.getInstance(context);
                                HistoryBean historyBean =new HistoryBean();
                                historyBean.setValue(translateText);
                                historyDatabase.userDao().insert(historyBean);
                            }
                        }).start();








                            }
                })

                .setNegativeButton(android.R.string.no, null)
                .setIcon(R.drawable.icontranslate)
                .show(); }


                private ServiceConnection serviceConnection =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected: ");

            AudioBinder binder = (AudioBinder) service;
            mService = binder.getService();


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected: ");
        }
    };

      private HistoryDatabase getHistoryDatabaseInstance(){
            return      Room.databaseBuilder(context.getApplicationContext(),
                 HistoryDatabase.class, Constants.MYHISTORYDATABASE).build();


     }
}
