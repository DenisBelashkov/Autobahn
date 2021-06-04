package app.model;

import com.sun.istack.Nullable;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="trackcells")
@NoArgsConstructor
public class TrackCell {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @Nullable
    private TrackCell nextCell;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @Nullable
    private Car car;

    @Override
    public String toString() {
        return "TrackCell{" +
                "id=" + id +
                ", nextCellId=" + (nextCell == null ? "none" : nextCell.getId()) +
                ", carId=" + (car == null ? "none" : car.getId()) +
                '}';
    }
}
