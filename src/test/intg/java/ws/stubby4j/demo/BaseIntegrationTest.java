package ws.stubby4j.demo;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import by.stub.client.StubbyClient;
import ws.stubby4j.demo.configuration.IntegrationTestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {IntegrationTestConfiguration.class})
@SpringBootTest(webEnvironment = DEFINED_PORT)
@ActiveProfiles("local")
public abstract class BaseIntegrationTest {
    private static final StubbyClient API_STUB = new StubbyClient();

    protected MockMvc mockMvc;

    @BeforeClass
    public static void startUp() throws Exception {
        API_STUB.startJetty(8882, new ClassPathResource("api/stubby4j.yml").getFile().getAbsolutePath());
    }

    @AfterClass
    public static void shutDown() throws Exception {
        API_STUB.stopJetty();
    }
}
