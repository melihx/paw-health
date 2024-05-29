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
public class Visit {
    private long visitID;
    private long veterinarianID;
    private String petID;
    private LocalDate date;
    private String diagnosis;
    private String treatment;
}
