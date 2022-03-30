package com.stocktraderz.repository;

import org.springframework.data.repository.CrudRepository;

import com.stocktraderz.models.Profile;

public interface ProfileRepository extends CrudRepository<Profile, String> {

}
