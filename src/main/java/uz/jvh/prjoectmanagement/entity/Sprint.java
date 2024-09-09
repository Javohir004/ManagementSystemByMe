package uz.jvh.prjoectmanagement.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "sprints")
public class Sprint extends BaseEntity {
    @Future
    private LocalDate startDate;

    @Future
    private LocalDate endDate;

    @OneToMany
    private List<Task> tasks;

    @OneToOne
    private Team team;
}
