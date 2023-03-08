package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.ClientEntity;
import com.example.demo.Service.ClientService;

@RestController
@CrossOrigin
public class ClientController {
	
	@Autowired
	ClientService Cservice;
	
	@GetMapping("/showDetails")
	public List <ClientEntity> show() {
		return Cservice.showDetails();
	}
	@GetMapping("/showDetails/{id}")
	public Optional<ClientEntity> getById(@PathVariable int id) {
		return Cservice.getById(id);
	}
	
	@PutMapping("/updateDetails")
	public String update(@RequestBody ClientEntity ee) {
		return Cservice.updateDetails(ee);
	}
	
	@DeleteMapping("/deleteDetails/{eid}")
	public String delete(@PathVariable("eid") int id) {
		return Cservice.deleteDetails(id);
	}
	
	@PostMapping("/addDetails")
	public String add(@RequestBody ClientEntity ee) {
		return Cservice.addDetails(ee);
	}
	
	@GetMapping("/sortedDetails/{field}")
	public List <ClientEntity> sort(@PathVariable String field){
		return Cservice.sortByField(field);
	}
	@GetMapping("/pagination")
	public List <ClientEntity> pagination(@RequestParam int offset,@RequestParam int pagesize){
		return Cservice.getWithPagination(offset,pagesize);
	}

}