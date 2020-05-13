
package aiss.model.strava;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "100",
    "600"
})
@JsonIgnoreProperties(ignoreUnknown=true)

public class Urls {

    @JsonProperty("100")
    private String _100;
    @JsonProperty("600")
    private String _600;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("100")
    public String get100() {
        return _100;
    }

    @JsonProperty("100")
    public void set100(String _100) {
        this._100 = _100;
    }

    @JsonProperty("600")
    public String get600() {
        return _600;
    }

    @JsonProperty("600")
    public void set600(String _600) {
        this._600 = _600;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
