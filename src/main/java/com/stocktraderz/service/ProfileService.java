package com.stocktraderz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktraderz.models.Profile;
import com.stocktraderz.repository.ProfileRepository;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;

	public Profile createProfile(Profile profile) {
		return profileRepository.save(profile);
	}

	public String updateProfile(String id, Profile profile) {
		Profile savedProfile = profileRepository.save(profile);
		if(savedProfile!=null) {
			return "Updated SuccessFully";
		}else
			return id + "Profile not Found";
	}

	public Profile getProfilebyId(String id) {
		
		return profileRepository.findById(id).get();
	}
	
	
}
