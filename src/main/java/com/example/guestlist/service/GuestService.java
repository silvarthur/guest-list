package com.example.guestlist.service;

import com.example.guestlist.dao.GuestDAO;
import com.example.guestlist.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
    private final GuestDAO guestDAO;

    @Autowired
    public GuestService(@Qualifier("sqlGuestDao") GuestDAO guestDAO) {
        this.guestDAO = guestDAO;
    }

    public int addGuest(Guest guest) {
        return guestDAO.insertPerson(guest);
    }
}
