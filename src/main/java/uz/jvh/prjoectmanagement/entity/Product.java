package uz.jvh.prjoectmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseEntity {
    private String name;


    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(unique = true)
    private String gitRepo;

    @OneToOne
    private UserEntity owner;

    @ManyToOne
    private Team team;


}
