package imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.TranslateFragment;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.myapplication.R;
import java.util.List;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.TranslateRetrofit.LanguageAdapter;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis.LanguageSupportmodel;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.TranslateRetrofit.SharedViewmodel;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.TranslateRetrofit.translateViewmodel;

public final class LanguageRequestView extends DialogFragment {

   private AlertDialog dialog =null;
   private  LanguageAdapter languageAdapter;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        dialog = DialogFragment() ;
        dialog.getWindow().setLayout((int) (350 * getDensity()), (int) (600 * getDensity()));
       dialog.create();




    return dialog; }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getActivity()==null){ return null; }

       View   view = LayoutInflater.from(getActivity()).inflate(R.layout.languageview, container, false);

         ListView listView = view.findViewById(R.id.languagelistview);
        translateViewmodel translateViewmodel1=  ViewModelProviders.of(this).get(translateViewmodel.class);
         LiveData<List<LanguageSupportmodel>>  listLiveData= translateViewmodel1.getLiveFata();
          languageAdapter =new LanguageAdapter(listLiveData.getValue());
         listLiveData.observe(this, new Observer<List<LanguageSupportmodel>>() {
              @Override
              public void onChanged(List<LanguageSupportmodel> languageSupportmodels) { languageAdapter.notifyDataSetChanged(); }});
         listView.setAdapter(languageAdapter);
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LanguageSupportmodel languageSupportmodel = (LanguageSupportmodel) parent.getItemAtPosition(position);
                if (getActivity()!=null) {

                    SharedViewmodel model = ViewModelProviders.of(getActivity()).get(SharedViewmodel.class);

                    model.setLiveData(languageSupportmodel);
                }
            dialog.dismiss();
            }
         }
         );


         return view;}

    private AlertDialog DialogFragment(){
        if (getActivity()==null){ return null; }
        return new AlertDialog.Builder(getActivity()).setTitle(getResources().getString(R.string.chooselanguage)).create(); }


    private float getDensity() {
        DisplayMetrics displayMetrics =new DisplayMetrics();
            ((WindowManager)   getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);

        return displayMetrics.density;
    }
}

