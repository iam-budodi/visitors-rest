package org.office.visitor.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Visitor
 *
 */

@Entity(name = "Visitor")
@DiscriminatorValue("VUser")
public class Visitor extends User implements Serializable {

	@NotNull
	@Size(max = 1)
	@Column(length = 1)
	private Character gender;

	@Past
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(length = 512)
	private String avatar;

	@Transient
	private Integer age;
	private static final long serialVersionUID = 1L;

	public Visitor() {
		super();
	}

	public Visitor(String firstName, String middleName, String lastName, String email, String phoneNumber,
			String userName, String password, Character gender, LocalDate dateOfBirth, String avatar) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.avatar = avatar;
	}

	public Character getGender() {
		return this.gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(age, avatar, dateOfBirth, gender);
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

		Visitor visitor = (Visitor) obj;
		return Objects.equals(age, visitor.age) && Objects.equals(avatar, visitor.avatar)
				&& Objects.equals(dateOfBirth, visitor.dateOfBirth) && Objects.equals(gender, visitor.gender);
	}

	@Override
	public String toString() {
		return "Visitor [gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", avatar=" + avatar + ", age=" + age
				+ "]";
	}

}
