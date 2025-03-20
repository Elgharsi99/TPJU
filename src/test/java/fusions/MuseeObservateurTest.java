package fusions;

import fusion.MuseeObservateur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MuseeObservateurTest {// envoie une alerte au musée lorsque l’œuvre est récupérée.
    private MuseeObservateur musee;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        musee = new MuseeObservateur("Louvre");
        System.setOut(new PrintStream(outputStreamCaptor)); // Capture la sortie console
    }

    @Test
    void testMiseAJour() { //Vérifie que le bon message d’alerte est affiché.
        musee.miseAJour("Nouvelle œuvre récupérée !");
        String expectedOutput = "🏛 [Musée Louvre] ALERTE : Nouvelle œuvre récupérée !";
        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim(), "Le message envoyé au musée doit être correct.");
    }
}
