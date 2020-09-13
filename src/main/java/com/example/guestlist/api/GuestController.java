package com.example.guestlist.api;

import com.example.guestlist.model.Guest;
import com.example.guestlist.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

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

    @GetMapping(path = "{id}")
    public Guest getGuestByID(@PathVariable("id") UUID id) {
        return this.guestService.getGuestByID(id)
                .orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updateGuestByID(@PathVariable("id") UUID id,
                                @RequestBody Guest guest) {
        this.guestService.updateGuestByID(id, guest);
    }

    @DeleteMapping(path = "{id}")
    public void deleteGuestByID(@PathVariable UUID id) {
        this.guestService.deleteGuestByID(id);
    }
}
