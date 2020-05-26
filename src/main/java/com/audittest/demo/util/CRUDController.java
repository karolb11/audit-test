package com.audittest.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class CRUDController<T> {

    public ResponseEntity<?> handleCreateRequest(Predicate<T> createFunction, T payload) {
        if(createFunction.test(payload)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> handleReadByIdRequest(Function<Long, Optional<T>> readFunction, Long id) {
        try {
            T payload = readFunction.apply(id)
                    .orElseThrow(() -> new Exception("not found"));
            return new ResponseEntity<>(payload, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
