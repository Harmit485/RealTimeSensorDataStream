package kafka.consumer.MakeDecision.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = "mqtt_data_topic", groupId = "mqtt-data-group-3")
    public void consume(String message) {
        try {
            JsonNode node = mapper.readTree(message);

            double scdCo2 = node.get("scd_co2").asDouble();
            double scdTemp = node.get("scd_temp").asDouble();
            double scdHumidity = node.get("scd_humidity").asDouble();
            double dhtTemp = node.get("dht_temp").asDouble();
            double dhtHumidity = node.get("dht_humidity").asDouble();

            double avgTemp = (scdTemp + dhtTemp) / 2.0;
            double avgHumidity = (scdHumidity + dhtHumidity) / 2.0;

            // Decision logic
            if (scdCo2 > 1200) {
                System.out.println("⚠️ CO₂ high: Open windows or turn on exhaust fan");
            }

            if (avgTemp > 28.0) {
                System.out.println("🌡️ High temp: Turn on fan or AC");
            }
            else if (avgTemp < 20.0) {
                System.out.println("🥶 Low temp: Consider heater use (esp. in North India)");
            }

            if (avgHumidity < 35.0) {
                System.out.println("💧 Dry air: Use humidifier");
            }
            else if (avgHumidity > 65.0) {
                System.out.println("💦 High humidity: Use ventilation/dehumidifier");
            }

        } catch (Exception e) {
            System.err.println("❌ Error processing message: " + e.getMessage());
        }
    }
}
