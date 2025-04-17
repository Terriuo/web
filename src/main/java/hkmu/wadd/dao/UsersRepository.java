//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.dao;

import hkmu.wadd.model.UsersEntry;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntry, UUID> {
    Optional<UsersEntry> findByUsername(String username);
}
