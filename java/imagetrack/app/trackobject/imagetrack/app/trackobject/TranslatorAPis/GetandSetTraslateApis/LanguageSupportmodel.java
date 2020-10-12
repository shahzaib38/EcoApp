package imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis;

public final class LanguageSupportmodel {



    private String name;

    public String getName() {
        return name;
    }

    public String getLanguageKey() {
        return LanguageKey;
    }

    private String LanguageKey ;

    public LanguageSupportmodel(String name, String languageKey, String imageSupport) {
        this.name = name;
        LanguageKey = languageKey;
        ImageSupport = imageSupport;
    }

    public String getImageSupport() {
        return ImageSupport;
    }

    private String ImageSupport;








}
