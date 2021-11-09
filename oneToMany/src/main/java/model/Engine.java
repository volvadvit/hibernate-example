package model;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Engine {

    private int id;
    private String name;
    private int power;
    private String carMark;
    private Set<Car> cars;
}
