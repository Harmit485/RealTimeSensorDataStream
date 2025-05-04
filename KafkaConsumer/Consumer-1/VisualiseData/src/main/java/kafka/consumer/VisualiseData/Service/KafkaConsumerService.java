package kafka.consumer.VisualiseData.Service;

import kafka.consumer.VisualiseData.Model.SensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumerService {

    @Autowired
    private SimpMessagingTemplate template;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "mqtt_data_topic", groupId = "mqtt-data-group-1")
    public void listen(String message) {
        try {
            // Print raw message
            System.out.println("Received Kafka Message: " + message);

            // Deserialize JSON into SensorData object
            SensorData data = objectMapper.readValue(message, SensorData.class);

            // Send to WebSocket
            template.convertAndSend("/topic/sensor", data);

            // Print parsed object
            System.out.println("Parsed and Sent to WebSocket: " + data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
