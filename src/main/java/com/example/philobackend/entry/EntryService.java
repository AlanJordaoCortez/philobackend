package com.example.philobackend.entry;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
    
    @Autowired
    private EntryRepo entryRepo;

    public Iterable<Entry> getEntries() {
        return entryRepo.findAll();
    }

    public Optional<Entry> getEntriesByTitle(String title) {
        return entryRepo.findByTitle(title);
    }

    public String addEntry(Entry entry) {
        entryRepo.save(entry);
        return "success";
    }

    public void removeEntry(Long id) {
        entryRepo.deleteById(id);
    }

    public Entry editEntryText(Long id, String newText) {
        Optional<Entry> toBeEdit = entryRepo.findById(id);
        if(toBeEdit.isPresent()) {
            toBeEdit.get().setText(newText);
            entryRepo.save(toBeEdit.get());
        }
        return toBeEdit.get();
    }
}
