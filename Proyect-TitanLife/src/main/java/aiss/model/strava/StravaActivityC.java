
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
    "start_latlng",
    "end_latlng",
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
    "average_cadence",
    "average_temp",
    "average_watts",
    "weighted_average_watts",
    "kilojoules",
    "device_watts",
    "has_heartrate",
    "max_watts",
    "elev_high",
    "elev_low",
    "pr_count",
    "total_photo_count",
    "has_kudoed",
    "workout_type",
    "suffer_score",
    "description",
    "calories",
    "segment_efforts",
    "splits_metric",
    "laps",
    "gear",
    "partner_brand_tag",
    "photos",
    "highlighted_kudosers",
    "device_name",
    "embed_token",
    "segment_leaderboard_opt_out",
    "leaderboard_opt_out"
})
@JsonIgnoreProperties(ignoreUnknown=true)

public class StravaActivityC {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("resource_state")
    private Integer resourceState;
    @JsonProperty("external_id")
    private String externalId;
    @JsonProperty("upload_id")
    private Integer uploadId;
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
    @JsonProperty("start_latlng")
    private List<Double> startLatlng = null;
    @JsonProperty("end_latlng")
    private List<Double> endLatlng = null;
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
    private Boolean fromAcceptedTag;
    @JsonProperty("average_speed")
    private Double averageSpeed;
    @JsonProperty("max_speed")
    private Double maxSpeed;
    @JsonProperty("average_cadence")
    private Double averageCadence;
    @JsonProperty("average_temp")
    private Integer averageTemp;
    @JsonProperty("average_watts")
    private Double averageWatts;
    @JsonProperty("weighted_average_watts")
    private Integer weightedAverageWatts;
    @JsonProperty("kilojoules")
    private Double kilojoules;
    @JsonProperty("device_watts")
    private Boolean deviceWatts;
    @JsonProperty("has_heartrate")
    private Boolean hasHeartrate;
    @JsonProperty("max_watts")
    private Integer maxWatts;
    @JsonProperty("elev_high")
    private Double elevHigh;
    @JsonProperty("elev_low")
    private Double elevLow;
    @JsonProperty("pr_count")
    private Integer prCount;
    @JsonProperty("total_photo_count")
    private Integer totalPhotoCount;
    @JsonProperty("has_kudoed")
    private Boolean hasKudoed;
    @JsonProperty("workout_type")
    private Integer workoutType;
    @JsonProperty("suffer_score")
    private Object sufferScore;
    @JsonProperty("description")
    private String description;
    @JsonProperty("calories")
    private Double calories;
    @JsonProperty("segment_efforts")
    private List<SegmentEffort> segmentEfforts = null;
    @JsonProperty("splits_metric")
    private List<SplitsMetric> splitsMetric = null;
    @JsonProperty("laps")
    private List<Lap> laps = null;
    @JsonProperty("gear")
    private Gear gear;
    @JsonProperty("partner_brand_tag")
    private Object partnerBrandTag;
    @JsonProperty("photos")
    private Photos photos;
    @JsonProperty("highlighted_kudosers")
    private List<HighlightedKudoser> highlightedKudosers = null;
    @JsonProperty("device_name")
    private String deviceName;
    @JsonProperty("embed_token")
    private String embedToken;
    @JsonProperty("segment_leaderboard_opt_out")
    private Boolean segmentLeaderboardOptOut;
    @JsonProperty("leaderboard_opt_out")
    private Boolean leaderboardOptOut;
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
    public String getExternalId() {
        return externalId;
    }

    @JsonProperty("external_id")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @JsonProperty("upload_id")
    public Integer getUploadId() {
        return uploadId;
    }

    @JsonProperty("upload_id")
    public void setUploadId(Integer uploadId) {
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

    @JsonProperty("start_latlng")
    public List<Double> getStartLatlng() {
        return startLatlng;
    }

    @JsonProperty("start_latlng")
    public void setStartLatlng(List<Double> startLatlng) {
        this.startLatlng = startLatlng;
    }

    @JsonProperty("end_latlng")
    public List<Double> getEndLatlng() {
        return endLatlng;
    }

    @JsonProperty("end_latlng")
    public void setEndLatlng(List<Double> endLatlng) {
        this.endLatlng = endLatlng;
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
    public Boolean getFromAcceptedTag() {
        return fromAcceptedTag;
    }

    @JsonProperty("from_accepted_tag")
    public void setFromAcceptedTag(Boolean fromAcceptedTag) {
        this.fromAcceptedTag = fromAcceptedTag;
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

    @JsonProperty("average_temp")
    public Integer getAverageTemp() {
        return averageTemp;
    }

    @JsonProperty("average_temp")
    public void setAverageTemp(Integer averageTemp) {
        this.averageTemp = averageTemp;
    }

    @JsonProperty("average_watts")
    public Double getAverageWatts() {
        return averageWatts;
    }

    @JsonProperty("average_watts")
    public void setAverageWatts(Double averageWatts) {
        this.averageWatts = averageWatts;
    }

    @JsonProperty("weighted_average_watts")
    public Integer getWeightedAverageWatts() {
        return weightedAverageWatts;
    }

    @JsonProperty("weighted_average_watts")
    public void setWeightedAverageWatts(Integer weightedAverageWatts) {
        this.weightedAverageWatts = weightedAverageWatts;
    }

    @JsonProperty("kilojoules")
    public Double getKilojoules() {
        return kilojoules;
    }

    @JsonProperty("kilojoules")
    public void setKilojoules(Double kilojoules) {
        this.kilojoules = kilojoules;
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

    @JsonProperty("max_watts")
    public Integer getMaxWatts() {
        return maxWatts;
    }

    @JsonProperty("max_watts")
    public void setMaxWatts(Integer maxWatts) {
        this.maxWatts = maxWatts;
    }

    @JsonProperty("elev_high")
    public Double getElevHigh() {
        return elevHigh;
    }

    @JsonProperty("elev_high")
    public void setElevHigh(Double elevHigh) {
        this.elevHigh = elevHigh;
    }

    @JsonProperty("elev_low")
    public Double getElevLow() {
        return elevLow;
    }

    @JsonProperty("elev_low")
    public void setElevLow(Double elevLow) {
        this.elevLow = elevLow;
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
    public Integer getWorkoutType() {
        return workoutType;
    }

    @JsonProperty("workout_type")
    public void setWorkoutType(Integer workoutType) {
        this.workoutType = workoutType;
    }

    @JsonProperty("suffer_score")
    public Object getSufferScore() {
        return sufferScore;
    }

    @JsonProperty("suffer_score")
    public void setSufferScore(Object sufferScore) {
        this.sufferScore = sufferScore;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("calories")
    public Double getCalories() {
        return calories;
    }

    @JsonProperty("calories")
    public void setCalories(Double calories) {
        this.calories = calories;
    }

    @JsonProperty("segment_efforts")
    public List<SegmentEffort> getSegmentEfforts() {
        return segmentEfforts;
    }

    @JsonProperty("segment_efforts")
    public void setSegmentEfforts(List<SegmentEffort> segmentEfforts) {
        this.segmentEfforts = segmentEfforts;
    }

    @JsonProperty("splits_metric")
    public List<SplitsMetric> getSplitsMetric() {
        return splitsMetric;
    }

    @JsonProperty("splits_metric")
    public void setSplitsMetric(List<SplitsMetric> splitsMetric) {
        this.splitsMetric = splitsMetric;
    }

    @JsonProperty("laps")
    public List<Lap> getLaps() {
        return laps;
    }

    @JsonProperty("laps")
    public void setLaps(List<Lap> laps) {
        this.laps = laps;
    }

    @JsonProperty("gear")
    public Gear getGear() {
        return gear;
    }

    @JsonProperty("gear")
    public void setGear(Gear gear) {
        this.gear = gear;
    }

    @JsonProperty("partner_brand_tag")
    public Object getPartnerBrandTag() {
        return partnerBrandTag;
    }

    @JsonProperty("partner_brand_tag")
    public void setPartnerBrandTag(Object partnerBrandTag) {
        this.partnerBrandTag = partnerBrandTag;
    }

    @JsonProperty("photos")
    public Photos getPhotos() {
        return photos;
    }

    @JsonProperty("photos")
    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    @JsonProperty("highlighted_kudosers")
    public List<HighlightedKudoser> getHighlightedKudosers() {
        return highlightedKudosers;
    }

    @JsonProperty("highlighted_kudosers")
    public void setHighlightedKudosers(List<HighlightedKudoser> highlightedKudosers) {
        this.highlightedKudosers = highlightedKudosers;
    }

    @JsonProperty("device_name")
    public String getDeviceName() {
        return deviceName;
    }

    @JsonProperty("device_name")
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @JsonProperty("embed_token")
    public String getEmbedToken() {
        return embedToken;
    }

    @JsonProperty("embed_token")
    public void setEmbedToken(String embedToken) {
        this.embedToken = embedToken;
    }

    @JsonProperty("segment_leaderboard_opt_out")
    public Boolean getSegmentLeaderboardOptOut() {
        return segmentLeaderboardOptOut;
    }

    @JsonProperty("segment_leaderboard_opt_out")
    public void setSegmentLeaderboardOptOut(Boolean segmentLeaderboardOptOut) {
        this.segmentLeaderboardOptOut = segmentLeaderboardOptOut;
    }

    @JsonProperty("leaderboard_opt_out")
    public Boolean getLeaderboardOptOut() {
        return leaderboardOptOut;
    }

    @JsonProperty("leaderboard_opt_out")
    public void setLeaderboardOptOut(Boolean leaderboardOptOut) {
        this.leaderboardOptOut = leaderboardOptOut;
    }

    @JsonAnyGetter
    public java.util.Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_private == null) ? 0 : _private.hashCode());
		result = prime * result + ((achievementCount == null) ? 0 : achievementCount.hashCode());
		result = prime * result + ((additionalProperties == null) ? 0 : additionalProperties.hashCode());
		result = prime * result + ((athlete == null) ? 0 : athlete.hashCode());
		result = prime * result + ((athleteCount == null) ? 0 : athleteCount.hashCode());
		result = prime * result + ((averageCadence == null) ? 0 : averageCadence.hashCode());
		result = prime * result + ((averageSpeed == null) ? 0 : averageSpeed.hashCode());
		result = prime * result + ((averageTemp == null) ? 0 : averageTemp.hashCode());
		result = prime * result + ((averageWatts == null) ? 0 : averageWatts.hashCode());
		result = prime * result + ((calories == null) ? 0 : calories.hashCode());
		result = prime * result + ((commentCount == null) ? 0 : commentCount.hashCode());
		result = prime * result + ((commute == null) ? 0 : commute.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((deviceName == null) ? 0 : deviceName.hashCode());
		result = prime * result + ((deviceWatts == null) ? 0 : deviceWatts.hashCode());
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((elapsedTime == null) ? 0 : elapsedTime.hashCode());
		result = prime * result + ((elevHigh == null) ? 0 : elevHigh.hashCode());
		result = prime * result + ((elevLow == null) ? 0 : elevLow.hashCode());
		result = prime * result + ((embedToken == null) ? 0 : embedToken.hashCode());
		result = prime * result + ((endLatlng == null) ? 0 : endLatlng.hashCode());
		result = prime * result + ((externalId == null) ? 0 : externalId.hashCode());
		result = prime * result + ((flagged == null) ? 0 : flagged.hashCode());
		result = prime * result + ((fromAcceptedTag == null) ? 0 : fromAcceptedTag.hashCode());
		result = prime * result + ((gear == null) ? 0 : gear.hashCode());
		result = prime * result + ((gearId == null) ? 0 : gearId.hashCode());
		result = prime * result + ((hasHeartrate == null) ? 0 : hasHeartrate.hashCode());
		result = prime * result + ((hasKudoed == null) ? 0 : hasKudoed.hashCode());
		result = prime * result + ((highlightedKudosers == null) ? 0 : highlightedKudosers.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kilojoules == null) ? 0 : kilojoules.hashCode());
		result = prime * result + ((kudosCount == null) ? 0 : kudosCount.hashCode());
		result = prime * result + ((laps == null) ? 0 : laps.hashCode());
		result = prime * result + ((leaderboardOptOut == null) ? 0 : leaderboardOptOut.hashCode());
		result = prime * result + ((manual == null) ? 0 : manual.hashCode());
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		result = prime * result + ((maxSpeed == null) ? 0 : maxSpeed.hashCode());
		result = prime * result + ((maxWatts == null) ? 0 : maxWatts.hashCode());
		result = prime * result + ((movingTime == null) ? 0 : movingTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((partnerBrandTag == null) ? 0 : partnerBrandTag.hashCode());
		result = prime * result + ((photoCount == null) ? 0 : photoCount.hashCode());
		result = prime * result + ((photos == null) ? 0 : photos.hashCode());
		result = prime * result + ((prCount == null) ? 0 : prCount.hashCode());
		result = prime * result + ((resourceState == null) ? 0 : resourceState.hashCode());
		result = prime * result + ((segmentEfforts == null) ? 0 : segmentEfforts.hashCode());
		result = prime * result + ((segmentLeaderboardOptOut == null) ? 0 : segmentLeaderboardOptOut.hashCode());
		result = prime * result + ((splitsMetric == null) ? 0 : splitsMetric.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((startDateLocal == null) ? 0 : startDateLocal.hashCode());
		result = prime * result + ((startLatlng == null) ? 0 : startLatlng.hashCode());
		result = prime * result + ((sufferScore == null) ? 0 : sufferScore.hashCode());
		result = prime * result + ((timezone == null) ? 0 : timezone.hashCode());
		result = prime * result + ((totalElevationGain == null) ? 0 : totalElevationGain.hashCode());
		result = prime * result + ((totalPhotoCount == null) ? 0 : totalPhotoCount.hashCode());
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((uploadId == null) ? 0 : uploadId.hashCode());
		result = prime * result + ((utcOffset == null) ? 0 : utcOffset.hashCode());
		result = prime * result + ((weightedAverageWatts == null) ? 0 : weightedAverageWatts.hashCode());
		result = prime * result + ((workoutType == null) ? 0 : workoutType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StravaActivityC other = (StravaActivityC) obj;
		if (_private == null) {
			if (other._private != null)
				return false;
		} else if (!_private.equals(other._private))
			return false;
		if (achievementCount == null) {
			if (other.achievementCount != null)
				return false;
		} else if (!achievementCount.equals(other.achievementCount))
			return false;
		if (additionalProperties == null) {
			if (other.additionalProperties != null)
				return false;
		} else if (!additionalProperties.equals(other.additionalProperties))
			return false;
		if (athlete == null) {
			if (other.athlete != null)
				return false;
		} else if (!athlete.equals(other.athlete))
			return false;
		if (athleteCount == null) {
			if (other.athleteCount != null)
				return false;
		} else if (!athleteCount.equals(other.athleteCount))
			return false;
		if (averageCadence == null) {
			if (other.averageCadence != null)
				return false;
		} else if (!averageCadence.equals(other.averageCadence))
			return false;
		if (averageSpeed == null) {
			if (other.averageSpeed != null)
				return false;
		} else if (!averageSpeed.equals(other.averageSpeed))
			return false;
		if (averageTemp == null) {
			if (other.averageTemp != null)
				return false;
		} else if (!averageTemp.equals(other.averageTemp))
			return false;
		if (averageWatts == null) {
			if (other.averageWatts != null)
				return false;
		} else if (!averageWatts.equals(other.averageWatts))
			return false;
		if (calories == null) {
			if (other.calories != null)
				return false;
		} else if (!calories.equals(other.calories))
			return false;
		if (commentCount == null) {
			if (other.commentCount != null)
				return false;
		} else if (!commentCount.equals(other.commentCount))
			return false;
		if (commute == null) {
			if (other.commute != null)
				return false;
		} else if (!commute.equals(other.commute))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (deviceName == null) {
			if (other.deviceName != null)
				return false;
		} else if (!deviceName.equals(other.deviceName))
			return false;
		if (deviceWatts == null) {
			if (other.deviceWatts != null)
				return false;
		} else if (!deviceWatts.equals(other.deviceWatts))
			return false;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (elapsedTime == null) {
			if (other.elapsedTime != null)
				return false;
		} else if (!elapsedTime.equals(other.elapsedTime))
			return false;
		if (elevHigh == null) {
			if (other.elevHigh != null)
				return false;
		} else if (!elevHigh.equals(other.elevHigh))
			return false;
		if (elevLow == null) {
			if (other.elevLow != null)
				return false;
		} else if (!elevLow.equals(other.elevLow))
			return false;
		if (embedToken == null) {
			if (other.embedToken != null)
				return false;
		} else if (!embedToken.equals(other.embedToken))
			return false;
		if (endLatlng == null) {
			if (other.endLatlng != null)
				return false;
		} else if (!endLatlng.equals(other.endLatlng))
			return false;
		if (externalId == null) {
			if (other.externalId != null)
				return false;
		} else if (!externalId.equals(other.externalId))
			return false;
		if (flagged == null) {
			if (other.flagged != null)
				return false;
		} else if (!flagged.equals(other.flagged))
			return false;
		if (fromAcceptedTag == null) {
			if (other.fromAcceptedTag != null)
				return false;
		} else if (!fromAcceptedTag.equals(other.fromAcceptedTag))
			return false;
		if (gear == null) {
			if (other.gear != null)
				return false;
		} else if (!gear.equals(other.gear))
			return false;
		if (gearId == null) {
			if (other.gearId != null)
				return false;
		} else if (!gearId.equals(other.gearId))
			return false;
		if (hasHeartrate == null) {
			if (other.hasHeartrate != null)
				return false;
		} else if (!hasHeartrate.equals(other.hasHeartrate))
			return false;
		if (hasKudoed == null) {
			if (other.hasKudoed != null)
				return false;
		} else if (!hasKudoed.equals(other.hasKudoed))
			return false;
		if (highlightedKudosers == null) {
			if (other.highlightedKudosers != null)
				return false;
		} else if (!highlightedKudosers.equals(other.highlightedKudosers))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kilojoules == null) {
			if (other.kilojoules != null)
				return false;
		} else if (!kilojoules.equals(other.kilojoules))
			return false;
		if (kudosCount == null) {
			if (other.kudosCount != null)
				return false;
		} else if (!kudosCount.equals(other.kudosCount))
			return false;
		if (laps == null) {
			if (other.laps != null)
				return false;
		} else if (!laps.equals(other.laps))
			return false;
		if (leaderboardOptOut == null) {
			if (other.leaderboardOptOut != null)
				return false;
		} else if (!leaderboardOptOut.equals(other.leaderboardOptOut))
			return false;
		if (manual == null) {
			if (other.manual != null)
				return false;
		} else if (!manual.equals(other.manual))
			return false;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (maxSpeed == null) {
			if (other.maxSpeed != null)
				return false;
		} else if (!maxSpeed.equals(other.maxSpeed))
			return false;
		if (maxWatts == null) {
			if (other.maxWatts != null)
				return false;
		} else if (!maxWatts.equals(other.maxWatts))
			return false;
		if (movingTime == null) {
			if (other.movingTime != null)
				return false;
		} else if (!movingTime.equals(other.movingTime))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (partnerBrandTag == null) {
			if (other.partnerBrandTag != null)
				return false;
		} else if (!partnerBrandTag.equals(other.partnerBrandTag))
			return false;
		if (photoCount == null) {
			if (other.photoCount != null)
				return false;
		} else if (!photoCount.equals(other.photoCount))
			return false;
		if (photos == null) {
			if (other.photos != null)
				return false;
		} else if (!photos.equals(other.photos))
			return false;
		if (prCount == null) {
			if (other.prCount != null)
				return false;
		} else if (!prCount.equals(other.prCount))
			return false;
		if (resourceState == null) {
			if (other.resourceState != null)
				return false;
		} else if (!resourceState.equals(other.resourceState))
			return false;
		if (segmentEfforts == null) {
			if (other.segmentEfforts != null)
				return false;
		} else if (!segmentEfforts.equals(other.segmentEfforts))
			return false;
		if (segmentLeaderboardOptOut == null) {
			if (other.segmentLeaderboardOptOut != null)
				return false;
		} else if (!segmentLeaderboardOptOut.equals(other.segmentLeaderboardOptOut))
			return false;
		if (splitsMetric == null) {
			if (other.splitsMetric != null)
				return false;
		} else if (!splitsMetric.equals(other.splitsMetric))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (startDateLocal == null) {
			if (other.startDateLocal != null)
				return false;
		} else if (!startDateLocal.equals(other.startDateLocal))
			return false;
		if (startLatlng == null) {
			if (other.startLatlng != null)
				return false;
		} else if (!startLatlng.equals(other.startLatlng))
			return false;
		if (sufferScore == null) {
			if (other.sufferScore != null)
				return false;
		} else if (!sufferScore.equals(other.sufferScore))
			return false;
		if (timezone == null) {
			if (other.timezone != null)
				return false;
		} else if (!timezone.equals(other.timezone))
			return false;
		if (totalElevationGain == null) {
			if (other.totalElevationGain != null)
				return false;
		} else if (!totalElevationGain.equals(other.totalElevationGain))
			return false;
		if (totalPhotoCount == null) {
			if (other.totalPhotoCount != null)
				return false;
		} else if (!totalPhotoCount.equals(other.totalPhotoCount))
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (uploadId == null) {
			if (other.uploadId != null)
				return false;
		} else if (!uploadId.equals(other.uploadId))
			return false;
		if (utcOffset == null) {
			if (other.utcOffset != null)
				return false;
		} else if (!utcOffset.equals(other.utcOffset))
			return false;
		if (weightedAverageWatts == null) {
			if (other.weightedAverageWatts != null)
				return false;
		} else if (!weightedAverageWatts.equals(other.weightedAverageWatts))
			return false;
		if (workoutType == null) {
			if (other.workoutType != null)
				return false;
		} else if (!workoutType.equals(other.workoutType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name+photos;
	}
    

}
