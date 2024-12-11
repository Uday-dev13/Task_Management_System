package task.projectt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.projectt.Entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
}
