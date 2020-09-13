package com.example.guestlist.dao;

import com.example.guestlist.model.Guest;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GuestDAO {
    int insertPerson(UUID id, Guest guest);

    default int insertPerson(Guest guest) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, guest);
    }

    List<Guest> selectAllGuests();

    Optional<Guest> selectGuestByID(UUID id);

    int updateGuestByID(UUID id, Guest guest);

    int deleteGuestByID(UUID id);
}
