package com.binaryCars.horses.web;

import com.binaryCars.horses.entity.Owner;
import com.binaryCars.horses.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/owner")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public ResponseEntity<List<Owner>> getOwners(){
        return new ResponseEntity<>(ownerService.findAllOwners(), HttpStatus.OK);
    }
    @GetMapping("/{ownerId}")
    public  ResponseEntity<Owner> getOwner(@PathVariable Long ownerId){
        return new ResponseEntity<>(ownerService.findOwnerById(ownerId),HttpStatus.OK);

    }

    @GetMapping("/{firstName}")
    public  ResponseEntity<Owner> getOwnerByName(@PathVariable String firstName){
        return new ResponseEntity<>(ownerService.findOwnerByFirstNme(firstName),HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Owner> addOwner(@RequestBody Owner owner){
         return new ResponseEntity<>(ownerService.addOwner(owner), HttpStatus.CREATED);
    }
    @PutMapping("/{ownerId}")
    public ResponseEntity<HttpStatus> updateOwner(@PathVariable Long ownerId,@RequestBody Owner owner){
         ownerService.updateOwner(ownerId,owner);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{ownerId}")
    public ResponseEntity<HttpStatus> deleteOwner(@PathVariable Long ownerId){
        ownerService.deleteOwner(ownerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
