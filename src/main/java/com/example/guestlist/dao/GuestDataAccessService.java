package com.example.guestlist.dao;

import com.example.guestlist.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

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
                Integer.valueOf(resultSet.getString("id")),
                resultSet.getString("name"),
                resultSet.getString("address"),
                resultSet.getString("phone"),
                resultSet.getString("email"),
                resultSet.getInt("extra_invitations")
            );
        });
    }

    @Override
    public Optional<Guest> selectGuestByID(int id) {
        String query = "SELECT * FROM guest WHERE id = ?";

        Guest guest = jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, i) -> {
            return new Guest(
                Integer.valueOf(resultSet.getString("id")),
                resultSet.getString("name"),
                resultSet.getString("address"),
                resultSet.getString("phone"),
                resultSet.getString("email"),
                resultSet.getInt("extra_invitations"));
        });

        return Optional.ofNullable(guest);
    }

    @Override
    public int insertGuest(Guest guest) {
        String query = "INSERT INTO guest (name, address, phone, email, invites) VALUES (?, ?, ?, ?, ?)";

        return jdbcTemplate.update(
            query,
            guest.getId(),
            guest.getName(),
            guest.getAddress(),
            guest.getPhone(),
            guest.getEmail(),
            guest.getExtraInvitations()
        );
    }

    @Override
    public int updateGuestByID(int id, Guest guest) {
        String query =
                "UPDATE guest " +
                "SET name = ?, address = ?, phone = ?, email = ?, extra_invitations = ? " +
                "WHERE id = ?";

        return jdbcTemplate.update(query, guest.getName(),
                guest.getAddress(), guest.getPhone(), guest.getEmail(),
                guest.getExtraInvitations(), guest.getId());
    }

    @Override
    public int deleteGuestByID(int id) {
        String query = "DELETE FROM guest WHERE id = ?";
        return jdbcTemplate.update(query, id);
    }
}
