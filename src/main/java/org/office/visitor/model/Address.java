package org.office.visitor.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Address
 *
 */

@Entity(name = "Address")
@Table(name = "address")
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id", updatable = false, nullable = false)
	private Long addressId;
	
	@NotNull
	@Size(min = 3, max = 25)
	private String address;
	
	@NotNull
	private String postalCode;
	
	@NotNull
	@Size(min = 3, max = 25)
	private String district;
	
	@NotNull
	@Size(min = 3, max = 25)
	private String city;
	
	@NotNull
	@Size(min = 3, max = 25)
	private String country;
	
	@OneToMany(
			mappedBy = "address",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<User> users = new HashSet<>();
	
	private static final long serialVersionUID = 1L;

	public Address() {
		super();
	} 
	
	public Address(Long addressId, String address, String postalCode, String district, String city, String country) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.postalCode = postalCode;
		this.district = district;
		this.city = city;
		this.country = country;
	}

	public Long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}   
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}   
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}   
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		users.add(user);
		user.setAddress(this);
	}
	
	public void removeStaff(User user) {
		users.remove(user);
		user.setAddress(null);
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, addressId, city, country, district, postalCode);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Address address = (Address) obj;
		
		return Objects.equals(address, address.address) && Objects.equals(addressId, address.addressId)
				&& Objects.equals(city, address.city) && Objects.equals(country, address.country)
				&& Objects.equals(district, address.district) && Objects.equals(postalCode, address.postalCode);
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", address=" + address + ", postalCode=" + postalCode + ", district="
				+ district + ", city=" + city + ", country=" + country + "]";
	}
   
}
