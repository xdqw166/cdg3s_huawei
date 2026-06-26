package dynastxu.cdg3s_huawei.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoodsImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String imagePath;

    private Integer sortOrder;

    private String caption;

    public GoodsImage(@NotNull String imagePath) {
        this.imagePath = imagePath;
    }

    public GoodsImage(@NotNull String imagePath, Integer sortOrder, String caption) {
        this.imagePath = imagePath;
        this.sortOrder = sortOrder;
        this.caption = caption;
    }
}
