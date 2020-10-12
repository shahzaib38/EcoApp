package imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.TranslateRetrofit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import com.example.myapplication.R;
import java.util.List;

import imagetrack.app.trackobject.Constants.Constants;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis.LanguageSupportmodel;

public final class LanguageAdapter extends BaseAdapter  {

    private List<LanguageSupportmodel> mData;

    public LanguageAdapter(List<LanguageSupportmodel> languageSupportmodels ){
    mData =languageSupportmodels; }


    @Override
    public int getCount() { return mData.size(); }

    @Override
    public Object   getItem(int position) { return  mData.get(position); }

    @Override
    public long getItemId(int position) {
        return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View result;
        if (convertView == null) {
            result = LayoutInflater.from(parent.getContext()).inflate(R.layout.languagevalue, parent, false);
        } else {
            result = convertView;
        }
        LanguageSupportmodel  languageSupportmodels= (LanguageSupportmodel) getItem(position);
        ImageView imageViewlanguages= result.findViewById(R.id.languagesupportimage);
        TextView textView=   result.findViewById(R.id.translateText);

        if (languageSupportmodels.getName()!=null &&languageSupportmodels.getImageSupport().equals(Constants.SUPPORTED)){
         imageViewlanguages.setImageDrawable(ResourcesCompat.getDrawable(parent.getContext().getResources(), R.drawable.speaker, null));
        }else{
            imageViewlanguages.setImageDrawable(null); }

            textView.setText(languageSupportmodels.getName());
        return result; }


}
