package net.javaguides.model;
import jakarta.persistence.*;

@Entity
@Table(name = "contact_info")
public class ContactInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cont_info_id")
	private Long id;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	private String email;
	
	@OneToOne
	@JoinColumn(name = "cont_info_id")
	private Client client; //owner of this info
	
	public ContactInfo() {}
	
	
	
	public ContactInfo(String phoneNumber, String email, Client client) {
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.client = client;
	}

	public ContactInfo(String phoneNumber, String email) {
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}



	@Override
	public String toString() {
		return "ContactInfo [phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

	
}
