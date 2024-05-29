package vet.application.db;

import lombok.Getter;
import vet.application.models.Pet;
import vet.application.models.Visit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class MainRepo {
    @Getter
    private static List<Pet> pets = new ArrayList<>();
    @Getter
    private static List<Visit> visits = new ArrayList<>();

    static {
        pets.add(new Pet("2658377503", 1L, "Коко", "Златна риба", LocalDate.of(2020, 06, 17)));
    }
}
