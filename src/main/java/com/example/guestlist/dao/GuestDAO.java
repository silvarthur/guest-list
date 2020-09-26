package com.example.guestlist.dao;

import com.example.guestlist.model.Guest;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GuestDAO {
    List<Guest> selectAllGuests();
    Optional<Guest> selectGuestByID(UUID id);

    int insertGuest(Guest guest);

    int updateGuestByID(UUID id, Guest guest);

    int deleteGuestByID(UUID id);
}
