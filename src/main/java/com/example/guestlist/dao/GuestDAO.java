package com.example.guestlist.dao;

import com.example.guestlist.model.Guest;
import java.util.UUID;

public interface GuestDAO {
    int insertPerson(UUID id, Guest guest);
    default int insertPerson(Guest guest) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, guest);
    }
}
