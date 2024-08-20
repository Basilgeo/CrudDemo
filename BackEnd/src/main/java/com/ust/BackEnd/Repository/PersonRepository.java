package com.ust.BackEnd.Repository;


import com.ust.BackEnd.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
