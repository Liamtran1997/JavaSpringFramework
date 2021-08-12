package edu.poly.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Category;
import edu.poly.shop.repository.CategoryRepository;
import edu.poly.shop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	
	@Override
	public Page<Category> findByNameContaining(String name, Pageable pageable) {
		return categoryRepository.findByNameContaining(name, pageable);
	}



	@Override
	public List<Category> findByNameContaining(String name) {
		return categoryRepository.findByNameContaining(name);
	}


	@Override
	public <S extends Category> S save(S entity) {
		return categoryRepository.save(entity);
	}


	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}


	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}


	@Override
	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}


	@Override
	public List<Category> findAllById(Iterable<Long> ids) {
		return categoryRepository.findAllById(ids);
	}


	@Override
	public <S extends Category> List<S> saveAll(Iterable<S> entities) {
		return categoryRepository.saveAll(entities);
	}


	@Override
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}


	@Override
	public void flush() {
		categoryRepository.flush();
	}


	@Override
	public <S extends Category> S saveAndFlush(S entity) {
		return categoryRepository.saveAndFlush(entity);
	}


	@Override
	public boolean existsById(Long id) {
		return categoryRepository.existsById(id);
	}


	@Override
	public void deleteAllInBatch() {
		categoryRepository.deleteAllInBatch();
	}


	@Override
	public <S extends Category> boolean exists(Example<S> example) {
		return categoryRepository.exists(example);
	}


	@Override
	public long count() {
		return categoryRepository.count();
	}


	@Override
	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}


	@Override
	public void delete(Category entity) {
		categoryRepository.delete(entity);
	}


	@Override
	public void deleteAll(Iterable<? extends Category> entities) {
		categoryRepository.deleteAll(entities);
	}


	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}
	
	
	
	
}
