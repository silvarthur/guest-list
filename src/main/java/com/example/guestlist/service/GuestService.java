package com.example.guestlist.service;

import com.example.guestlist.dao.GuestDAO;
import com.example.guestlist.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GuestService {
    private final GuestDAO guestDAO;

    @Autowired
    public GuestService(@Qualifier("postgres") GuestDAO guestDAO) {
        this.guestDAO = guestDAO;
    }

    public int addGuest(Guest guest) {
        return guestDAO.insertPerson(guest);
    }

    public List<Guest> getAllGuests() {
        return guestDAO.selectAllGuests();
    }
    
    public Optional<Guest> getGuestByID(UUID id) {
        return guestDAO.selectGuestByID( id);
    }

    public int updateGuestByID(UUID id, Guest newGuest) {
        return guestDAO.updateGuestByID(id, newGuest);
    }

    public int deleteGuestByID(UUID id) {
        return guestDAO.deleteGuestByID(id);
    }
}
