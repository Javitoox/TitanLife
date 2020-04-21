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
    "weight",
    "height",
    "bmi",
    "ideal_weight",
    "surface_area",
    "ponderal_index",
    "bmr",
    "whr",
    "whtr"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class BMIResult {

    @JsonProperty("weight")
    private Weight weight;
    @JsonProperty("height")
    private Height height;
    @JsonProperty("bmi")
    private Bmi bmi;
    @JsonProperty("ideal_weight")
    private String idealWeight;
    @JsonProperty("surface_area")
    private String surfaceArea;
    @JsonProperty("ponderal_index")
    private String ponderalIndex;
    @JsonProperty("bmr")
    private Bmr bmr;
    @JsonProperty("whr")
    private Whr whr;
    @JsonProperty("whtr")
    private Whtr whtr;
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

    @JsonProperty("bmi")
    public Bmi getBmi() {
        return bmi;
    }

    @JsonProperty("bmi")
    public void setBmi(Bmi bmi) {
        this.bmi = bmi;
    }

    @JsonProperty("ideal_weight")
    public String getIdealWeight() {
        return idealWeight;
    }

    @JsonProperty("ideal_weight")
    public void setIdealWeight(String idealWeight) {
        this.idealWeight = idealWeight;
    }

    @JsonProperty("surface_area")
    public String getSurfaceArea() {
        return surfaceArea;
    }

    @JsonProperty("surface_area")
    public void setSurfaceArea(String surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    @JsonProperty("ponderal_index")
    public String getPonderalIndex() {
        return ponderalIndex;
    }

    @JsonProperty("ponderal_index")
    public void setPonderalIndex(String ponderalIndex) {
        this.ponderalIndex = ponderalIndex;
    }

    @JsonProperty("bmr")
    public Bmr getBmr() {
        return bmr;
    }

    @JsonProperty("bmr")
    public void setBmr(Bmr bmr) {
        this.bmr = bmr;
    }

    @JsonProperty("whr")
    public Whr getWhr() {
        return whr;
    }

    @JsonProperty("whr")
    public void setWhr(Whr whr) {
        this.whr = whr;
    }

    @JsonProperty("whtr")
    public Whtr getWhtr() {
        return whtr;
    }

    @JsonProperty("whtr")
    public void setWhtr(Whtr whtr) {
        this.whtr = whtr;
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

