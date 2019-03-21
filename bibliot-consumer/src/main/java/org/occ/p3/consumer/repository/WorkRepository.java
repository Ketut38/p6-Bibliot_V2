package org.occ.p3.consumer.repository;

import org.occ.p3.model.Work;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface WorkRepository extends CrudRepository<Work, Integer> {


   List<Work> findByPublicationDate(Integer publicationDate);


    List<Work> findByAuthorIsContainingIgnoreCase(String author);


	

}
