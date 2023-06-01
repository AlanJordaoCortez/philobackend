package com.example.philobackend.entry;

import java.time.ZoneId;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;


    @GetMapping("/get/all")
    public Iterable<Entry> getEntries() {
        return entryService.getEntries();
    }

    @GetMapping("/get")
    public Optional<Entry> getEntriesByTitle(@RequestParam String title) {
        return entryService.getEntriesByTitle(title);

    }

    // @RequestBody must map to a single object
    @PostMapping("/add")
    public String addEntry(@RequestBody Map<String, String> json) {
        Entry entry = new Entry(json.get("title"), LocalDate.now(ZoneId.of("America/Chicago")), json.get("text"));
        return entryService.addEntry(entry);
    }
    
}
