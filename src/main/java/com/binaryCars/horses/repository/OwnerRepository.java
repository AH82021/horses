package com.binaryCars.horses.repository;

import com.binaryCars.horses.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository  extends JpaRepository<Owner,Long> {
    Optional<Owner> findOwnerByFirstName(String FirstName);

}
