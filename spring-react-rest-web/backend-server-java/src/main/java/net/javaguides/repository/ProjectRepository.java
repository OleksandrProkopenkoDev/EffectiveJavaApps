package net.javaguides.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
