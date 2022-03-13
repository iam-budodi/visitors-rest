package org.office.visitor.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Staff
 *
 */

@Entity(name = "Staff")
@DiscriminatorValue("SUser")
public class Staff extends User implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY)
	private Department department;
	
	private static final long serialVersionUID = 1L;

	public Staff() {
		super();
	}  
	
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
