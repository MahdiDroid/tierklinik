package com.MahdiDroid.tierklinik.services;

import com.MahdiDroid.tierklinik.model.Owner;

import java.util.Set;

public interface OwnerService  extends CrudService<Owner,Long>{


    Owner findByLastName(String lastName);

}
