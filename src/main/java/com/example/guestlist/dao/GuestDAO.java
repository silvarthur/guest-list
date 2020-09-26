package com.example.guestlist.dao;

import com.example.guestlist.model.Guest;
import java.util.List;
import java.util.Optional;

public interface GuestDAO {
    List<Guest> selectAllGuests();
    Optional<Guest> selectGuestByID(int id);

    int insertGuest(Guest guest);

    int updateGuestByID(int id, Guest guest);

    int deleteGuestByID(int id);
}
