package kafka.producer.GetMQTT_SendKafka.Config;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.security.SecureRandom;

public class SSLSocketFactoryGenerator {
    public static SSLSocketFactory getSocketFactory() throws Exception {
        SSLContext context = SSLContext.getInstance("TLSv1.2");
        context.init(null, null, new SecureRandom());
        return context.getSocketFactory();
    }
}
