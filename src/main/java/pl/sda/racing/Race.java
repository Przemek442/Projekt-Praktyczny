package pl.sda.racing;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class Race {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    List<Pigeon> pigeons;
}
