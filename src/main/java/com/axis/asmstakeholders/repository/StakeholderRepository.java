package com.axis.asmstakeholders.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axis.asmstakeholders.entity.Stakeholder;

@Repository
public interface StakeholderRepository extends CrudRepository<Stakeholder, String>{

}
