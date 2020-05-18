package aiss.model.strava;

import java.util.HashMap;
import java.util.List;
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
    "external_id",
    "upload_id",
    "athlete",
    "name",
    "distance",
    "moving_time",
    "elapsed_time",
    "total_elevation_gain",
    "type",
    "start_date",
    "start_date_local",
    "timezone",
    "utc_offset",
    "achievement_count",
    "kudos_count",
    "comment_count",
    "athlete_count",
    "photo_count",
    "map",
    "trainer",
    "commute",
    "manual",
    "private",
    "flagged",
    "gear_id",
    "from_accepted_tag",
    "average_speed",
    "max_speed",
    "device_watts",
    "has_heartrate",
    "pr_count",
    "total_photo_count",
    "has_kudoed",
    "workout_type",
    "description",
    "calories",
    "segment_efforts"
})
@JsonIgnoreProperties(ignoreUnknown=true)

public class StravaActivity {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("resource_state")
    private Integer resourceState;
    @JsonProperty("external_id")
    private Object externalId;
    @JsonProperty("upload_id")
    private Object uploadId;
    @JsonProperty("athlete")
    private Athlete athlete;
    @JsonProperty("name")
    private String name;
    @JsonProperty("distance")
    private Integer distance;
    @JsonProperty("moving_time")
    private Integer movingTime;
    @JsonProperty("elapsed_time")
    private Integer elapsedTime;
    @JsonProperty("total_elevation_gain")
    private Integer totalElevationGain;
    @JsonProperty("type")
    private String type;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("start_date_local")
    private String startDateLocal;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("utc_offset")
    private Integer utcOffset;
    @JsonProperty("achievement_count")
    private Integer achievementCount;
    @JsonProperty("kudos_count")
    private Integer kudosCount;
    @JsonProperty("comment_count")
    private Integer commentCount;
    @JsonProperty("athlete_count")
    private Integer athleteCount;
    @JsonProperty("photo_count")
    private Integer photoCount;
    @JsonProperty("map")
    private aiss.model.strava.Map map;
    @JsonProperty("trainer")
    private Boolean trainer;
    @JsonProperty("commute")
    private Boolean commute;
    @JsonProperty("manual")
    private Boolean manual;
    @JsonProperty("private")
    private Boolean _private;
    @JsonProperty("flagged")
    private Boolean flagged;
    @JsonProperty("gear_id")
    private String gearId;
    @JsonProperty("from_accepted_tag")
    private Object fromAcceptedTag;
    @JsonProperty("average_speed")
    private Integer averageSpeed;
    @JsonProperty("max_speed")
    private Integer maxSpeed;
    @JsonProperty("device_watts")
    private Boolean deviceWatts;
    @JsonProperty("has_heartrate")
    private Boolean hasHeartrate;
    @JsonProperty("pr_count")
    private Integer prCount;
    @JsonProperty("total_photo_count")
    private Integer totalPhotoCount;
    @JsonProperty("has_kudoed")
    private Boolean hasKudoed;
    @JsonProperty("workout_type")
    private Object workoutType;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("calories")
    private Integer calories;
    @JsonProperty("segment_efforts")
    private List<Object> segmentEfforts = null;
    @JsonIgnore
    private java.util.Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
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

    @JsonProperty("external_id")
    public Object getExternalId() {
        return externalId;
    }

    @JsonProperty("external_id")
    public void setExternalId(Object externalId) {
        this.externalId = externalId;
    }

    @JsonProperty("upload_id")
    public Object getUploadId() {
        return uploadId;
    }

    @JsonProperty("upload_id")
    public void setUploadId(Object uploadId) {
        this.uploadId = uploadId;
    }

    @JsonProperty("athlete")
    public Athlete getAthlete() {
        return athlete;
    }

    @JsonProperty("athlete")
    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("distance")
    public Integer getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @JsonProperty("moving_time")
    public Integer getMovingTime() {
        return movingTime;
    }

    @JsonProperty("moving_time")
    public void setMovingTime(Integer movingTime) {
        this.movingTime = movingTime;
    }

    @JsonProperty("elapsed_time")
    public Integer getElapsedTime() {
        return elapsedTime;
    }

    @JsonProperty("elapsed_time")
    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    @JsonProperty("total_elevation_gain")
    public Integer getTotalElevationGain() {
        return totalElevationGain;
    }

    @JsonProperty("total_elevation_gain")
    public void setTotalElevationGain(Integer totalElevationGain) {
        this.totalElevationGain = totalElevationGain;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("utc_offset")
    public Integer getUtcOffset() {
        return utcOffset;
    }

    @JsonProperty("utc_offset")
    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    @JsonProperty("achievement_count")
    public Integer getAchievementCount() {
        return achievementCount;
    }

    @JsonProperty("achievement_count")
    public void setAchievementCount(Integer achievementCount) {
        this.achievementCount = achievementCount;
    }

    @JsonProperty("kudos_count")
    public Integer getKudosCount() {
        return kudosCount;
    }

    @JsonProperty("kudos_count")
    public void setKudosCount(Integer kudosCount) {
        this.kudosCount = kudosCount;
    }

    @JsonProperty("comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    @JsonProperty("comment_count")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @JsonProperty("athlete_count")
    public Integer getAthleteCount() {
        return athleteCount;
    }

    @JsonProperty("athlete_count")
    public void setAthleteCount(Integer athleteCount) {
        this.athleteCount = athleteCount;
    }

    @JsonProperty("photo_count")
    public Integer getPhotoCount() {
        return photoCount;
    }

    @JsonProperty("photo_count")
    public void setPhotoCount(Integer photoCount) {
        this.photoCount = photoCount;
    }

    @JsonProperty("map")
    public aiss.model.strava.Map getMap() {
        return map;
    }

    @JsonProperty("map")
    public void setMap(aiss.model.strava.Map map) {
        this.map = map;
    }

    @JsonProperty("trainer")
    public Boolean getTrainer() {
        return trainer;
    }

    @JsonProperty("trainer")
    public void setTrainer(Boolean trainer) {
        this.trainer = trainer;
    }

    @JsonProperty("commute")
    public Boolean getCommute() {
        return commute;
    }

    @JsonProperty("commute")
    public void setCommute(Boolean commute) {
        this.commute = commute;
    }

    @JsonProperty("manual")
    public Boolean getManual() {
        return manual;
    }

    @JsonProperty("manual")
    public void setManual(Boolean manual) {
        this.manual = manual;
    }

    @JsonProperty("private")
    public Boolean getPrivate() {
        return _private;
    }

    @JsonProperty("private")
    public void setPrivate(Boolean _private) {
        this._private = _private;
    }

    @JsonProperty("flagged")
    public Boolean getFlagged() {
        return flagged;
    }

    @JsonProperty("flagged")
    public void setFlagged(Boolean flagged) {
        this.flagged = flagged;
    }

    @JsonProperty("gear_id")
    public String getGearId() {
        return gearId;
    }

    @JsonProperty("gear_id")
    public void setGearId(String gearId) {
        this.gearId = gearId;
    }

    @JsonProperty("from_accepted_tag")
    public Object getFromAcceptedTag() {
        return fromAcceptedTag;
    }

    @JsonProperty("from_accepted_tag")
    public void setFromAcceptedTag(Object fromAcceptedTag) {
        this.fromAcceptedTag = fromAcceptedTag;
    }

    @JsonProperty("average_speed")
    public Integer getAverageSpeed() {
        return averageSpeed;
    }

    @JsonProperty("average_speed")
    public void setAverageSpeed(Integer averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    @JsonProperty("max_speed")
    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    @JsonProperty("max_speed")
    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @JsonProperty("device_watts")
    public Boolean getDeviceWatts() {
        return deviceWatts;
    }

    @JsonProperty("device_watts")
    public void setDeviceWatts(Boolean deviceWatts) {
        this.deviceWatts = deviceWatts;
    }

    @JsonProperty("has_heartrate")
    public Boolean getHasHeartrate() {
        return hasHeartrate;
    }

    @JsonProperty("has_heartrate")
    public void setHasHeartrate(Boolean hasHeartrate) {
        this.hasHeartrate = hasHeartrate;
    }

    @JsonProperty("pr_count")
    public Integer getPrCount() {
        return prCount;
    }

    @JsonProperty("pr_count")
    public void setPrCount(Integer prCount) {
        this.prCount = prCount;
    }

    @JsonProperty("total_photo_count")
    public Integer getTotalPhotoCount() {
        return totalPhotoCount;
    }

    @JsonProperty("total_photo_count")
    public void setTotalPhotoCount(Integer totalPhotoCount) {
        this.totalPhotoCount = totalPhotoCount;
    }

    @JsonProperty("has_kudoed")
    public Boolean getHasKudoed() {
        return hasKudoed;
    }

    @JsonProperty("has_kudoed")
    public void setHasKudoed(Boolean hasKudoed) {
        this.hasKudoed = hasKudoed;
    }

    @JsonProperty("workout_type")
    public Object getWorkoutType() {
        return workoutType;
    }

    @JsonProperty("workout_type")
    public void setWorkoutType(Object workoutType) {
        this.workoutType = workoutType;
    }

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    @JsonProperty("calories")
    public Integer getCalories() {
        return calories;
    }

    @JsonProperty("calories")
    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @JsonProperty("segment_efforts")
    public List<Object> getSegmentEfforts() {
        return segmentEfforts;
    }

    @JsonProperty("segment_efforts")
    public void setSegmentEfforts(List<Object> segmentEfforts) {
        this.segmentEfforts = segmentEfforts;
    }

    @JsonAnyGetter
    public java.util.Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
