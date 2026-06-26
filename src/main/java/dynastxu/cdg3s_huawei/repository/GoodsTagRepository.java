package dynastxu.cdg3s_huawei.repository;

import dynastxu.cdg3s_huawei.entity.GoodsTag;

import java.util.Optional;

public interface GoodsTagRepository extends BaseRepository<GoodsTag, Integer> {
    Optional<GoodsTag> findByName(String name);

    Optional<GoodsTag> findById(Long id);
}
