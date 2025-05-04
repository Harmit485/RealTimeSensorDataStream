package kafka.producer.GetMQTT_SendKafka.Service;

import kafka.producer.GetMQTT_SendKafka.Config.SSLSocketFactoryGenerator;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MQTTSubscriberService {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    private static final String BROKER = "ssl://3c60290cbcc044c5ace36af08b6b8ee2.s1.eu.hivemq.cloud:8883";
    private static final String CLIENT_ID = "spring-boot-client";
    private static final String USERNAME = "harmit";
    private static final String PASSWORD = "Harmit*123";
    private static final String TOPIC = "temp/data";

    @PostConstruct
    public void subscribe() {
        try {
            MqttClient client = new MqttClient(BROKER, CLIENT_ID, new MemoryPersistence());

            MqttConnectOptions options = new MqttConnectOptions();
            options.setUserName(USERNAME);
            options.setPassword(PASSWORD.toCharArray());
            options.setSocketFactory(SSLSocketFactoryGenerator.getSocketFactory());

            client.connect(options);
            System.out.println("Connected to MQTT broker");

            client.subscribe(TOPIC, (topic, message) -> {
                String payload = new String(message.getPayload());
                System.out.println("Received message: " + payload);
                kafkaProducerService.sendMessage(payload);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
