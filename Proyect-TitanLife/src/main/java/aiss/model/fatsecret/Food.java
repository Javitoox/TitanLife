
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
    "food_description",
    "food_id",
    "food_name",
    "food_type",
    "food_url"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Food {

    @JsonProperty("food_description")
    private String foodDescription;
    @JsonProperty("food_id")
    private String foodId;
    @JsonProperty("food_name")
    private String foodName;
    @JsonProperty("food_type")
    private String foodType;
    @JsonProperty("food_url")
    private String foodUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("food_description")
    public String getFoodDescription() {
        return foodDescription;
    }

    @JsonProperty("food_description")
    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    @JsonProperty("food_id")
    public String getFoodId() {
        return foodId;
    }

    @JsonProperty("food_id")
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    @JsonProperty("food_name")
    public String getFoodName() {
        return foodName;
    }

    @JsonProperty("food_name")
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @JsonProperty("food_type")
    public String getFoodType() {
        return foodType;
    }

    @JsonProperty("food_type")
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @JsonProperty("food_url")
    public String getFoodUrl() {
        return foodUrl;
    }

    @JsonProperty("food_url")
    public void setFoodUrl(String foodUrl) {
        this.foodUrl = foodUrl;
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
