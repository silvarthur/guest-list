package com.example.guestlist.api;

import com.example.guestlist.model.Guest;
import com.example.guestlist.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/guest")
@RestController
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping
    public void addGuest(@RequestBody Guest guest) {
        this.guestService.addGuest(guest);
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return this.guestService.getAllGuests();
    }
}
