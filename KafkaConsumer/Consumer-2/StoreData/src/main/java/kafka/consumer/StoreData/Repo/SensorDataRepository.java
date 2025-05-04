package kafka.consumer.StoreData.Repo;

import kafka.consumer.StoreData.Model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
}
