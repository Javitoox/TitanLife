
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
    "primary",
    "use_primary_photo",
    "count"
})
@JsonIgnoreProperties(ignoreUnknown=true)

public class Photos {

    @JsonProperty("primary")
    private Primary primary;
    @JsonProperty("use_primary_photo")
    private Boolean usePrimaryPhoto;
    @JsonProperty("count")
    private Integer count;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("primary")
    public Primary getPrimary() {
        return primary;
    }

    @JsonProperty("primary")
    public void setPrimary(Primary primary) {
        this.primary = primary;
    }

    @JsonProperty("use_primary_photo")
    public Boolean getUsePrimaryPhoto() {
        return usePrimaryPhoto;
    }

    @JsonProperty("use_primary_photo")
    public void setUsePrimaryPhoto(Boolean usePrimaryPhoto) {
        this.usePrimaryPhoto = usePrimaryPhoto;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
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
