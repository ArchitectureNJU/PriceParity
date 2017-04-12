package architecture.jest;

import architecture.PriceParityApplicationTests;
import architecture.jest.client.ClientPool;
import org.elasticsearch.client.Client;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cuihao on 2017/4/11.
 */
public class ClientPoolTest extends PriceParityApplicationTests {

    @Test
    public void getClient() throws Exception {
        Client client = ClientPool.instance().getClient();
        Assert.assertTrue(client!=null);
    }

}