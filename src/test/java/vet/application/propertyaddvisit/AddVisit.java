package vet.application.propertyaddvisit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vet.application.service.AddVisitService;

import static org.junit.Assert.assertEquals;

public class AddVisit {
    private String petID;
    private String diagnosis;
    private String treatment;
    private String message;

    @Given("Ветеринарят избира нов запис")
    public void selectNewVisit() {
    }

    @When("въведе идентификационен номер {string}")
    public void addPetID(String id) {
        this.petID = id;
    }

    @When("въведе диагноза {string}")
    public void addDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @When("въведе лечение {string}")
    public void addTreatment(String treatment) {
        this.treatment = treatment;
    }

    @When("натисне бутона за добавяне")
    public void submit() {
        AddVisitService visitService = new AddVisitService();
        message = visitService.addVisitProperty(petID, diagnosis, treatment);
    }

    @Then("вижда съобщение {string}")
    public void checkMessage(String expectedMessage) {
        assertEquals(expectedMessage, message);
    }
}
