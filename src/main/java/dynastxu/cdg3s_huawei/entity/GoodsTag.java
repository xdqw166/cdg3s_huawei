package dynastxu.cdg3s_huawei.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoodsTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String name;

    private String color;

    private String description;

    public GoodsTag(@NotNull String name) {
        this.name = name;
    }

    public GoodsTag(@NotNull String name, String color, String description) {
        this.name = name;
        this.color = color;
        this.description = description;
    }
}
