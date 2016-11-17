package ws.stubmock.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ws.stubmock.demo.domain.Book;

@Component
public class BookDao {

    @Value("${book.service.url}")
    private String bookServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<Book> retrieveBooks(String userId) {
        return restTemplate.getForObject(bookServiceUrl, List.class, userId);
    }
}
