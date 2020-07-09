package com.apex.Employe;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="employe")
public class EmployeModel {

	private String Name;
	private int id;
	private int age;
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return id+"::"+Name+"::"+age;
	}

}
