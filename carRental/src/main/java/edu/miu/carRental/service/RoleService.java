package edu.miu.carRental.service;

import java.util.List;

import edu.miu.carRental.domain.Role;

public interface RoleService {
	
	public List<Role> findAll();

	public Role save(Role role);

	public void delete(Long id);

}
