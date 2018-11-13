package com.applicity.guestbook.backend;

import com.applicity.guestbook.backend.entity.GuestbookEntry;
import com.applicity.guestbook.backend.reposititory.GuestbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by me on 10.12.17.
 *
 * curl -X PUT -H "Content-Type: application/json" -d '{"title":"First Entry","comment":"This is the first comment","commenter":"abc@gmail.com"}' http://localhost:8080/guestbook/
 * curl -X PUT -H "Content-Type: application/json" -d '{"title":"Second Entry","comment":"This is the second comment","commenter":"abc@gmail.com"}' http://localhost:8080/guestbook/
 * curl -X PUT -H "Content-Type: application/json" -d '{"title":"Third Entry","comment":"This is the third comment","commenter":"abc@gmail.com"}' http://localhost:8080/guestbook/
 */
@Controller
@RequestMapping("/guestbook")
@CrossOrigin(origins = "*")
public class GuestbookController {

    @Autowired
    private GuestbookRepository repository;

    @RequestMapping(value = "/",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEntries() {
        final List<GuestbookEntry> entries = repository.findAllByOrderByIdDesc();
        return ResponseEntity.ok(entries);
    }

    @RequestMapping(value = "/",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody GuestbookEntry entry) {
        final GuestbookEntry entrySaved = repository.save(entry);
        return ResponseEntity.ok(entrySaved);
    }
}
