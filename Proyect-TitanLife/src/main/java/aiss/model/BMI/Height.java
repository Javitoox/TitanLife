
package aiss.model.BMI;

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
    "m",
    "cm",
    "in",
    "ft-in"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Height {

    @JsonProperty("m")
    private String m;
    @JsonProperty("cm")
    private String cm;
    @JsonProperty("in")
    private String in;
    @JsonProperty("ft-in")
    private String ftIn;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("m")
    public String getM() {
        return m;
    }

    @JsonProperty("m")
    public void setM(String m) {
        this.m = m;
    }

    @JsonProperty("cm")
    public String getCm() {
        return cm;
    }

    @JsonProperty("cm")
    public void setCm(String cm) {
        this.cm = cm;
    }

    @JsonProperty("in")
    public String getIn() {
        return in;
    }

    @JsonProperty("in")
    public void setIn(String in) {
        this.in = in;
    }

    @JsonProperty("ft-in")
    public String getFtIn() {
        return ftIn;
    }

    @JsonProperty("ft-in")
    public void setFtIn(String ftIn) {
        this.ftIn = ftIn;
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
