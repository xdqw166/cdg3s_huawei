package dynastxu.cdg3s_huawei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends
        JpaRepository<T, ID>,
        CrudRepository<T, ID> {
}
