package miProyectoMaven.prueba.repositories;

import java.util.List;

public interface Repository<T> {
	List<T> findAll();
	T findOneById(int id);
	T save(T t);
	void deleteById(int id);
	void updateById(int id);
}
