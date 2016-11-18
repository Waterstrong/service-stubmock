package ws.stubmock.demo;

import static com.github.dreamhead.moco.Moco.httpServer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import com.github.dreamhead.moco.Runner;


public abstract class MocoIntegrationTest extends BaseIntegrationTest {
    private static final Runner runner = Runner.runner(httpServer(8882));
//    Moco.pathResource("books-response.json")

    @BeforeClass
    public static void startUp() throws Exception {
        runner.start();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        runner.stop();
    }
}
