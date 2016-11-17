package ws.stubmock.demo.service;

import ws.stubmock.demo.domain.UserWithBooks;

public interface LibraryService {
    UserWithBooks retrieveUserWithBooks(String userId);
}
