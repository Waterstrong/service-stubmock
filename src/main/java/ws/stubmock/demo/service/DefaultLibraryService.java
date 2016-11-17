package ws.stubmock.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ws.stubmock.demo.dao.BookDao;
import ws.stubmock.demo.dao.UserDao;
import ws.stubmock.demo.domain.Book;
import ws.stubmock.demo.domain.User;
import ws.stubmock.demo.domain.UserWithBooks;

@Service
public class DefaultLibraryService implements LibraryService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

    @Override
    public UserWithBooks retrieveUserWithBooks(String userId) {
        // TODO: make them concurrent
        User user = userDao.retrieveUser(userId);
        List<Book> books = bookDao.retrieveBooks(userId);
        return new UserWithBooks(user, books);
    }
}
