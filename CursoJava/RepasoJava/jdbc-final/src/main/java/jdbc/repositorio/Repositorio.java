package jdbc.repositorio;

import java.util.List;

public interface Repositorio<T> {
	List<T> listar();
	T porId(Long id);
	boolean guardar(T t);
	boolean eliminar(Long id);
}
