package kafka.consumer.VisualiseData.Model;

public class SensorData {
    private double scd_co2;
    private double scd_temp;
    private double scd_humidity;
    private double dht_temp;
    private double dht_humidity;

    public double getScd_co2() { return scd_co2; }
    public void setScd_co2(double scd_co2) { this.scd_co2 = scd_co2; }

    public double getScd_temp() { return scd_temp; }
    public void setScd_temp(double scd_temp) { this.scd_temp = scd_temp; }

    public double getScd_humidity() { return scd_humidity; }
    public void setScd_humidity(double scd_humidity) { this.scd_humidity = scd_humidity; }

    public double getDht_temp() { return dht_temp; }
    public void setDht_temp(double dht_temp) { this.dht_temp = dht_temp; }

    public double getDht_humidity() { return dht_humidity; }
    public void setDht_humidity(double dht_humidity) { this.dht_humidity = dht_humidity; }

    @Override
    public String toString() {
        return "SensorData {" +
                "scd_co2=" + scd_co2 +
                ", scd_temp=" + scd_temp +
                ", scd_humidity=" + scd_humidity +
                ", dht_temp=" + dht_temp +
                ", dht_humidity=" + dht_humidity +
                '}';
    }
}
