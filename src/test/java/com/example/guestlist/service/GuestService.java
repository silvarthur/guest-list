package com.example.guestlist.service;

import com.example.guestlist.dao.GuestDAO;
import com.example.guestlist.model.Guest;

public class GuestService {
    private final GuestDAO guestDAO;

    public GuestService(GuestDAO guestDAO) {
        this.guestDAO = guestDAO;
    }

    public int addGuest(Guest guest) {
        return guestDAO.insertPerson(guest);
    }
}
