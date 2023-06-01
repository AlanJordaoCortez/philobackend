package com.example.philobackend.entry;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called entryRepo

public interface EntryRepo extends CrudRepository<Entry, Long> {
    public Optional<Entry> findByTitle(String title);
    
}
