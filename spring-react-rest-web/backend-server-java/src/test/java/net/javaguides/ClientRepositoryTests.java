package net.javaguides;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import net.javaguides.model.Client;
import net.javaguides.model.ContactInfo;
import net.javaguides.repository.ClientRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ClientRepositoryTests {

	@Autowired
	private ClientRepository clientRepo;
	
	@Test
	public void testAddClient() {
		ContactInfo info = new ContactInfo("+38 063 333 33 33", "eeee@gmail.com");
		Client client = new Client("Pasha", info);
		Client savedClient = clientRepo.save(client);
		assertThat(savedClient).isNotNull();
	}
}
