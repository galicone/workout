package com.workout.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class CredentialsDto {
	
	private UserDTO userDTO;
	
	public CredentialsDto(UserDTO userDTO) {
		super();
		this.userDTO = userDTO;
	}

	public CredentialsDto() {
	}
	
	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public class UserDTO {
	
		private String firstName;
		
		private String lastName;
		
		@NotBlank
		@Email
		@Length(max = 50)
		private String email;
		
		@NotBlank
		@Length(min = 1, max = 30)
		private String password;
		
		public UserDTO() {
		}
		
		public UserDTO(String email, String password, String firstName, String lastName) {
			this.email = email;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
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
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
	}
}
