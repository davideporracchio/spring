package co.uk.cassandra.repository;


import java.util.UUID;

import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;

import co.uk.cassandra.domain.User;

public interface UserRepository extends TypedIdCassandraRepository<User, UUID> {
}
