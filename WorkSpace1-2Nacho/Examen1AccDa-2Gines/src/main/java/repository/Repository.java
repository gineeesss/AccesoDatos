package repository;

public interface Repository<Coche> {
	void insertar(Coche coche);
	void actualizar(String matricula, String marca, String modelo);
	void eliminar(String matricula);
}
