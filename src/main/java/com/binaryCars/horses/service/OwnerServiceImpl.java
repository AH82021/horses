package com.binaryCars.horses.service;

import com.binaryCars.horses.entity.Owner;
import com.binaryCars.horses.exception.ResourceNotFoundException;
import com.binaryCars.horses.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    @Override
    public Owner findOwnerById(Long ownerId) {
        return ownerRepository.findById(ownerId)
                .orElseThrow(()-> new ResourceNotFoundException("Could not find owner id  " + ownerId));
    }

    @Override
    public Owner findOwnerByFirstNme(String FirstName) {
        return  ownerRepository.findOwnerByFirstName(FirstName)
                .orElseThrow(()-> new ResourceNotFoundException("Could not find owner Name "+FirstName));
    }

    @Override
    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner addOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void updateOwner(Long ownerId,Owner owner) {
         Owner existingOwner = findOwnerById(ownerId);
         existingOwner.setFirstName(owner.getFirstName());
         existingOwner.setLastName(owner.getLastName());
         ownerRepository.save(existingOwner);
    }

    @Override
    public void deleteOwner(Long ownerId) {
      ownerRepository.deleteById(ownerId);
    }
}
