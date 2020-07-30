package cl.awake.psegurito.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	@Query(value="Select * from usuario u where u.nickname=?1", nativeQuery=true)
	 Usuario getByNickname(String nickname);
	@Modifying
	@Query(value="Update usuario u set u.nickname= :nickname, u.password= :password, u.rol= :rol where u.id_usuario= :id_usuario", nativeQuery=true)
	 void updateUserNicknameById(
			 @Param("nickname") String nickname,
			 @Param("password")String password,
			 @Param("rol") String rol,
	 		 @Param("id_usuario") int id_usuario);
}
