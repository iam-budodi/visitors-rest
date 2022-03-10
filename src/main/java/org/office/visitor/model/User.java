package org.office.visitor.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Entity implementation class for Entity: User
 *
 */

@Entity(name = "User")
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_identifier", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("User")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;
	
	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "first_name", length = 50, nullable = false)
    @Pattern(regexp = "[A-Za-z]*", message = "must contain only letters")
	protected String firstName;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "middle_name", length = 50, nullable = true)
    @Pattern(regexp = "[A-Za-z]*", message = "must contain only letters")
	protected String middleName;
	
	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "last_name", length = 50, nullable = false)
    @Pattern(regexp = "[A-Za-z]*", message = "must contain only letters")
	protected String lastName;
	
	@NotNull
    @NotEmpty(message = "not a well-formed email address")
    @Email(message = "not a well-formed email address")
	protected String email;
	
	@NotNull
    @Size(min = 10, max = 12, message = "size must be between 10 and 12")
    @Digits(fraction = 0, integer = 12)
    @Column(name = "phone_number")
	protected String phoneNumber;
	
	@NotNull
	@Size(min = 4, max = 12)
	@Column(name = "user_name", length = 12, nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){1,18}[a-zA-Z0-9]$", message = "invalid username")
	protected String userName;
	
	@NotNull
	@Size(min = 8, max = 256)
	@Column(length = 256, nullable = false)
	protected String password;
	
	protected Long addressId;
	
	@CreationTimestamp
	@Column(name = "created_on")
	protected LocalDateTime createdOn;
	
	@UpdateTimestamp
	@Column(name = "updated_on")
	protected LocalDateTime updatedOn;
	private static final long serialVersionUID = 1L;

//	public User() {
//		super();
//	} 
//	
//	public User(String firstName, String middleName, String lastName, String email, String phoneNumber, String userName,
//			String password) {
//		super();
//		this.firstName = firstName;
//		this.middleName = middleName;
//		this.lastName = lastName;
//		this.email = email;
//		this.phoneNumber = phoneNumber;
//		this.userName = userName;
//		this.password = password;
//	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	public LocalDateTime getCreatedAt() {
		return this.createdOn;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdOn = createdAt;
	}
	
	public LocalDateTime getUpdatedAt() {
		return this.updatedOn;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedOn = updatedAt;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", userName=" + userName + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, lastName, middleName, password, phoneNumber, userId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		User user = (User) obj;
		
		return Objects.equals(email, user.email) && Objects.equals(firstName, user.firstName)
				&& Objects.equals(lastName, user.lastName) && Objects.equals(middleName, user.middleName)
				&& Objects.equals(password, user.password) && Objects.equals(phoneNumber, user.phoneNumber)
				&& Objects.equals(userId, user.userId) && Objects.equals(userName, user.userName);
	}
}
