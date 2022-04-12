package com.home.aircraft.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.Instant;

@Data // Instructs Lombok to create getter, setter, equals(), hashCode(), and toString() methods, creating a so-called data class
@NoArgsConstructor // Instructs Lombok to create a zero-parameter constructor, thus requiring no arguments
@AllArgsConstructor // Instructs Lombok to create a constructor with a parameter for each member variable, requiring an argument be provided for all
@RedisHash // indicates that Aircraft is an aggregate root to be stored in a Redis hash, performing a function similar to what @Entity annotation does for JPA objects.
@JsonIgnoreProperties(ignoreUnknown = true) // Informs Jackson deserialization mechanisms to ignore fields within JSON responses for which there is no corresponding member variable
public class Aircraft {
    @Id // Designates the annotated member variable as holding the unique identifier for a database entry/record
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
}
