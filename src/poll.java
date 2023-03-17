package src;

import org.openqa.selenium.WebDriver;

import java.util.Optional;

public interface poll {

    // should return the Interface of the class page object of the homePage
    public void soumettreVoeux(String nom, String mail, Optional<String> ics, Optional<Boolean> has_meal);

    // should return the Interface of the class page object of the homePage
    public void ajouterCommentaire(String comment, String commentdesc);


}
