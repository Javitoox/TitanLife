
package aiss.model.fatsecret;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "oauth_consumer_key",
    "oauth_signature_method",
    "oauth_timestamp",
    "oauth_nonce",
    "oauth_version",
    "oauth_callback",
    "oauth_signature"
})
public class NormalizedParameters {

    @JsonProperty("oauth_consumer_key")
    private String oauthConsumerKey;
    @JsonProperty("oauth_signature_method")
    private String oauthSignatureMethod;
    @JsonProperty("oauth_timestamp")
    private String oauthTimestamp;
    @JsonProperty("oauth_nonce")
    private String oauthNonce;
    @JsonProperty("oauth_version")
    private String oauthVersion;
    @JsonProperty("oauth_callback")
    private String oauthCallback;
    @JsonProperty("oauth_signature")
    private String oauthSignature;

    @JsonProperty("oauth_consumer_key")
    public String getOauthConsumerKey() {
        return oauthConsumerKey;
    }

    @JsonProperty("oauth_consumer_key")
    public void setOauthConsumerKey(String oauthConsumerKey) {
        this.oauthConsumerKey = oauthConsumerKey;
    }

    @JsonProperty("oauth_signature_method")
    public String getOauthSignatureMethod() {
        return oauthSignatureMethod;
    }

    @JsonProperty("oauth_signature_method")
    public void setOauthSignatureMethod(String oauthSignatureMethod) {
        this.oauthSignatureMethod = oauthSignatureMethod;
    }

    @JsonProperty("oauth_timestamp")
    public String getOauthTimestamp() {
        return oauthTimestamp;
    }

    @JsonProperty("oauth_timestamp")
    public void setOauthTimestamp(String oauthTimestamp) {
        this.oauthTimestamp = oauthTimestamp;
    }

    @JsonProperty("oauth_nonce")
    public String getOauthNonce() {
        return oauthNonce;
    }

    @JsonProperty("oauth_nonce")
    public void setOauthNonce(String oauthNonce) {
        this.oauthNonce = oauthNonce;
    }

    @JsonProperty("oauth_version")
    public String getOauthVersion() {
        return oauthVersion;
    }

    @JsonProperty("oauth_version")
    public void setOauthVersion(String oauthVersion) {
        this.oauthVersion = oauthVersion;
    }

    @JsonProperty("oauth_callback")
    public String getOauthCallback() {
        return oauthCallback;
    }

    @JsonProperty("oauth_callback")
    public void setOauthCallback(String oauthCallback) {
        this.oauthCallback = oauthCallback;
    }
    
    @JsonProperty("oauth_signature")
    public String getOauthSignature() {
        return oauthSignature;
    }

    @JsonProperty("oauth_signature")
    public void setOauthSignature(String oauthSignature) {
        this.oauthSignature = oauthSignature;
    }

}
