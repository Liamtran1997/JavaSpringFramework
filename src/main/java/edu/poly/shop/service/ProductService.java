package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.poly.shop.domain.Product;

public interface ProductService {

	void deleteAll();

	void deleteAll(Iterable<? extends Product> entities);

	void delete(Product entity);

	<S extends Product> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(Long id);

	long count();

	<S extends Product> List<S> findAll(Example<S> example);

	<S extends Product> boolean exists(Example<S> example);

	<S extends Product> long count(Example<S> example);

	Product getOne(Long id);

	void deleteAllInBatch();

	<S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Product> entities);

	boolean existsById(Long id);

	<S extends Product> S saveAndFlush(S entity);

	void flush();

	Optional<Product> findById(Long id);

	<S extends Product> List<S> saveAll(Iterable<S> entities);

	List<Product> findAllById(Iterable<Long> ids);

	List<Product> findAll(Sort sort);

	List<Product> findAll();

	Page<Product> findAll(Pageable pageable);

	<S extends Product> Optional<S> findOne(Example<S> example);

	<S extends Product> S save(S entity);

}
