package kafka.consumer.StoreData.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kafka.consumer.StoreData.Model.SensorData;
import kafka.consumer.StoreData.Repo.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaConsumerService {

    @Autowired
    private SensorDataRepository repository;

    private final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = "mqtt_data_topic", groupId = "mqtt-data-group-2")
    public void consume(String message) {
        try {
            SensorData data = mapper.readValue(message, SensorData.class);
            data.setTimestamp(LocalDateTime.now());
            repository.save(data);
            System.out.println("✅ Saved to PostgreSQL: " + data);
        } catch (Exception e) {
            System.err.println("❌ Failed to process message: " + message);
            e.printStackTrace();
        }
    }

    public void deleteAllSensorData() {
        repository.deleteAll();
        System.out.println("🗑️ All sensor data deleted from PostgreSQL.");
    }
}