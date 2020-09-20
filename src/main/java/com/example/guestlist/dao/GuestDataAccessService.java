package com.example.guestlist.dao;

import com.example.guestlist.model.Guest;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class GuestDataAccessService implements GuestDAO{
    private static List<Guest> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Guest guest) {
        DB.add(new Guest(id, guest.getName(), guest.getAddress(),
                guest.getNumberOfInvites()));
        return 1;
    }

    @Override
    public List<Guest> selectAllGuests() {
        return DB;
    }

    @Override
    public Optional<Guest> selectGuestByID(UUID id) {
        return DB.stream()
                .filter(guest -> guest.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updateGuestByID(UUID id, Guest guest) {
        return selectGuestByID(id).map(tempGuest -> {
            int indexOfGuestToUpdate = DB.indexOf(tempGuest);
            if(indexOfGuestToUpdate >= 0) {
                DB.set(indexOfGuestToUpdate, new Guest(id, tempGuest.getName(),
                        tempGuest.getAddress(), tempGuest.getNumberOfInvites()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public int deleteGuestByID(UUID id) {
        Optional<Guest> guest = selectGuestByID(id);
        if(guest.isEmpty()) {
            return 0;
        }
        DB.remove(guest.get());
        return 1;
    }
}
