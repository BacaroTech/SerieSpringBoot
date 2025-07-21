package bacarotech.serie.springboot.repository;

import bacarotech.serie.springboot.model.Todo;
import bacarotech.serie.springboot.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    public List<Todo> findByUser(User user);

    @Modifying
    @Transactional
    @Query("DELETE FROM Todo t WHERE t.id = :id")
    public int delete(@Param("id") long id);
}
