package repository;

import java.util.List;

import entities.Persona;

public interface Repository <T>{
	List<T> findAll();
	T findOneById(int id);
	void save(T t);
	void updateById(int id);
	void delete(Persona persona);
	void update(Persona persona);
	void deleteBydId(int id);
}
