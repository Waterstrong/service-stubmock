package ws.stubby4j.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ws.stubby4j.demo.dao.BookDao;
import ws.stubby4j.demo.dao.UserDao;
import ws.stubby4j.demo.domain.Book;
import ws.stubby4j.demo.domain.User;
import ws.stubby4j.demo.domain.UserWithBooks;

@Service
public class DefaultLibraryService implements LibraryService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

    @Override
    public UserWithBooks retrieveUserWithBooks(String userId) {
        User user = userDao.retrieveUser(userId);
        List<Book> books = bookDao.retrieveBooks(userId);
        return new UserWithBooks(user, books);
    }
}
