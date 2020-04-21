
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
    "value",
    "status",
    "risk",
    "prime"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Bmi {

    @JsonProperty("value")
    private String value;
    @JsonProperty("status")
    private String status;
    @JsonProperty("risk")
    private String risk;
    @JsonProperty("prime")
    private String prime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("risk")
    public String getRisk() {
        return risk;
    }

    @JsonProperty("risk")
    public void setRisk(String risk) {
        this.risk = risk;
    }

    @JsonProperty("prime")
    public String getPrime() {
        return prime;
    }

    @JsonProperty("prime")
    public void setPrime(String prime) {
        this.prime = prime;
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
