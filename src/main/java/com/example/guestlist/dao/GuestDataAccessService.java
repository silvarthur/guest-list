package com.example.guestlist.dao;

import com.example.guestlist.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class GuestDataAccessService implements GuestDAO{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GuestDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Guest> selectAllGuests() {
        String query = "SELECT * FROM guest";

        return jdbcTemplate.query(query, (resultSet, i) -> {
            return new Guest(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("name"),
                resultSet.getString("address"),
                resultSet.getInt("invites")
            );
        });
    }

    @Override
    public Optional<Guest> selectGuestByID(UUID id) {
        String query = "SELECT * FROM guest WHERE id = ?";

        Guest guest = jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, i) -> {
            return new Guest(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("name"),
                resultSet.getString("address"),
                resultSet.getInt("invites"));
        });

        return Optional.ofNullable(guest);
    }

    @Override
    public int insertGuest(Guest guest) {
        String query = "INSERT INTO guest (id, name, address, invites) VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(
            query,
            guest.getId(),
            guest.getName(),
            guest.getAddress(),
            guest.getNumberOfInvites()
        );
    }

    @Override
    public int updateGuestByID(UUID id, Guest guest) {
        String query =
                "UPDATE guest " +
                "SET name = ?, address = ?, invites = ? " +
                "WHERE id = ?";

        return jdbcTemplate.update(query, guest.getName(),
                guest.getAddress(), guest.getNumberOfInvites(), guest.getId());
    }

    @Override
    public int deleteGuestByID(UUID id) {
        String query = "DELETE FROM guest WHERE id = ?";
        return jdbcTemplate.update(query, id);
    }
}
