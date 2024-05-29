package vet.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private String petID;
    private long adderID;
    private String name;
    private String species;
    private LocalDate birthdate;
}
