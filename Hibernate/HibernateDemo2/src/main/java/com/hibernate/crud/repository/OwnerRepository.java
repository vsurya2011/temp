package com.hibernate.crud.repository;

import com.hibernate.crud.dto.OwnerDTO;
import com.hibernate.crud.exception.DuplicateOwnerFoundException;
import com.hibernate.crud.exception.OwnerNotFoundException;

import java.util.List;

public interface OwnerRepository {

    void saveOwner(OwnerDTO ownerDTO);

    OwnerDTO findOwner(int OwnerID);

    void updatePetDetails(int ownerId,String petName);

    void deleteOwner(int ownerId);

    List<OwnerDTO> findAllOwners();
}
