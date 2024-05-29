package vet.application.service;

import vet.application.db.MainRepo;
import vet.application.models.Pet;

import java.time.LocalDate;
import java.util.Objects;

public class AddPetService {
    public String addPetProperty(String id, String name, String species, LocalDate birthdate) {
        String errorMessage = isInputValid(id, name, species, birthdate);
        if (errorMessage != null) return errorMessage;

        if (MainRepo.getPets().stream().anyMatch(pet -> pet.getPetID().equals(id))) {
            return "В базата съществува запис с този идентификационен номер.";
        }

        Pet pet = new Pet(id, 1L, name, species, birthdate);
        MainRepo.getPets().add(pet);

        return "Успешно добавяне на домашен любимец.";
    }

    private static String isInputValid(String id, String name, String species, LocalDate birthDate) {
        if (Objects.isNull(birthDate)) {
            return "Попълнете датата на раждане.";
        }
        if (!name.isBlank() && !name.matches("^[\\p{L}\\u0400-\\u04FF\\s]+$")) {
            return "Името може да съдържа само текст.";
        }
        if (!species.isBlank() && !species.matches("^[\\p{L}\\u0400-\\u04FF\\s]+$")) {
            return "Породата може да съдържа само текст.";
        }
        if (id.isEmpty()) {
            return "Попълнете идентификационен номер на животното.";
        }
        if (name.isEmpty()) {
            return "Попълнете име на животното.";
        }
        if (species.isEmpty()) {
            return "Попълнете порода на животното.";
        }
        if (id.length() > 10) {
            return "Идентификационният номер е прекалено дълъг (до 10 символа).";
        }
        if (name.length() > 25) {
            return "Името е прекалено дълго (до 25 символа).";
        }
        if (species.length() > 50) {
            return "Породата е прекалено дълга (до 50 символа).";
        }
        return null;
    }
}
