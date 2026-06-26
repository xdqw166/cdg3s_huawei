package dynastxu.cdg3s_huawei.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Float price;

    private Float discountedPrice;

    @NotNull
    private Boolean isStartingPrice = false;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    private List<GoodsTag> goodsTag;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category category;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private GoodsImage mainImage;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    private List<GoodsImage> images;

    public Goods(@NotNull Float price, @NotNull String name) {
        this.price = price;
        this.name = name;
    }

    @Builder
    public Goods(
            @NotNull Float price,
            @NotNull String name,
            Float discountedPrice,
            List<GoodsTag> goodsTag,
            Category category,
            GoodsImage mainImage,
            List<GoodsImage> images,
            @NotNull Boolean isStartingPrice
    ) {
        this.price = price;
        this.name = name;
        this.discountedPrice = discountedPrice;
        this.goodsTag = goodsTag;
        this.category = category;
        this.mainImage = mainImage;
        this.images = images;
        this.isStartingPrice = isStartingPrice;
    }
}
