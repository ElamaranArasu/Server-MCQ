package com.ela.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.ela.Questions;

@Component
@Repository
public interface PsRepo extends CrudRepository<Questions,Integer>{
	
	@Query("FROM Questions WHERE QNO BETWEEN :value1 AND :value2")
	public Iterable<Questions> find(@Param("value1") int value1,@Param("value2") int value2);
}
