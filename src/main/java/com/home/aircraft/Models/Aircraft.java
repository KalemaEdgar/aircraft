package com.home.aircraft.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Data // Instructs Lombok to create getter, setter, equals(), hashCode(), and toString() methods, creating a so-called data class
@NoArgsConstructor // Instructs Lombok to create a zero-parameter constructor, thus requiring no arguments
@AllArgsConstructor // Instructs Lombok to create a constructor with a parameter for each member variable, requiring an argument be provided for all
@JsonIgnoreProperties(ignoreUnknown = true) // Informs Jackson deserialization mechanisms to ignore fields within JSON responses for which there is no corresponding member variable
public class Aircraft {
    @Id // Designates the annotated member variable as holding the unique identifier for a database entry/record
    @GeneratedValue // indicates that the identifier will be generated by the underlying database engine
    private Long id;

    private String callSign, squawk, reg, flightno, route, type, category;
    private int altitude, heading, speed;
    private double lat, lon, barometer;

    @JsonProperty("vert_rate") // Connects a member variable with its differently named JSON field
    private int vertRate;

    @JsonProperty("selected_altitude")
    private int selectedAltitude;

    @JsonProperty("polar_distance")
    private double polarDistance;

    @JsonProperty("polar_bearing")
    private double polarBearing;

    @JsonProperty("is_adsb")
    private boolean isADSB;

    @JsonProperty("is_on_ground")
    private boolean isOnGround;

    @JsonProperty("last_seen_time")
    private Instant lastSeenTime;

    @JsonProperty("pos_update_time")
    private Instant posUpdateTime;

    @JsonProperty("bds40_seen_time")
    private Instant bds40SeenTime;

    public Aircraft(String callSign, String reg, String flightno, String type, int altitude, int heading, int speed, double lat, double lon) {
        this(null, callSign, "sqwk", reg, flightno, "route", type, "ct",
            altitude, heading, speed, 0, 0,
            lat, (int) lon, (int) 0D, 0D, 0D,
            false, true,
            Instant.now(), Instant.now(), Instant.now());
    }

    public void setLastSeenTime(long lastSeenTime) {
        this.lastSeenTime = Instant.ofEpochSecond(lastSeenTime);
    }

    public void setPosUpdateTime(long posUpdateTime) {
        this.posUpdateTime = Instant.ofEpochSecond(posUpdateTime);
    }

    public void setBds40SeenTime(long bds40SeenTime) {
        this.bds40SeenTime = Instant.ofEpochSecond(bds40SeenTime);
    }
}
