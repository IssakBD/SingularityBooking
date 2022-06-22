package kz.arab.SingularityHackathon.demo.repository;

import kz.arab.SingularityHackathon.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
