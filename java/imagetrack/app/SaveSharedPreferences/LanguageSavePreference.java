package imagetrack.app.SaveSharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import imagetrack.app.trackobject.Constants.Constants;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis.LanguageSupportmodel;

import static android.content.Context.MODE_PRIVATE;
import static imagetrack.app.trackobject.Constants.Constants.DEFAULTVALUE;
import static imagetrack.app.trackobject.Constants.Constants.LANGUAGEVALUE;
import static imagetrack.app.trackobject.Constants.Constants.MyPREFERENCESDATABASE;


public final class LanguageSavePreference {

   private static SharedPreferences sharedPrefrences;
   private static LanguageSavePreference languageSavePreference;

     private LanguageSavePreference(){}

     /******* Creating Insatance *************/
    public static  LanguageSavePreference getPrefeerencesInstance(Context context)
       { if (languageSavePreference==null) {
           languageSavePreference =new LanguageSavePreference(); }
           sharedPrefrences = context.getSharedPreferences(MyPREFERENCESDATABASE, MODE_PRIVATE);
       return languageSavePreference; }


        /******* Saving Language Data *************/
        public <T extends LanguageSupportmodel>void setValue(T t){
           SharedPreferences.Editor shared_Editor;

            shared_Editor = sharedPrefrences.edit();
            shared_Editor.putString(Constants.LANGUAGEVALUE, t.getLanguageKey());
            shared_Editor.putString( Constants.SHAREDNAME,t.getName());
            shared_Editor.apply(); }




            /********** Getting Saved Data *******/
            public  String getSharedData(){
            return   sharedPrefrences.getString(LANGUAGEVALUE,DEFAULTVALUE);
            }

            ///*****Shared Name *****************/
       //     public  String getSharedName(){
            //   return sharedPrefrences.getString(Constants.SHAREDNAME,DEFAULTVALUENAME);
          //  }




}
