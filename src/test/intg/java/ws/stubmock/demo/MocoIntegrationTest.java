package ws.stubmock.demo;

import static com.github.dreamhead.moco.Moco.httpServer;
import static com.github.dreamhead.moco.Moco.pathResource;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.core.io.ClassPathResource;
import com.github.dreamhead.moco.HttpServer;
import com.github.dreamhead.moco.Runner;


public abstract class MocoIntegrationTest extends BaseIntegrationTest {
    private static Runner runner;

    @BeforeClass
    public static void startUp() throws Exception {
        HttpServer server = httpServer(8882);
        server.response(pathResource(
                new ClassPathResource("api/json/moco-response.json").getFile().getAbsolutePath()));
        runner = Runner.runner(server);
        runner.start();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        runner.stop();
    }
}
