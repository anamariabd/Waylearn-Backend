package com.app.waylearn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.waylearn.Entities.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{

}
