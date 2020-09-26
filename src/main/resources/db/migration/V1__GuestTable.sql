CREATE TABLE guest (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(100) NOT NULL,
    phone VARCHAR(11) NOT NULL,
    email VARCHAR(100) NOT NULL,
    extra_invitations SMALLINT
);