# Real-Time Sensor Data Streaming using MQTT, Kafka & Spring Boot

## 📌 Overview

A mini-project built for real-time streaming, processing, and visualization of IoT sensor data. Using **ESP32**, **MQTT**, **Apache Kafka**, and **Spring Boot**, this system creates a scalable and modular architecture for smart data collection, decision making, and feedback in real-time.

> Developed as part of B.Tech Mini Project (PC406) under the mentorship of **Prof. Tapas Kumar Maiti**

## 👥 Contributors

- **Nishank Kansara** (202201227)
- **Harmit Khimani** (202201231)

---

## 🚀 Objectives

- Mitigate delay in identifying issues from sensor data.
- Enable real-time monitoring and automated decision making.
- Build a fault-tolerant, scalable, and modular IoT data pipeline.
- Support smart feedback, visualization, and data storage for analytics.

---

## 🛠️ Tech Stack

| Component | Purpose |
|----------|---------|
| **ESP32** | Publishes sensor data (Temp, Humidity, CO2) via MQTT |
| **MQTT** | Lightweight protocol for reliable IoT communication |
| **HiveMQ** | MQTT broker (cloud-based) |
| **Spring Boot** | Acts as a bridge between MQTT and Kafka |
| **Apache Kafka** | Real-time data streaming and distribution |
| **PostgreSQL (via PGAdmin)** | Persistent storage of sensor data |
| **Web Dashboard** | Visualizes real-time data via charts and gauges |

---

## 📸 System Architecture

```text
[ESP32 Sensors] → MQTT → [Spring Boot App] → Kafka → [Consumers: DB, Dashboard, Alerts]
````

---

## 🔧 Installation & Setup

### 🔗 Prerequisites

* Java 11+
* Apache Kafka 3.9.0 (Scala 2.13)
* PostgreSQL & PGAdmin
* Arduino IDE / PlatformIO for ESP32
* Node.js (if customizing dashboard)
* Network connectivity (all devices on same LAN)

### ⚙️ ESP32 MQTT Publisher

1. Install libraries: `PubSubClient`, `Wire`, `DHT`, `SCD4x`
2. Connect sensors:

   * DHT11 → GPIO 4
   * SCD40 → GPIO 22 (SDA), GPIO 23 (SCL)
3. Embed Wi-Fi & HiveMQ credentials in code.
4. Upload the code to ESP32.

### 🧵 Kafka Setup

```bash
# Disable firewall (optional, for port 9092 access)
# Start Zookeeper and Kafka
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties

# Create topic
bin/kafka-topics.sh --create --topic esp32-mqtt-topic \
--bootstrap-server <BROKER_IP>:9092 --partitions 1 --replication-factor 3
```

### 📦 Spring Boot App

1. `BridgeService`: Receives MQTT and publishes to Kafka.
2. `DataService`: Stores Kafka data to PostgreSQL.
3. Run apps via `./mvnw spring-boot:run` or IDE.

### 🖥️ Dashboard & Web Visualization

* Basic Charts: [http://localhost:8081/basic-chart.html](http://localhost:8081/basic-chart.html)
* Advanced Visuals: [http://localhost:8081/advanced-chart.html](http://localhost:8081/advanced-chart.html)

---

## 📊 Features

* 📡 Real-time sensor streaming (CO2, Temp, Humidity)
* 🗃️ Kafka decouples data collection from consumers
* 📈 Dashboard with gauges, line charts, and heatmaps
* 💾 PostgreSQL storage for analytics/model training
* 🧠 Smart Feedback (Auto alerts based on thresholds)

| Parameter      | Suggested Action                       | 
| -------------- | -------------------------------------- |
| CO2 > 1200 ppm | 🚪 Open windows or turn on exhaust fan | 
| Temp > 28°C    | ❄️ Turn on fan or AC                   | 
| Temp < 20°C    | 🔥 Use heater                          | 
| Humidity > 65% | 💨 Use dehumidifier                    | 
| Humidity < 35% | 💧 Use humidifier                      | 

---

## ❗ Troubleshooting

| Issue                    | Fix                                        |
| ------------------------ | ------------------------------------------ |
| No MQTT connection       | Check ESP32 Wi-Fi & HiveMQ credentials     |
| Kafka not receiving data | Check topic name and broker address        |
| Dashboard not loading    | Ensure Spring Boot is running on port 8081 |
| Data not saved           | Check PostgreSQL service and port 5432     |

---

## 📚 Additional Resources

* [Apache Kafka Docs](https://kafka.apache.org/documentation/)
* [HiveMQ Console](https://console.hivemq.cloud)
* [Spring Boot Reference](https://spring.io/projects/spring-boot)

---

## 🧠 Future Improvements

* Integrate ML models for anomaly detection.
* Add SMS/Email alert notifications.
* Expand sensor network and dashboards.
* Deploy using Docker and Kubernetes.

---

## 📜 License

This project is for academic demonstration purposes only.

---
