package ws.stubby4j.demo.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ws.stubby4j.demo.service.LibraryService;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(method = GET, value = "/users/{userId}")
    public ResponseEntity<?> retrieveUserWithBooks(@PathVariable("bookId") String userId) {
        return new ResponseEntity<>(libraryService.retrieveUser(userId), OK);
    }

}
