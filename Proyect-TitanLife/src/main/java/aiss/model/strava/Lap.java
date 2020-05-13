
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
    "id",
    "resource_state",
    "name",
    "activity",
    "athlete",
    "elapsed_time",
    "moving_time",
    "start_date",
    "start_date_local",
    "distance",
    "start_index",
    "end_index",
    "total_elevation_gain",
    "average_speed",
    "max_speed",
    "average_cadence",
    "device_watts",
    "average_watts",
    "lap_index",
    "split"
})
@JsonIgnoreProperties(ignoreUnknown=true)

public class Lap {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("resource_state")
    private Integer resourceState;
    @JsonProperty("name")
    private String name;
    @JsonProperty("activity")
    private Activity_ activity;
    @JsonProperty("athlete")
    private Athlete__ athlete;
    @JsonProperty("elapsed_time")
    private Integer elapsedTime;
    @JsonProperty("moving_time")
    private Integer movingTime;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("start_date_local")
    private String startDateLocal;
    @JsonProperty("distance")
    private Double distance;
    @JsonProperty("start_index")
    private Integer startIndex;
    @JsonProperty("end_index")
    private Integer endIndex;
    @JsonProperty("total_elevation_gain")
    private Integer totalElevationGain;
    @JsonProperty("average_speed")
    private Double averageSpeed;
    @JsonProperty("max_speed")
    private Double maxSpeed;
    @JsonProperty("average_cadence")
    private Double averageCadence;
    @JsonProperty("device_watts")
    private Boolean deviceWatts;
    @JsonProperty("average_watts")
    private Double averageWatts;
    @JsonProperty("lap_index")
    private Integer lapIndex;
    @JsonProperty("split")
    private Integer split;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("resource_state")
    public Integer getResourceState() {
        return resourceState;
    }

    @JsonProperty("resource_state")
    public void setResourceState(Integer resourceState) {
        this.resourceState = resourceState;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("activity")
    public Activity_ getActivity() {
        return activity;
    }

    @JsonProperty("activity")
    public void setActivity(Activity_ activity) {
        this.activity = activity;
    }

    @JsonProperty("athlete")
    public Athlete__ getAthlete() {
        return athlete;
    }

    @JsonProperty("athlete")
    public void setAthlete(Athlete__ athlete) {
        this.athlete = athlete;
    }

    @JsonProperty("elapsed_time")
    public Integer getElapsedTime() {
        return elapsedTime;
    }

    @JsonProperty("elapsed_time")
    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    @JsonProperty("moving_time")
    public Integer getMovingTime() {
        return movingTime;
    }

    @JsonProperty("moving_time")
    public void setMovingTime(Integer movingTime) {
        this.movingTime = movingTime;
    }

    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("start_date_local")
    public String getStartDateLocal() {
        return startDateLocal;
    }

    @JsonProperty("start_date_local")
    public void setStartDateLocal(String startDateLocal) {
        this.startDateLocal = startDateLocal;
    }

    @JsonProperty("distance")
    public Double getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @JsonProperty("start_index")
    public Integer getStartIndex() {
        return startIndex;
    }

    @JsonProperty("start_index")
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    @JsonProperty("end_index")
    public Integer getEndIndex() {
        return endIndex;
    }

    @JsonProperty("end_index")
    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    @JsonProperty("total_elevation_gain")
    public Integer getTotalElevationGain() {
        return totalElevationGain;
    }

    @JsonProperty("total_elevation_gain")
    public void setTotalElevationGain(Integer totalElevationGain) {
        this.totalElevationGain = totalElevationGain;
    }

    @JsonProperty("average_speed")
    public Double getAverageSpeed() {
        return averageSpeed;
    }

    @JsonProperty("average_speed")
    public void setAverageSpeed(Double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    @JsonProperty("max_speed")
    public Double getMaxSpeed() {
        return maxSpeed;
    }

    @JsonProperty("max_speed")
    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @JsonProperty("average_cadence")
    public Double getAverageCadence() {
        return averageCadence;
    }

    @JsonProperty("average_cadence")
    public void setAverageCadence(Double averageCadence) {
        this.averageCadence = averageCadence;
    }

    @JsonProperty("device_watts")
    public Boolean getDeviceWatts() {
        return deviceWatts;
    }

    @JsonProperty("device_watts")
    public void setDeviceWatts(Boolean deviceWatts) {
        this.deviceWatts = deviceWatts;
    }

    @JsonProperty("average_watts")
    public Double getAverageWatts() {
        return averageWatts;
    }

    @JsonProperty("average_watts")
    public void setAverageWatts(Double averageWatts) {
        this.averageWatts = averageWatts;
    }

    @JsonProperty("lap_index")
    public Integer getLapIndex() {
        return lapIndex;
    }

    @JsonProperty("lap_index")
    public void setLapIndex(Integer lapIndex) {
        this.lapIndex = lapIndex;
    }

    @JsonProperty("split")
    public Integer getSplit() {
        return split;
    }

    @JsonProperty("split")
    public void setSplit(Integer split) {
        this.split = split;
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
