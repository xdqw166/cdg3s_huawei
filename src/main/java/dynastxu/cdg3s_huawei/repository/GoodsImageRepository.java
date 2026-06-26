package dynastxu.cdg3s_huawei.repository;

import dynastxu.cdg3s_huawei.entity.GoodsImage;

import java.util.List;

public interface GoodsImageRepository extends BaseRepository<GoodsImage, Long> {
    List<GoodsImage> findByImagePath(String imagePath);
}
