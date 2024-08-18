package eus.borjagomez.nanolink.utils;

import java.net.MalformedURLException;
import java.net.URI;

public class UrlValidator {

    private UrlValidator() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isValidURL(String url) {
        try {
            URI.create(url).toURL();
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
