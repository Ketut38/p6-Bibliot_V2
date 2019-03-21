package org.occ.p3.consumer.repository;


import org.occ.p3.model.Book;

import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Integer>{

}
