package ws.stubby4j.demo.service;

import ws.stubby4j.demo.domain.UserWithBooks;

public interface LibraryService {
    UserWithBooks retrieveUser(String userId);
}
