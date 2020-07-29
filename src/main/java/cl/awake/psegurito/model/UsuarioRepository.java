package cl.awake.psegurito.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	@Query(value="Select * from usuario u where u.nickname=?1", nativeQuery=true)
	 Usuario getByNickname(String nickname);
}
