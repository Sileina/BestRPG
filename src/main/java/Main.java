import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //INSTANCIE LES CLASSES ET INTERFACE
        final Scanner userInput = new Scanner(System.in);
        AttackManager atk = new AttackManagerImpl();
        CreationManager crea = new CreationManagerImpl();
        RoundImpl round = new RoundImpl();
        Personnage mage = new Personnage(RoleList.MAGE);
        Personnage paladin = new Personnage(RoleList.PALADIN);
        Personnage soigneur = new Personnage(RoleList.SOIGNEUR);
        Personnage guerrier = new Personnage(RoleList.GUERRIER);
        Personnage boss = new Personnage(RoleList.BOSS);
        String separator = "____________________________________________________________";


        //ON CREE UNE LISTE CONTENANT TOUS NOS HEROS
        List<Personnage> Heros = new ArrayList<Personnage>();
        Heros.add(mage);
        Heros.add(paladin);
        Heros.add(soigneur);
        Heros.add(guerrier);

        //POUR CHAQUE HERO ON LEUR ATTRIBUE DES STATS QUI SERONT SELECTIONNES SELONS LEURS ROLE
        for (Personnage hero : Heros) {
            crea.creation(hero);
        }

        //ON ATTRIBUE LES STATS DU BOSS
        crea.creation(boss);

        System.out.println("Bienvenue jeunes Heros! Serez vous à la hauteur pour terraser la menace qui plane sur vous?");

        Integer tour = 1;
        //tant que le boss a tous ses pv ou que les heros sont présents dans la liste le combat continu

        round.battleRound(separator,tour, atk, boss, mage, paladin, soigneur, guerrier, Heros);


    }



}

