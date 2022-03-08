package az.kapitalbank.birbankuser.repository;

import az.kapitalbank.birbankuser.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
