## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer
```
public interface poll {

    // should return the Interface of the class page object of the homePage
    public void soumettreVoeux(String nom, String mail, Optional<String> ics, Optional<Boolean> has_meal);

    // should return the Interface of the class page object of the homePage
    public void ajouterCommentaire(String comment, String commentdesc);


}
```