package ws.stubmock.demo.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ws.stubmock.demo.domain.UserWithBooks;
import ws.stubmock.demo.service.LibraryService;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(method = GET, value = "/library/users/{userId}")
    public ResponseEntity<UserWithBooks> retrieveUserWithBooks(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(libraryService.retrieveUserWithBooks(userId), OK);
    }

}
