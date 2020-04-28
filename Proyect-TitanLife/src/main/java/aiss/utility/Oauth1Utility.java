package aiss.utility;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class Oauth1Utility {
	
	private static final String APP_KEY="6f5db4f8911e45adb1fdc22b4a879d9b";
	private static final String APP_SECRET="180a4ed480b244b3ae6cbabca19c6c76";
	private static final String APP_SIGNATURE_METHOD="HmacSHA1";
	private static final String CALLBACK="http://localhost:8090/oauth1Controller/FatSecret";
	
	private static String getSignature(String url, String params) throws UnsupportedEncodingException, NoSuchAlgorithmException,
            InvalidKeyException {
        StringBuilder base = new StringBuilder();
        base.append("GET&");
        base.append(url);
        base.append("&");
        base.append(params);
        System.out.println("String for oauth_signature generation:" + base);
        
        byte[] keyBytes = (APP_SECRET + "&").getBytes("UTF-8");

        SecretKey key = new SecretKeySpec(keyBytes, APP_SIGNATURE_METHOD);

        Mac mac = Mac.getInstance(APP_SIGNATURE_METHOD);
        mac.init(key);

        Base64 base64 = new Base64();
        return new String(base64.encode(mac.doFinal(base.toString().getBytes(
        		"UTF-8"))), "UTF-8").trim();
    }
	
	public static String generateRequest() throws InvalidKeyException, UnsupportedEncodingException,
	NoSuchAlgorithmException, URISyntaxException {
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();
        qparams.add(new BasicNameValuePair("oauth_consumer_key", APP_KEY));
        qparams.add(new BasicNameValuePair("oauth_signature_method",
                "HMAC-SHA1"));
        qparams.add(new BasicNameValuePair("oauth_timestamp", ""
                + (System.currentTimeMillis() / 1000)));
        qparams.add(new BasicNameValuePair("oauth_nonce", ""
                + (int) (Math.random() * 100000000)));
        qparams.add(new BasicNameValuePair("oauth_version", "1.0"));
        qparams.add(new BasicNameValuePair("oauth_callback", CALLBACK));
        
        String signature = getSignature(URLEncoder.encode(
        		"https://www.fatsecret.com/oauth/request_token", "UTF-8"),
                URLEncoder.encode(URLEncodedUtils.format(qparams, "UTF-8"), "UTF-8"));
        
        qparams.add(new BasicNameValuePair("oauth_signature", signature));
        
        URI uri = URIUtils.createURI("https", "www.fatsecret.com", -1,
                "/oauth/request_token",
                URLEncodedUtils.format(qparams, "UTF-8"), null);
        
        return uri.toString();
	}
	
}