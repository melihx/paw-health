package vet.application.propertyaddpet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vet.application.service.AddPetService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class AddPet {
    private String petID;
    private String name;
    private String species;
    private LocalDate birthdate;
    private String message;

    @Given("Ветеринарят избира добавяне на любимец")
    public void selectAddPet() {
    }

    @When("въведе име {string}")
    public void addName(String name) {
        this.name = name;
    }

    @When("въведе порода {string}")
    public void addSpecies(String species) {
        this.species = species;
    }

    @When("въведе идентификационен номер {string}")
    public void addID(String id) {
        this.petID = id;
    }

    @When("въведе дата на раждане {string}")
    public void addBirthDate(String birthdate) {
        if (!birthdate.isBlank())
            this.birthdate = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @When("натисне бутона за запис")
    public void submit() {
        AddPetService petService = new AddPetService();
        message = petService.addPetProperty(petID, name, species, birthdate);
    }

    @Then("вижда съобщение {string}")
    public void checkMessage(String expectedMessage) {
        assertEquals(expectedMessage, message);
    }

}
