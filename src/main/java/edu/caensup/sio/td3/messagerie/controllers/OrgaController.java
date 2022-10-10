package edu.caensup.sio.td3.messagerie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.caensup.sio.td3.messagerie.repositories.IOrganizationDAO;
import edu.caensup.sio.td3.messagerie.services.UIOrgaService;
import io.github.jeemv.springboot.vuejs.VueJS;
import io.github.jeemv.springboot.vuejs.utilities.Http;
import io.github.jeemv.springboot.vuejs.utilities.JsArray;

@Controller
@RequestMapping("/orgas")
public class OrgaController {

	private static String restUrl = "http://127.0.0.1:8080/rest/organizations/";
	
	@Autowired
	private VueJS vue;
	
	@Autowired
	private UIOrgaService orgaService;
	
	@Autowired
	private IOrganizationDAO organizationDAO;
	
	@ModelAttribute("vue")
	public VueJS getVue() {
		return this.vue;
	}
	
	@GetMapping("")
	public String indexAction() {
		
		vue.addData("toDelete");
		vue.addData("orga");
		vue.addData("organizations", organizationDAO.findAll());
		
		vue.addMethod("remove", Http.delete(orgaService.getURL(restUrl, "orga.id"), 
				"this.toDelete=null;" + JsArray.remove("this.organizations", "orga")), "orga");
		
		vue.addMethod("confDelete", "this.toDelete=orga", "orga");
		
		vue.addMethod("newFormOrga", "this.orga={};" + orgaService.getFormValidation());
		
		vue.addMethod("newOrgaSubmit", orgaService.ifFormIsValid(Http.post(restUrl, "this.orga", 
				JsArray.add("this.organizations", "response.data")
						+ orgaService.toastMessage("Organisation ajouté", "L'organisation ${this.orga.name} a été ajoutée.")
						+ ";this.orga=null;")));
		
		vue.addMethod("editForm", "this.orga={...orga}; this.orga.original=orga", "orga");
		
		vue.onUpdatedNextTick(orgaService.getFormValidation());
		vue.addMethod("updateOrgaSubmit", orgaService.ifFormIsValid(Http.put(orgaService.getURL(restUrl, "this.orga.id"), 
				(Object)"this.orga", "Object.assign(this.orga.original, response.data);this.orga=null;")));
		
		vue.addMethod("addOrUpdate", "if(this.orga.id) {this.updateOrgaSubmit();} else {this.newOrgaSubmit();}");
		
		return "index";
		
	}
	
}
