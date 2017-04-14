package architecture.jest;

import architecture.config.ElasticConfig;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


/**
 * Jest client factory
 * @author cuihao
 */
@Component
@Scope("singleton")
public class ClientFactory {

    private ElasticConfig config;

    private JestClient client;

    @Autowired
    public ClientFactory(ElasticConfig config) {
        this.config = config;
    }

    /**
     * Get jest client
     * @return {@link JestClient}
     */
    public JestClient getClient() {
        if (client == null) {
            synchronized (ClientFactory.class) {
                if (client == null) {
                    JestClientFactory factory = new JestClientFactory();
                    factory.setHttpClientConfig(new HttpClientConfig.Builder(config.getHosts())
                            .multiThreaded(true).discoveryEnabled(true)
                            .discoveryFrequency(1L, TimeUnit.MINUTES).build());
                    client = factory.getObject();
                }
            }
        }
        return client;
    }

    @Override
    protected void finalize() throws Throwable {
        client.shutdownClient();
        super.finalize();
    }
}
