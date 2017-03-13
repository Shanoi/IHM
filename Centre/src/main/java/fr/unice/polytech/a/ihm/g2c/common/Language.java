package fr.unice.polytech.a.ihm.g2c.common;

import java.util.Locale;

/**
 * Created by Jeremy on 12/03/2017.
 */
public enum Language {

    FR(new Locale("fr", "FR"), "/images/fr.png", null),
    EN(new Locale("en", "US"), "/images/uk.png", FR);

    static {
        FR.next = EN;
    }

    private final Locale locale;
    private final String imgPath;
    private Language next;

    Language(Locale locale, String imgPath,  Language next) {
        this.locale = locale;
        this.imgPath = imgPath;
        this.next = next;
    }

    public Locale getLocale() {
        return locale;
    }

    public Language getNext() {
        return next;
    }

    public String getImgPath() {
        return imgPath;
    }
}
