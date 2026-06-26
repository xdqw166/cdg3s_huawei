package dynastxu.cdg3s_huawei.repository;

import dynastxu.cdg3s_huawei.entity.Category;
import dynastxu.cdg3s_huawei.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodsRepository extends BaseRepository<Goods, Integer> {
    Optional<Goods> findByName(String name);

    List<Goods> findByCategory_Id(Long categoryId);
}
