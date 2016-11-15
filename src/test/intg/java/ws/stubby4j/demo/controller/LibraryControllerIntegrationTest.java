package ws.stubby4j.demo.controller;

import static java.lang.String.format;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ws.stubby4j.demo.BaseIntegrationTest;

public class LibraryControllerIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private LibraryController libraryController;

    @Before
    public void setUp() {
        mockMvc = standaloneSetup(libraryController).build();
    }

    @Test
    public void shouldRetrieveUserWithBooksSuccessfully() throws Exception {
        String userId = "123456";
        mockMvc.perform(get(format("/library/users/%s", userId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user.userId").value(userId))
                .andExpect(jsonPath("$.user.userName").value("Peter"))
                .andExpect(jsonPath("$.books", hasSize(2)))
                .andExpect(jsonPath("$.books[0].bookId").value(1))
                .andExpect(jsonPath("$.books[0].bookName").value("Head First Java"));
    }
}