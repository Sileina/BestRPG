import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //INSTANCIE LES CLASSES ET INTERFACE
        final Scanner userInput = new Scanner(System.in);
        AttackManager atk = new AttackManagerImpl();
        CreationManager crea = new CreationManagerImpl();
        Personnage mage = new Personnage(RoleList.MAGE);
        Personnage paladin = new Personnage(RoleList.PALADIN);
        Personnage soigneur = new Personnage(RoleList.MAGE);
        Personnage guerrier = new Personnage(RoleList.GUERRIER);
        Personnage boss = new Personnage(RoleList.BOSS);


        //ON CREE UNE LISTE CONTENANT TOUS NOS HEROS
        List<Personnage> Heros = new ArrayList<Personnage>();
        Heros.add(mage);
        Heros.add(paladin);
        Heros.add(soigneur);
        Heros.add(guerrier);

        //POUR CHAQUE HERO ON LEUR ATTRIBUE DES STATS QUI SERONT SELECTIONNES SELONS LEURS ROLE
        for(Personnage hero: Heros){
            crea.creation(hero);
        }

        //ON ATTRIBUE LES STATS DU BOSS
        crea.creation(boss);

        System.out.println("Bienvenue jeunes Heros! Serez vous à la hauteur pour terraser la menace qui planne sur vous?");

        Integer tour = 1;
        //tant que le boss a tous ses pv ou que les heros sont présents dans la liste le combat continu
        while(boss.getPv()>0 || Heros.size()>0){
            System.out.println("Tour "+ tour);
            Boolean isDefense = false;


            for(Personnage hero: Heros){
                System.out.println("Tour de Hero " + hero);
                System.out.println("Touche 1: Attaque Normale");
                System.out.println("Touche 2: Compétence Spéciale");
                final Integer attackChoice = userInput.nextInt();
                if(attackChoice == 2){
                    if(hero.getRole() == RoleList.PALADIN){
                         isDefense = true;
                    }else {
                        if(hero.getRole() == RoleList.SOIGNEUR){
                            System.out.println("Qui souhaitez vous soignez?");
                            for (Personnage hero2: Heros){
                                Integer i = 0;
                                System.out.println("Touche " + 0 + ": " + hero2.getNom());
                            }
                            final Integer healChoice = userInput.nextInt();
                            atk.attackSpecial(hero, Heros.get(healChoice));
                        } else{
                            atk.attackSpecial(hero, boss);
                        }
                    }

                } else {
                    atk.attack(hero, boss);
                }


            }

            System.out.println("Le boss vous attaque!");
            atk.attack(boss, Heros.get(0));




        }







    }

}
