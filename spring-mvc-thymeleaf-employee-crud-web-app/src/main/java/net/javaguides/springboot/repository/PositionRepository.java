package net.javaguides.springboot.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {

	Position findByTitle(String title);
}
