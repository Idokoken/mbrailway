package ndgroups.mbrailway.repository;

import ndgroups.mbrailway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query(value = "select from * from users where email = ?1", nativeQuery = true)
    Optional <User> findByEmail(String email);
//    List<User> findByEmail(String email);

}
