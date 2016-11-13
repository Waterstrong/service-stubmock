package ws.stubby4j.demo.controller;

import static java.lang.String.format;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import by.stub.client.StubbyClient;
import ws.stubby4j.demo.BaseIntegrationTest;

public class LibraryControllerTest extends BaseIntegrationTest {
    private static final StubbyClient API_STUB = new StubbyClient();

    @Autowired
    private LibraryController libraryController;

    @BeforeClass
    public static void startUp() throws Exception {
        API_STUB.startJetty(8882, new ClassPathResource("api/stubby4j.yml").getFile().getAbsolutePath());
    }

    @AfterClass
    public static void shutDown() throws Exception {
        API_STUB.stopJetty();
    }

    @Before
    public void setUp() {
        mockMvc = standaloneSetup(libraryController).build();
    }

    @Test
    public void shouldRetrieveUserWithBooksSuccessfully() throws Exception {
        String userId = "123456";
        mockMvc.perform(get(format("/library/%s", userId)))
                .andExpect(status().isOk());

    }
}