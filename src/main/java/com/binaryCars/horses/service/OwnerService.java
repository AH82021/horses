package com.binaryCars.horses.service;

import com.binaryCars.horses.entity.Owner;

import java.util.List;

public interface OwnerService {
    Owner findOwnerById(Long ownerId);
    Owner findOwnerByFirstNme(String FirstName);
    List<Owner> findAllOwners();
    Owner addOwner(Owner owner);
    void updateOwner(Long ownerId,Owner owner);
    void deleteOwner(Long ownerId);

}
