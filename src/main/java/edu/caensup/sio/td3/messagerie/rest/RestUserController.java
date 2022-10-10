package edu.caensup.sio.td3.messagerie.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.caensup.sio.td3.messagerie.models.User;
import edu.caensup.sio.td3.messagerie.repositories.IUserDAO;

@RestController
@RequestMapping("/rest/users")
public class RestUserController {

	@Autowired
	private IUserDAO userDAO;
	
	@GetMapping("")
	public List<User> indexAction() {
		return userDAO.findAll();
	}
	
	@GetMapping("/{id}")
	public User oneAction(@PathVariable int id) {
		
		Optional<User> opt = userDAO.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		
		return null;
		
	}
	
	@PostMapping("")
	public User addAction(@RequestBody User user) {
		
		userDAO.save(user);
		return user;
		
	}
	
	@PutMapping("/{id}")
	public User updateAction(@PathVariable int id, @RequestBody User user) {
		
		return userDAO.findById(id).map((loadedUser) -> {
			
			loadedUser.setFirstname(user.getFirstname());
			loadedUser.setLastname(user.getLastname());
			loadedUser.setEmail(user.getEmail());
			loadedUser.setPassword(user.getPassword());
			loadedUser.setSuspended(user.isSuspended());
			userDAO.save(loadedUser);
			return loadedUser;
			
		}).orElseThrow(() -> null);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteAction(@PathVariable int id) {
		
		Optional<User> opt = userDAO.findById(id);
		
		if(opt.isPresent()) {
			
			userDAO.deleteById(id);
			return "Utilisateur " + id + " supprimé.";
			
		}
		
		return "Erreur l'Utilisateur " + id + "est introuvable.";
		
	}
	
}
