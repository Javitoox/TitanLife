
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
    "kg",
    "lb"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Weight {

    @JsonProperty("kg")
    private String kg;
    @JsonProperty("lb")
    private String lb;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("kg")
    public String getKg() {
        return kg;
    }

    @JsonProperty("kg")
    public void setKg(String kg) {
        this.kg = kg;
    }

    @JsonProperty("lb")
    public String getLb() {
        return lb;
    }

    @JsonProperty("lb")
    public void setLb(String lb) {
        this.lb = lb;
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
