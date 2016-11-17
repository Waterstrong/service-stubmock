package ws.stubmock.demo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.core.io.ClassPathResource;

import by.stub.client.StubbyClient;

public abstract class Stubby4JIntegrationTest extends BaseIntegrationTest {
    private static final StubbyClient API_STUB = new StubbyClient();
    @BeforeClass
    public static void startUp() throws Exception {
        API_STUB.startJetty(8882, new ClassPathResource("api/stubby4j.yml").getFile().getAbsolutePath());
    }

    @AfterClass
    public static void shutDown() throws Exception {
        API_STUB.stopJetty();
    }
}
