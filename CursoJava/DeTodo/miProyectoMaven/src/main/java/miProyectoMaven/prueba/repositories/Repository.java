package miProyectoMaven.prueba.repositories;

import java.util.List;

import miProyectoMaven.prueba.entities.Direccion;
import miProyectoMaven.prueba.entities.Persona;
  
// ES COMO SI FUESE EL DAO
public interface Repository<T> {
	List<T> findAll();
	
	T findOneById(int id); //SELECT * FROM ... WHERE ID=
	
	T save(T t); // INSERT INTO ...
	
	void deleteById(int id); 
	
	void updateById(int id); // el ID¿?

	void updateById(int id, T t);
}
