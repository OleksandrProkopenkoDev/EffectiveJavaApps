package com.spro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spro.entity.IncorrectAnswer;

public interface IncorrectAnswersRepository extends JpaRepository<IncorrectAnswer, Long>{

}
