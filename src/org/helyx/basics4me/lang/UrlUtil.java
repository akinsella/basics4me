package org.helyx.basics4me.lang;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

public class UrlUtil {
	
	private static final String HTTP_SCHEME = "http://";
	private static final String HTTPS_SCHEME = "https://";
	
	private static final String HTTP_HEADER_FIELD_USER_AGENT = "User-Agent";
	private static final String HTTP_HEADER_FIELD_LOCATION = "Location";
	
	private static final int HTTP_RESPONSE_CODE_MOVED_PERMANENTLY = 301;
	private static final int HTTP_HEADER_FIELD_FOUND = 302;
	private static final int HTTP_HEADER_FIELD_SEE_OTHER = 303;

	private static final String DEFAULT_USER_AGENT = "Profile/MIDP-2.0 Configuration/CLDC-1.1";

	private UrlUtil() {
		super();
	}
	
	public static InputStream openStream(String url) throws IOException {
		return openStream(url, DEFAULT_USER_AGENT);
	}
	
	public static InputStream openStream(String url, String userAgent) throws IOException {
		String urlToLowerCase = url.toLowerCase();
		if (urlToLowerCase.startsWith(HTTP_SCHEME) || urlToLowerCase.startsWith(HTTPS_SCHEME)) {
			HttpConnection httpConnection = (HttpConnection)Connector.open(url);
	        httpConnection.setRequestMethod(HttpConnection.GET);
	        httpConnection.setRequestProperty(HTTP_HEADER_FIELD_USER_AGENT, userAgent);
	        
	        int httpResponseCode = httpConnection.getResponseCode();
			if ( httpResponseCode == HTTP_RESPONSE_CODE_MOVED_PERMANENTLY || 
					httpResponseCode == HTTP_HEADER_FIELD_FOUND || 
					httpResponseCode == HTTP_HEADER_FIELD_SEE_OTHER ) {
				String urlRedirection = httpConnection.getHeaderField(HTTP_HEADER_FIELD_LOCATION);
				httpConnection.close();
				httpConnection = (HttpConnection)Connector.open(urlRedirection);
		        httpConnection.setRequestMethod(HttpConnection.GET);
		        httpConnection.setRequestProperty(HTTP_HEADER_FIELD_USER_AGENT, userAgent); 
			}		
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
