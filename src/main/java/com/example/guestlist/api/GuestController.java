package com.example.guestlist.api;

import com.example.guestlist.model.Guest;
import com.example.guestlist.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
