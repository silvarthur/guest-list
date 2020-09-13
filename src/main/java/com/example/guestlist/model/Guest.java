package com.example.guestlist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Guest {
    private final UUID id;
    @NotBlank
    private final String name;
    private final String address;
    private final int numberOfInvites;

    public Guest(@JsonProperty("id") UUID id,
                 @JsonProperty("name") String name,
                 @JsonProperty("address") String address,
                 @JsonProperty("numberOfInvites") int numberOfInvites) {
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
