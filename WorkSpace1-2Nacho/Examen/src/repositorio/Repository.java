package repositorio;

public interface Repository<T> {

	void insertar(T t);
	void actualizar(String matricula, T t);
	void eliminar(String matricula);
}
