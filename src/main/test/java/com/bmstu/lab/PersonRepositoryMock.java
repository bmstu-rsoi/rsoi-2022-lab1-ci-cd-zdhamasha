package com.bmstu.lab;

import com.bmstu.lab.repository.PersonEntity;
import com.bmstu.lab.repository.PersonRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonRepositoryMock implements PersonRepository {
    List<PersonEntity>list = new ArrayList<>();
    @Override
    public List<PersonEntity> findAll() {
        return list;
    }

    @Override
    public List<PersonEntity> findAll(Sort sort) {
        return list;
    }

    @Override
    public Page<PersonEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<PersonEntity> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        Optional<PersonEntity> optionalPersonEntity = findById(id);
        if (optionalPersonEntity.isPresent()) {
            list.remove(optionalPersonEntity.get());
        }
    }

    @Override
    public void delete(PersonEntity entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends PersonEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends PersonEntity> S save(S entity) {
        Optional<PersonEntity> optionalPersonEntity = findById(entity.getId());
        if (optionalPersonEntity.isPresent()) {
            list.remove(optionalPersonEntity.get());
        }
        list.add(entity);
        return entity;
    }

    @Override
    public <S extends PersonEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<PersonEntity> findById(Long id) {
        return list.stream().filter( (person) -> person.getId().equals(id)).findFirst();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends PersonEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<PersonEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PersonEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends PersonEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PersonEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PersonEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PersonEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PersonEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PersonEntity> boolean exists(Example<S> example) {
        return false;
    }
}
