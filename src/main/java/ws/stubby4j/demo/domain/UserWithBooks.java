package ws.stubby4j.demo.domain;

import java.util.List;

public class UserWithBooks {
    private User user;
    private List<Book> books;

    public UserWithBooks(User user, List<Book> books) {
        this.user = user;
        this.books = books;
    }

    public User getUser() {
        return user;
    }

    public List<Book> getBooks() {
        return books;
    }
}
