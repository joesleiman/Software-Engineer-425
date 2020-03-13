package edu.miu.carRental.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.carRental.domain.Role;
import edu.miu.carRental.repository.RoleRepository;
import edu.miu.carRental.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role save(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(id);
		
	}

}
