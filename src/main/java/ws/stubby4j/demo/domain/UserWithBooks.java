package ws.stubby4j.demo.domain;

import java.util.List;

public class UserWithBooks {
    private final User user;
    private final List<Book> books;

    public UserWithBooks(User user, List<Book> books) {
        this.user = user;
        this.books = books;
    }
}
