package imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit;




public final class FindLocalLanguage {

    public  String InternationalLocalLanguage(String language){
        String SPEECH ="Speech is not available";

        switch (language){

            //afrikaan
            case "af": return "af-ZA";
            //Amharic
            case "am":return "am-ET";
           //Armenian
            case "hy":return "hy-AM";
            //Azerbajani
            case "az" :return "az-AZ";
            //Bengali Bangladesh
            case "bn" :return "bn-BD";
              //Malay
            case "ms" :return "ms-MY";
            //Catalan
            case "ca":return "ca-ES";
            //Czesh
            case "cs": return "cs-CZ";
            // Danish
            case "da": return "da-DK";
            //German
            case "de": return "de-DE";
           //Spanish
            case "es":return "es-AR";
           // 	Galician
            case "gl":return "gl-ES";
            //Gorgeon
            case "ka":return "ka-GE";
           //Gujrati
            case "gu":return "gu-IN";
            //Cortation
            case "hr":return "hr-HR";
            //Zulu
            case "zu":return "zu-ZA";
            //Icelandic
            case "is":return "is-IS";
            //javenese
            case "jv":return "jv-ID";
            //kannada
            case "kn":return "kn-IN";
            //khmer
            case "km":return "km-KH";
            //Lao
            case "lo":return "lo-LA";
             //Latvian
            case "lv":return "lv-LV";
            //Lithuanian
            case "lt":return "lt-LT";
            //hungrain
            case "hu": return "hu-HU";
            //Malayalam
            case "ml":return "ml-IN";
            //Marathi
            case "mr":return "mr-IN";
            //Dutch
            case "nl": return "nl-NL";
             //Nepali
            case "ne":return "ne-NP";
            //Norwerian
            case "nb":return "nb-NO";
           //Polish
            case "pl":return "pl-PL";
            //Portaguse
            case "pt": return "pt-BR";
             //Romanian
            case "ro":return "ro-RO";
            //Srilankan
            case "si":return "si-LK";
            //Slovak
            case "sk":return "sk-SK";
            //Slovanian
            case "sl":return "sl-SI";
            //Sunda
            case "su":return "su-ID";
            //swahali
            case "sw":return "sw-TZ";
            // Fannish
             case "fi":return "fi-FI";
             //Swedish
            case "sv":return "sv-SE";
            //Tamil
            case "ta":return "ta-IN";
            //Telughu
            case "te": return "te-IN";
            //Vietnamese
            case "vi":return "vi-VN";
            //Turkish
            case "tr":return "tr-TR";
            //Urdu
            case "ur":return "ur-PK";
            //Greek
            case "el":return "el-GR";
            //Bulgrain
            case "bg":return "bg-BG";
            //Russian
            case "ru":return "ru-RU";
            //Serbiam
            case "sr":return "sr-RS";
             //Ukrain
            case "uk": return "uk-UA";
            //Hebrew
            case "he":return "he-IL";

            // Hindi
            case "hi": return "hi-IN";
            //Arabic Local
            case "ar":
            case "bs":
            case "mk": return "ar-XA";
            //English
            case "en": return "en-GB";
            case "fil": return "fil-PH";
            // Fannish
            case "et": return "fi-FI";
            // french
            case "fr":return "fr-CA";

            case "id":
                return "id-ID";

            /// Ilatian Local
            case "it":
            case "sq":
            case "eo":
            case "la":
                return "it-IT";
                // Japanese
            case "ja": return "ja-JP";

            //Korean
            case "ko": return "ko-KR";
            //Chinese local
            case "zh-CN": case "zh-TW": return "cmn-CN";
            //Norwerian
            case "no": return "pl-PL";







            default:
                    return SPEECH; }





         }





}
