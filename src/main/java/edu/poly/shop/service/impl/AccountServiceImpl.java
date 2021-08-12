package edu.poly.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import edu.poly.shop.domain.Account;
import edu.poly.shop.repository.AccountRepository;
import edu.poly.shop.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private BCryptPasswordEncoder  bCryptPasswordEncoder;

	@Override
	public Account login(String username,String password) {
		Optional<Account> opt = findById(username);
		
		if (opt.isPresent() && bCryptPasswordEncoder.
				matches(password,opt.get().getPassword())){ 

			opt.get().setPassword(""); 
			return opt.get(); 
			
		}
		return null;
	}
	
	
	@Override
	public <S extends Account> S save(S entity) {
		Optional<Account> opt = findById(entity.getUsername());

		if (opt.isPresent()) { 
			if (StringUtils.isEmpty(entity.getPassword())) {  
				entity.setPassword(opt.get().getPassword()); 
			}else{
				entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword())); 
			}
			
		}else{
			entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
		} 	
		return accountRepository.save(entity);
	}

	
	@Override
	public <S extends Account> Optional<S> findOne(Example<S> example) {
		return accountRepository.findOne(example);
	}

	@Override
	public Page<Account> findAll(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public List<Account> findAll(Sort sort) {
		return accountRepository.findAll(sort);
	}

	@Override
	public List<Account> findAllById(Iterable<String> ids) {
		return accountRepository.findAllById(ids);
	}

	@Override
	public <S extends Account> List<S> saveAll(Iterable<S> entities) {
		return accountRepository.saveAll(entities);
	}

	@Override
	public Optional<Account> findById(String id) {
		return accountRepository.findById(id);
	}

	@Override
	public void flush() {
		accountRepository.flush();
	}

	@Override
	public <S extends Account> S saveAndFlush(S entity) {
		return accountRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return accountRepository.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<Account> entities) {
		accountRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
		return accountRepository.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		accountRepository.deleteAllInBatch();
	}

	@Override
	public Account getOne(String id) {
		return accountRepository.getOne(id);
	}

	@Override
	public <S extends Account> long count(Example<S> example) {
		return accountRepository.count(example);
	}

	@Override
	public <S extends Account> boolean exists(Example<S> example) {
		return accountRepository.exists(example);
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> example) {
		return accountRepository.findAll(example);
	}

	@Override
	public long count() {
		return accountRepository.count();
	}

	@Override
	public void deleteById(String id) {
		accountRepository.deleteById(id);
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
		return accountRepository.findAll(example, sort);
	}

	@Override
	public void delete(Account entity) {
		accountRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Account> entities) {
		accountRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		accountRepository.deleteAll();
	}
	
	
	
}
