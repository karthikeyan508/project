package com.example.demo.Service;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ClientRepository;
import com.example.demo.Entity.ClientEntity;

@Service
public class ClientService {

	@Autowired
	ClientRepository Crepo;
	public String addDetails(ClientEntity ee) {
		Crepo.save(ee);
		return "Data added";
	}
	
	public String updateDetails(ClientEntity ee) {
		Crepo.saveAndFlush(ee);
		return "Data updated";
	}
	
	public String deleteDetails(int id) {
		Crepo.deleteById(id);
		return "data Deleted";
	}
	public List<ClientEntity> sortByField(String field){
		return Crepo.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public Optional<ClientEntity> getById(int id) {
		return Crepo.findById(id);
	}
	public List<ClientEntity> showDetails(){
		return Crepo.findAll();
	}
	
	public List<ClientEntity> getWithPagination(int offset,int pageSize){
		Page<ClientEntity> page = Crepo.findAll(PageRequest.of(offset,pageSize));
		return page.getContent();
	}
}