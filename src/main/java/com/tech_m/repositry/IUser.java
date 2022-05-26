 package com.tech_m.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech_m.entity.User;

import antlr.collections.List;


@Repository	
public interface IUser extends JpaRepository<User, Long> {
	
	public Optional<User> deleteByfirstName(String firstNmae);

	public Optional<User> findByfirstName(String firstName);

}
