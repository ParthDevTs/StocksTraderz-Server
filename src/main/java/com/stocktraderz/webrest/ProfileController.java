package com.stocktraderz.webrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stocktraderz.dto.Message;
import com.stocktraderz.models.Profile;
import com.stocktraderz.service.ProfileService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/profile/{id}")
	public Profile getProfileById(@PathVariable String id) {
		return profileService.getProfilebyId(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/profile")
	public ResponseEntity<Message> addProfile(@RequestBody Profile profile) {
		Profile savedProfile = profileService.createProfile(profile);
		Message message = new Message();
		if(savedProfile==null) {
			message.setMessage("Profile Not Saved Successfully");
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}else
			message.setMessage(profile.getProfileName()+": Profile Created Successfully with userId: "+profile.getId());
			return new ResponseEntity<>(message, HttpStatus.OK);
			
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
