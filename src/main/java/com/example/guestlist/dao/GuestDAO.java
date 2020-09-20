package com.example.guestlist.dao;

import com.example.guestlist.model.Guest;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GuestDAO {
    int insertGuest(Guest guest);

    List<Guest> selectAllGuests();

    Optional<Guest> selectGuestByID(UUID id);

    int updateGuestByID(UUID id, Guest guest);

    int deleteGuestByID(UUID id);
}
