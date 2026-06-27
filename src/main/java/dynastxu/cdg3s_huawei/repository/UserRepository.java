package dynastxu.cdg3s_huawei.repository;

import dynastxu.cdg3s_huawei.entity.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User, Integer> {
    Boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
