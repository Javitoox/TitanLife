
package aiss.model.fatsecret;

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
    "food",
    "max_results",
    "page_number",
    "total_results"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Foods {

    @JsonProperty("food")
    private Food food;
    @JsonProperty("max_results")
    private String maxResults;
    @JsonProperty("page_number")
    private String pageNumber;
    @JsonProperty("total_results")
    private String totalResults;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("food")
    public Food getFood() {
        return food;
    }

    @JsonProperty("food")
    public void setFood(Food food) {
        this.food = food;
    }

    @JsonProperty("max_results")
    public String getMaxResults() {
        return maxResults;
    }

    @JsonProperty("max_results")
    public void setMaxResults(String maxResults) {
        this.maxResults = maxResults;
    }

    @JsonProperty("page_number")
    public String getPageNumber() {
        return pageNumber;
    }

    @JsonProperty("page_number")
    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    @JsonProperty("total_results")
    public String getTotalResults() {
        return totalResults;
    }

    @JsonProperty("total_results")
    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
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
