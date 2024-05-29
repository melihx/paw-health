package vet.application.service;

import vet.application.db.MainRepo;
import vet.application.models.Visit;

import java.time.LocalDate;

public class AddVisitService {
    public String addVisitProperty(String id, String diagnosis, String treatment) {
        String errorMessage = isInputValid(id, diagnosis, treatment);
        if (errorMessage != null) return errorMessage;

        if (MainRepo.getPets().stream().anyMatch(pet -> pet.getPetID().equals(id))) {
            Visit visit = new Visit(1L, 1L, id, LocalDate.now(), diagnosis, treatment);
            MainRepo.getVisits().add(visit);
        } else {
            return "Домашният любимец не е намерен.";
        }

        return "Успешно добавяне на запис на посещение.";
    }

    private static String isInputValid(String id, String diagnosis, String treatment) {
        if (!diagnosis.isBlank() && !diagnosis.matches("^[\\p{L}\\u0400-\\u04FF\\s]+$")) {
            return "Диагнозата може да съдържа само текст.";
        }
        if (!treatment.isBlank() && !treatment.matches("^[\\p{L}\\u0400-\\u04FF\\s]+$")) {
            return "Полето лечение може да съдържа само текст.";
        }
        if (id.isEmpty()) {
            return "Попълнете идентификационен номер на животното.";
        }
        if (diagnosis.isEmpty()) {
            return "Попълнете диагноза на животното.";
        }
        if (treatment.isEmpty()) {
            return "Попълнете лечение за животното.";
        }
        if (id.length() > 10) {
            return "Идентификационният номер е прекалено дълъг (до 10 символа).";
        }
        if (diagnosis.length() > 50) {
            return "Диагнозата е прекалено дълга (до 50 символа).";
        }
        if (treatment.length() > 100) {
            return "Полето лечение е прекалено дълго (до 100 символа).";
        }
        return null;
    }
}
