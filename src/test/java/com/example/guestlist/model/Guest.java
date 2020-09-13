package com.example.guestlist.model;

import java.util.UUID;

public class Guest {
    private final UUID id;
    private final String name;
    private final String address;
    private final int numberOfInvites;

    public Guest(UUID id, String name, String address, int numberOfInvites) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.numberOfInvites = numberOfInvites;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfInvites() {
        return numberOfInvites;
    }
}
