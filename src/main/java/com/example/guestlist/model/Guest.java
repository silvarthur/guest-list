package com.example.guestlist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class Guest {
    private final int id;
    @NotBlank
    private final String name;
    private final String address;
    private final String phone;
    private final String email;
    private final int extraInvitations;

    public Guest(@JsonProperty("id") int id,
                 @JsonProperty("name") String name,
                 @JsonProperty("address") String address,
                 @JsonProperty("phone") String phone,
                 @JsonProperty("email") String email,
                 @JsonProperty("extraInvitations") int extraInvitations) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.extraInvitations = extraInvitations;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getExtraInvitations() {
        return extraInvitations;
    }
}
