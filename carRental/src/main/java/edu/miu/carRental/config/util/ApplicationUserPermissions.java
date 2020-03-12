package edu.miu.carRental.config.util;

public enum ApplicationUserPermissions {
	ADMIN_READ("admin:read"),
	ADMIN_WRITE("admin:write"),
	EMPLOYEE_READ("employee:read"),
	EMPLOYEE_WRITE("employee:write");
	
	private final String permission;
	
	ApplicationUserPermissions(String permission) {
		this.permission=permission;
	}

	public String getPermission() {
		return permission;
	}

}
