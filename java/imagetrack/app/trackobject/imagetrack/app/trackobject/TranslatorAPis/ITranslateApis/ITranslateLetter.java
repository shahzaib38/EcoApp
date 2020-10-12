package imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.ITranslateApis;

import android.content.Context;

public interface ITranslateLetter {
    void  TranslateWords(String stringBuffer ,  Context context);
    void DetectTheSentence(String translateText,String DetectLanguage);
    void BindService();
    void AlertBoxForTranslateText(String translateText);}
