package com.audittest.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.function.Predicate;

public class CRUDController {
    public ResponseEntity<?> create(Predicate<Payload> createFunction, Payload payload) {
        if(createFunction.test(payload)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
