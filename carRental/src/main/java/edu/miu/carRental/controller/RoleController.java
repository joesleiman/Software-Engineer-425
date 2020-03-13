package edu.miu.carRental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.carRental.domain.Role;
import edu.miu.carRental.service.RoleService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/carrental/admin/role", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)

public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping(value = "/list")
    public List<Role> list() {
        return roleService.findAll();
    }
    
    @PostMapping(value = "/add")
    public Role addNewRole(@Valid @RequestBody Role role) {
        return roleService.save(role);
    }
    
    @DeleteMapping(value = "/delete/{roleId}")
    public void deleteRole(@PathVariable Long roleId) {
        roleService.delete(roleId);
    }
}
