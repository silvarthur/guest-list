package com.example.guestlist.api;

import com.example.guestlist.model.Guest;
import com.example.guestlist.service.GuestService;

public class GuestController {
    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    public void addGuest(Guest guest) {
        this.guestService.addGuest(guest);
    }
}
