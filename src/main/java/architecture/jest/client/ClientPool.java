package architecture.jest.client;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Connection pool
 * @deprecated
 * @author cuihao
 */
public class ClientPool {

    /**
     * store client buffer
     */
    private Map<String,Client> clientMap = new ConcurrentHashMap<>();

    private String CLUSTER_TAG = "cluster.name";
    private String SNIFF_TAG = "client.transport.sniff";
    private int PORT = 9300;

    /**
     * Get client pool instance
     * @return instance of client pool
     */
    public static ClientPool instance() {
        return ClientHolder.INSTANCE;
    }

    private ClientPool() {
        Settings settings = Settings.builder()
                .put(CLUSTER_TAG,"elasticsearch-price-parity")
                .put(SNIFF_TAG,true).build();
        List<InetSocketTransportAddress> addresses = new ArrayList<>();
        try {
            addresses.add(new InetSocketTransportAddress(InetAddress.getByName("123.206.103.124"),PORT));
            addresses.add(new InetSocketTransportAddress(InetAddress.getByName("115.159.143.242"),PORT));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        addClient(settings,addresses);
    }

    /**
     * Get default client
     * @return default elastic transport client
     */
    public Client getClient() {
        return getClient("elasticsearch-price-parity");
    }

    /**
     * Get custom client (MUST be added to pool before)
     * @param cluster cluster name
     * @return Client instance
     */
    public Client getClient(String cluster) {
        return clientMap.get(cluster);
    }

    /**
     * Add a custom client to pool
     * @param settings {@link Settings}
     * @param addresses {@link InetSocketTransportAddress}
     */
    public void addClient(Settings settings, List<InetSocketTransportAddress> addresses) {
        Client client = new PreBuiltTransportClient(settings)
                .addTransportAddresses(addresses.toArray(new InetSocketTransportAddress[addresses.size()]));
        clientMap.put(settings.get(CLUSTER_TAG),client);
    }

    @Override
    protected void finalize() throws Throwable {
        clientMap.forEach((s, client) -> client.close());
        super.finalize();
    }

    /**
     * Singleton instance holder
     */
    private static class ClientHolder {
        private static final ClientPool INSTANCE = new ClientPool();
    }
}
