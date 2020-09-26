package com.example.guestlist.service;

import com.example.guestlist.dao.GuestDAO;
import com.example.guestlist.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {
    private final GuestDAO guestDAO;

    @Autowired
    public GuestService(@Qualifier("postgres") GuestDAO guestDAO) {
        this.guestDAO = guestDAO;
    }

    public int addGuest(Guest guest) {
        return guestDAO.insertGuest(guest);
    }

    public List<Guest> getAllGuests() {
        return guestDAO.selectAllGuests();
    }
    
    public Optional<Guest> getGuestByID(int id) {
        return guestDAO.selectGuestByID(id);
    }

    public int updateGuestByID(int id, Guest guest) {
        return guestDAO.updateGuestByID(id, guest);
    }

    public int deleteGuestByID(int id) {
        return guestDAO.deleteGuestByID(id);
    }
}
