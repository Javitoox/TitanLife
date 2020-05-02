
package aiss.model.titan;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "weight",
    "height",
    "sex",
    "age",
    "waist",
    "hip"
})
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class DataBMI implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("weight")
    private Weight weight;
    @JsonProperty("height")
    private Height height;
    @JsonProperty("sex")
    private String sex;
    @JsonProperty("age")
    private String age;
    @JsonProperty("waist")
    private String waist;
    @JsonProperty("hip")
    private String hip;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("weight")
    public Weight getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    @JsonProperty("height")
    public Height getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Height height) {
        this.height = height;
    }

    @JsonProperty("sex")
    public String getSex() {
        return sex;
    }

    @JsonProperty("sex")
    public void setSex(String sex) {
        this.sex = sex;
    }

    @JsonProperty("age")
    public String getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(String age) {
        this.age = age;
    }

    @JsonProperty("waist")
    public String getWaist() {
        return waist;
    }

    @JsonProperty("waist")
    public void setWaist(String waist) {
        this.waist = waist;
    }

    @JsonProperty("hip")
    public String getHip() {
        return hip;
    }

    @JsonProperty("hip")
    public void setHip(String hip) {
        this.hip = hip;
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
