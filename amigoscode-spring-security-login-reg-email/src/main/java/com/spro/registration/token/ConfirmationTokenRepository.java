package com.spro.registration.token;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ConfirmationTokenRepository 
				extends JpaRepository<ConfirmationToken, Long>{

	Optional<ConfirmationToken> findByToken(String token);

	@Modifying
	@Query("UPDATE ConfirmationToken ct SET ct.confirmedAt = ?1 WHERE ct.id = ?2")
	int setConfirmedAt(LocalDateTime confirmedAt, Long id);
}
