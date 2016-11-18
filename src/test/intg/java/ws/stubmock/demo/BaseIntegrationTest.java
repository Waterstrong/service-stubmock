package ws.stubmock.demo;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import ws.stubmock.demo.configuration.IntegrationTestConfiguration;
import ws.stubmock.demo.controller.LibraryController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {IntegrationTestConfiguration.class})
@SpringBootTest(webEnvironment = DEFINED_PORT)
@ActiveProfiles("local")
public abstract class BaseIntegrationTest {
    protected MockMvc mockMvc;

    @Autowired
    private LibraryController libraryController;

    @Before
    public void setUp() {
        mockMvc = standaloneSetup(libraryController).build();
    }
}
