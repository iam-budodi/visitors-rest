package org.office.visitor.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Department
 *
 */

@Entity(name = "Department")
@Table(name = "department")
public class Department implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_id", updatable = false, nullable = false)
	private Long deptId;

	@NotNull
	@NotEmpty
	@Size(min = 2, max = 64)
	@Column(name = "department_name", length = 64)
	private String departmentName;

	@NotNull
	@NotEmpty
	@Size(min = 2, max = 2000)
	@Column(name = "department_function", length = 2000)
	private String departmentFunction;
	
	@OneToMany(
			mappedBy = "department",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Staff> staffs = new HashSet<>();
	
	private static final long serialVersionUID = 1L;

	public Department() {
		super();
	}

	public Department(Long deptId, String departmentName, String departmentFunction) {
		super();
		this.deptId = deptId;
		this.departmentName = departmentName;
		this.departmentFunction = departmentFunction;
	}

	public Long getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeparmentName() {
		return this.departmentName;
	}

	public void setDeparmentName(String deparmentName) {
		this.departmentName = deparmentName;
	}

	public String getDepartmentFunction() {
		return this.departmentFunction;
	}

	public void setDepartmentFunction(String departmentFunction) {
		this.departmentFunction = departmentFunction;
	}
	
	public Set<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}

	public void addStaff(Staff staff) {
		staffs.add(staff);
		staff.setDepartment(this);
	}
	
	public void removeStaff(Staff staff) {
		staffs.remove(staff);
		staff.setDepartment(null);
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentFunction, departmentName, deptId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Department dept = (Department) obj;
		
		return Objects.equals(departmentFunction, dept.departmentFunction)
				&& Objects.equals(departmentName, dept.departmentName) && Objects.equals(deptId, dept.deptId);
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", departmentName=" + departmentName + ", departmentFunction="
				+ departmentFunction + "]";
	}

}
