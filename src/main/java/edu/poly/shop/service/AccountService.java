package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.poly.shop.domain.Account;

public interface AccountService {

	void deleteAll();

	void deleteAll(Iterable<? extends Account> entities);

	void delete(Account entity);

	<S extends Account> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(String id);

	long count();

	<S extends Account> List<S> findAll(Example<S> example);

	<S extends Account> boolean exists(Example<S> example);

	<S extends Account> long count(Example<S> example);

	Account getOne(String id);

	void deleteAllInBatch();

	<S extends Account> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Account> entities);

	boolean existsById(String id);

	<S extends Account> S saveAndFlush(S entity);

	void flush();

	Optional<Account> findById(String id);

	<S extends Account> List<S> saveAll(Iterable<S> entities);

	List<Account> findAllById(Iterable<String> ids);

	List<Account> findAll(Sort sort);

	List<Account> findAll();

	Page<Account> findAll(Pageable pageable);

	<S extends Account> Optional<S> findOne(Example<S> example);

	<S extends Account> S save(S entity);

	Account login(String username, String password);


}
