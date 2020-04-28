package aiss.utility;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Oauth1Utility {
	
	private static final String APP_KEY="6f5db4f8911e45adb1fdc22b4a879d9b";
	private static final String APP_SECRET="180a4ed480b244b3ae6cbabca19c6c76";
	private static final String APP_SIGNATURE_METHOD="HmacSHA1";
	
	private static String nonce() {
		Random r = new Random();
		StringBuffer n = new StringBuffer();
		for (int i = 0; i < r.nextInt(8) + 2; i++) {
			n.append(r.nextInt(26) + 'a');
		}
		return n.toString();
	}
	
	public static String[] generateOauthParams() {
		String[] a = {
				"oauth_consumer_key=" + APP_KEY,
				"oauth_signature_method=HMAC-SHA1",
				"oauth_timestamp=" + new Long(System.currentTimeMillis() / 1000).toString(),
				"oauth_nonce=" + nonce(),
				"oauth_version=1.0",
				"a=foo",
				"z=bar"
		};
		return a;
	}
	
	private static String join(String[] params, String separator) {
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < params.length; i++) {
			if (i > 0) {
				b.append(separator);
			}
			b.append(params[i]);
		}
		return b.toString();
	}

	
	public static String paramify(String[] params) {
		String[] p = Arrays.copyOf(params, params.length);
		Arrays.sort(p);
		return join(p, "&");
	}
	
	private static String encode(String url) {
		if (url == null)
			return "";

		try {
			return URLEncoder.encode(url, "utf-8")
					.replace("+", "%20")
					.replace("!", "%21")
					.replace("*", "%2A")
					.replace("\\", "%27")
					.replace("(", "%28")
					.replace(")", "%29");
		}
		catch (UnsupportedEncodingException wow) {
			throw new RuntimeException(wow.getMessage(), wow);
		}
	}
	
	public static String sign(String method, String uri, String[] params) throws UnsupportedEncodingException {
		String encodedURI = encode(uri);
		String encodedParams = encode(paramify(params));
		
		String[] p = {method, encodedURI, encodedParams};
		
		String text = join(p, "&");
		String key = APP_SECRET + "&";
		SecretKey sk = new SecretKeySpec(key.getBytes(), APP_SIGNATURE_METHOD);
		String sign = "";
		try {
			Mac m = Mac.getInstance(APP_SIGNATURE_METHOD);
			m.init(sk);
			sign = encode(new String(Base64.encode(m.doFinal(text.getBytes()), Base64.DEFAULT)).trim());
		} catch(java.security.NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException: " + e.getMessage());
		} catch(java.security.InvalidKeyException e) {
			System.out.println("InvalidKeyException: " + e.getMessage());
		}
		return sign;
	}
	
}
