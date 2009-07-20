package org.helyx.basics4me.lang;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

public class UrlUtil {
	
	private static final String HTTP = "http://";

	private UrlUtil() {
		super();
	}
	
	public static InputStream openStream(String url) throws IOException {
		return openStream(url, "Profile/MIDP-2.0 Configuration/CLDC-1.1");
	}
	
	public static InputStream openStream(String url, String userAgent) throws IOException {
		if (url.startsWith(HTTP)) {
			HttpConnection httpConnection = (HttpConnection)Connector.open(url);
	        httpConnection.setRequestMethod(HttpConnection.GET);
	        httpConnection.setRequestProperty("User-Agent", userAgent);
	        
			if (httpConnection.getResponseCode() != HttpConnection.HTTP_OK) {
			    throw new IOException(httpConnection.getResponseMessage());		 
			}		

			InputStream inputStream = httpConnection.openInputStream();
			return inputStream;
		}
		
		InputStream inputStream = UrlUtil.class.getResourceAsStream(url);
		return inputStream;
	}
	
}
