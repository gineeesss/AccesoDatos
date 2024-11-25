package jdbcM0;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
	List<Usuario> listar();
	boolean eliminar(int id);

	void agregar(Usuario usuario);

	void actualiazr(Usuario usuario);

}
