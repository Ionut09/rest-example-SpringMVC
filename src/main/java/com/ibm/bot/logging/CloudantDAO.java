package com.ibm.bot.logging;

import java.time.LocalDate;
import java.util.*;

import com.cloudant.client.api.Database;
import com.ibm.bot.utils.CloudantUtils;

public class CloudantDAO {

	public void insertObject(String email){
		Database db = CloudantUtils.getDB();
		String id = String.valueOf(System.currentTimeMillis());
		List<HashMap> emailList = db.findByIndex("{ \"email\": \""+email+"\" }", HashMap.class);
		
		if(emailList.size()==0){	
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("_id", id);
			data.put("email", email);
			data.put("accesCounter", 1);
			data.put("creation_date", LocalDate.now().toString());
			db.save(data);
			return;
		}else{
		//	db.upd
		}
	}
}