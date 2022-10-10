package edu.caensup.sio.td3.messagerie.exceptions;

public class OrgaNotFoundException extends RuntimeException {

	public OrgaNotFoundException(int id) {
		super("Organisation " + id + " non trouvée");
		
	}
	
}
