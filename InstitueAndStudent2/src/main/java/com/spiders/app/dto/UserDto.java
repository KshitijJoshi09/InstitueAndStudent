package com.spiders.app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "table_user")
public class UserDto implements Serializable {

	@Id
	@GenericGenerator(name = "inc", strategy = "increment")
	@GeneratedValue(generator = "inc")
	private long userId;
	
	@Column(name = "admin_id", nullable= false)
	private long adminId;
	
	@Column(name = "first_name", length = 200)
	@NotEmpty(message = "First Name cant be empty")
	private String firstName;

	@Column(name = "last_name", length = 200)
	@NotEmpty(message = "Last Name cant be empty")
	private String lastName;

	// @Email
	@Pattern(regexp = ".+@.+\\..+", message = "Wrong email! ")
	@Column(name = "", unique = true, nullable = false)
	private String email;

	@Size(min = 3, max = 15, message = "user name too small!")
	@Column(name = "user_name", unique = true, nullable = false)
	private String userName;

	@Column(name = "password", nullable = false)
	@NotEmpty(message = "password cant be empty")
	private String password;

	// private Date dob
	// @Min(value = 12)
	// @Max(value=60)
	@Range(min = 12, max = 60, message = "age should be bte 12 and 60")
	private int age;

	@Column(name = "mobile_number")
	private String mobileNo;

	@Column(name = "role")
//	@NotEmpty(message = "define role please")
	private String role;

	@Column(name = "department")
	@NotEmpty(message = "please eheck one box")
	private String department;

	@Embedded
	private Address address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", adminId=" + adminId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", userName=" + userName + ", password=" + password + ", age=" + age
				+ ", mobileNo=" + mobileNo + ", role=" + role + ", department=" + department + ", address=" + address
				+ "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public UserDto(String firstName, String lastName, String email, String userName, String password, String mobileNo,
			String role, String department, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.mobileNo = mobileNo;
		this.role = role;
		this.department = department;
		this.address = address;
	}
	/*
	 * public Date getDob() { return dob; }
	 * 
	 * public void setDob(Date dob) { this.dob = dob; }
	 * 
	 */

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

}
