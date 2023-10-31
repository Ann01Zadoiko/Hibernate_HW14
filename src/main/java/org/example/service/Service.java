package org.example.service;

public interface Service <T,E>{

    void save(T entity);
    T findById(E id);
    void update(T entity);
    void delete(T entity);
}
