package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.poly.shop.domain.Category;

public interface CategoryService {

	

	void deleteAll();

	void deleteAll(Iterable<? extends Category> entities);

	void delete(Category entity);

	void deleteById(Long id);

	long count();

	<S extends Category> boolean exists(Example<S> example);

	void deleteAllInBatch();

	boolean existsById(Long id);

	<S extends Category> S saveAndFlush(S entity);

	void flush();

	Optional<Category> findById(Long id);

	<S extends Category> List<S> saveAll(Iterable<S> entities);

	List<Category> findAllById(Iterable<Long> ids);

	List<Category> findAll(Sort sort);

	List<Category> findAll();

	Page<Category> findAll(Pageable pageable);

	<S extends Category> S save(S entity);

	List<Category> findByNameContaining(String name);

	Page<Category> findByNameContaining(String name, Pageable pageable);
	

	
	
}
