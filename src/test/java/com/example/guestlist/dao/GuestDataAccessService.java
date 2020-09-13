package com.example.guestlist.dao;

import com.example.guestlist.model.Guest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GuestDataAccessService implements GuestDAO{
    private static List<Guest> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Guest guest) {
        DB.add(new Guest(id, guest.getName(), guest.getAddress(),
                guest.getNumberOfInvites()));
        return 1;
    }
}
