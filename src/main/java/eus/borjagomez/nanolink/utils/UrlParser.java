package eus.borjagomez.nanolink.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlParser {

    public static String removeUrlPath(String url) throws MalformedURLException {
        URL urlObject = new URL(url);
        return urlObject.getProtocol() + "://" + urlObject.getHost();
    }
}
