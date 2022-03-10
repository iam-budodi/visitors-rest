package org.office.visitor.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entity implementation class for Entity: Staff
 *
 */
@Entity(name = "Staff")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("SUser")
public class Staff extends User implements Serializable {

	private Long department;
	private static final long serialVersionUID = 1L;

	public Staff() {
		super();
	}   
	public Long getDepartment() {
		return this.department;
	}

	public void setDepartment(Long department) {
		this.department = department;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(department);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		return Objects.equals(department, other.department);
	}
	
	@Override
	public String toString() {
		return "Staff [department=" + department + "]";
	}
   
}
