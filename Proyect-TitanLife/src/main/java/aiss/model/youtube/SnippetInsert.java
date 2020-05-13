
package aiss.model.youtube;

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
    "playlistId",
    "resourceId"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class SnippetInsert {

    @JsonProperty("playlistId")
    private String playlistId;
    @JsonProperty("resourceId")
    private ResourceIdInsert resourceId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("playlistId")
    public String getPlaylistId() {
        return playlistId;
    }

    @JsonProperty("playlistId")
    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    @JsonProperty("resourceId")
    public ResourceIdInsert getResourceId() {
        return resourceId;
    }

    @JsonProperty("resourceId")
    public void setResourceId(ResourceIdInsert resourceId) {
        this.resourceId = resourceId;
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
