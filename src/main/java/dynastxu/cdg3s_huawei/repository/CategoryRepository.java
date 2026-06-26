package dynastxu.cdg3s_huawei.repository;

import dynastxu.cdg3s_huawei.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Integer> {

    Optional<Category> findByName(String name);

    List<Category> findAllByParent(Category parent);

    List<Category> findAllByParentIsNull();

    void deleteCategoryById(Long id);
}
