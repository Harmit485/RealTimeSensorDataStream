package kafka.consumer.StoreData.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_data")
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("scd_co2")
    private double scdCo2;

    @JsonProperty("scd_temp")
    private double scdTemp;

    @JsonProperty("scd_humidity")
    private double scdHumidity;

    @JsonProperty("dht_temp")
    private double dhtTemp;

    @JsonProperty("dht_humidity")
    private double dhtHumidity;

    private LocalDateTime timestamp;

    public SensorData() {
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getScdCo2() {
        return scdCo2;
    }

    public void setScdCo2(double scdCo2) {
        this.scdCo2 = scdCo2;
    }

    public double getScdTemp() {
        return scdTemp;
    }

    public void setScdTemp(double scdTemp) {
        this.scdTemp = scdTemp;
    }

    public double getScdHumidity() {
        return scdHumidity;
    }

    public void setScdHumidity(double scdHumidity) {
        this.scdHumidity = scdHumidity;
    }

    public double getDhtTemp() {
        return dhtTemp;
    }

    public void setDhtTemp(double dhtTemp) {
        this.dhtTemp = dhtTemp;
    }

    public double getDhtHumidity() {
        return dhtHumidity;
    }

    public void setDhtHumidity(double dhtHumidity) {
        this.dhtHumidity = dhtHumidity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "id=" + id +
                ", scdCo2=" + scdCo2 +
                ", scdTemp=" + scdTemp +
                ", scdHumidity=" + scdHumidity +
                ", dhtTemp=" + dhtTemp +
                ", dhtHumidity=" + dhtHumidity +
                ", timestamp=" + timestamp +
                '}';
    }
}
