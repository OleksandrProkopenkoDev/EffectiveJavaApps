package net.javaguides.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.model.ProjectInfo;

public interface ProjectInfoRepository extends JpaRepository<ProjectInfo, Long>{

}
