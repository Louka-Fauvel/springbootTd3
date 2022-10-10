package edu.caensup.sio.td3.messagerie.services;

import org.springframework.stereotype.Service;

@Service
public class UIOrgaService {

	public String getFormValidation() {
		return "$('.ui.form').form({on:'blur', inline:true, fields:{name:'empty', aliases:'empty', domain:'empty'}})";
	}
	
	public String ifFormIsValid(String code) {
		return "if($('.ui.form').form('validate form')) {" + code + "}";
	}
	
	public String getURL(String url, String idStr) {
		return "'" + url + "'+" + idStr;
	}
	
	public String toastMessage(String title, String message) {
		return "$.toast({position: 'top attached', class: 'success', title: '" + title + "', message: `" + message + "`})";
	}
	
}
