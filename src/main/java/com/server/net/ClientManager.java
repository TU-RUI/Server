package com.server.net;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.server.model.ClientModel;
import com.server.model.ControlledModel;
import com.server.model.ControllerModel;

public class ClientManager {
	private static ClientManager manager = null;
	private static ConcurrentHashMap<String,ClientModel> clients;
	
	public static ClientManager getInstance(){
		if(manager == null){
			manager = new ClientManager();
		}
		return manager;
	}

	private ClientManager(){
		clients = new ConcurrentHashMap<String,ClientModel>();
	}
	
	public void addController(String md5,ControllerModel model){
		if(clients.containsKey(md5)){
			clients.get(md5).setController(model);
		}else{
			ClientModel client = new ClientModel();
			client.setUsername(md5);
			client.setController(model);
			clients.put(md5, client);
		}
		
		
	}
	
	public void addControlled(String md5,ControlledModel model){
		if(clients.containsKey(md5)){
			clients.get(md5).setControlled(model);
		}else{
			ClientModel client = new ClientModel();
			client.setUsername(md5);
			client.setControlled(model);
			clients.put(md5, client);
		}
	}
	
	
	
	public ClientModel findClientModelByMD5(String md5){
		return clients.get(md5);
	}
	
	public ClientModel findClientModelByName(String username){
		Iterator<Entry<String, ClientModel>> it = clients.entrySet().iterator();
		while(it.hasNext()){
			Entry<String, ClientModel> entry = it.next();
			if(entry.getValue().getUsername().equals(username)){
				return entry.getValue();
			}
			
		}
		return null;
	}
	
	
}
