package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.User;
import dynastxu.cdg3s_huawei.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserRepository> {
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder encoder) {
        super(repository);
        this.passwordEncoder = encoder;
    }

    public User register(String username, String password) throws IllegalArgumentException {
        if (repository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username is already in use");
        }

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(username, encodedPassword);

        return repository.save(user);
    }

    public User login(String username, String rawPassword)
            throws IllegalArgumentException, IllegalStateException {
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("用户名或密码错误"));

        if (user.getLocked()) {
            throw new IllegalStateException("账户已被锁定，请稍后再试");
        }

        if (!user.getEnabled()) {
            throw new IllegalStateException("账户未激活");
        }

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new IllegalArgumentException("用户名或密码错误");
        }

        return user;
    }
}
