package com.apex.EmployeResource;

import javax.ws.rs.core.Response;

import com.apex.Employe.EmployeModel;

public interface PersonService {
	 
	public Response addPerson(EmployeModel p);
	public Response deletePerson(int id);
    public EmployeModel getPerson(int id);
	
	public EmployeModel[] getAllPersons();

}
	


