package com.stocktraderz.webrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stocktraderz.models.Profile;
import com.stocktraderz.service.ProfileService;

@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/profile/{id}")
	public Profile getProfileById(@PathVariable String id) {
		return profileService.getProfilebyId(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/profile")
	public void addProfile(@RequestBody Profile profile) {
		profileService.createProfile(profile);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/profile/{id}")
	public ResponseEntity<String> updateStock(@RequestBody Profile profile, @PathVariable String id) {
		String updateResult = profileService.updateProfile(id, profile);
		if(updateResult.equals("Not Found")) {
			return new ResponseEntity<String>(profile.getId()+": Not Found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(updateResult, HttpStatus.OK);
	}

}
