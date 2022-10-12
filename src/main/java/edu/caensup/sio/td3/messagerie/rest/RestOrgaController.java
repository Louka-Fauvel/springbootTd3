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

import edu.caensup.sio.td3.messagerie.exceptions.OrgaNotFoundException;
import edu.caensup.sio.td3.messagerie.models.Group;
import edu.caensup.sio.td3.messagerie.models.Organization;
import edu.caensup.sio.td3.messagerie.repositories.IOrganizationDAO;

@RestController
@RequestMapping("/rest/organizations")
public class RestOrgaController {

	@Autowired
	private IOrganizationDAO OrgaRepo;
	
	@GetMapping("")
	public List<Organization> indexAction() {
		return OrgaRepo.findAll();
	}
	
	@GetMapping("/{id}/groups")
	public Iterable<Group> groupsAction(@PathVariable int id) {
		
		Optional<Organization> opt = OrgaRepo.findById(id);
		
		if(opt.isPresent()) {
			Iterable<Group> grs = opt.get().getGroups();
			return grs;
		}
		
		throw new OrgaNotFoundException(id);
	}
	
	@GetMapping("/{id}")
	public Organization oneAction(@PathVariable int id) {
		
		Optional<Organization> opt = OrgaRepo.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		
		throw new OrgaNotFoundException(id);
	}
	
	@PostMapping("")
	public Organization addAction(@RequestBody Organization orga) {
		
		OrgaRepo.save(orga);
		return orga;
		
	}
	
	@PutMapping("/{id}")
	public Organization updateAction(@PathVariable int id, @RequestBody Organization orga) {
		
		return OrgaRepo.findById(id).map((loadedOrga) -> {
			
			loadedOrga.setName(orga.getName());
			loadedOrga.setDomain(orga.getDomain());
			loadedOrga.setAliases(orga.getAliases());
			OrgaRepo.save(loadedOrga);
			return loadedOrga;
			
		}).orElseThrow(() -> new OrgaNotFoundException(id));
		
	}
	
	@DeleteMapping("/{id}")
	public RestMessage deleteAction(@PathVariable int id) {
		
		Optional<Organization> opt = OrgaRepo.findById(id);
		
		if(opt.isPresent()) {
			
			OrgaRepo.deleteById(id);
			return new RestMessage("200", "Organisation supprimée : " + id);
			
		}
		
		throw new OrgaNotFoundException(id);
		
	}
	
}
