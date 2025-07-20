package bacarotech.serie.springboot.repository;

import bacarotech.serie.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("DELETE FROM User u WHERE u.id = :id")
    public int delete(@Param("id") long id);
}
