package com.NicksWorld.JpaBiDirectional.repository;

import com.NicksWorld.JpaBiDirectional.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OwnerRepository extends CrudRepository <Owner, Long> {
}
