package ws.stubmock.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ws.stubmock.demo.domain.User;

@Component
public class UserDao {
    @Value("${user.service.url}")
    private String userServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public User retrieveUser(String userId) {
        return restTemplate.getForObject(userServiceUrl, User.class, userId);
    }
}
