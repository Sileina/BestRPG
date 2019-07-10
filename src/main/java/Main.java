import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        //INSTANCIE LES CLASSES ET INTERFACE
        final Scanner userInput = new Scanner(System.in);
        AttackManager atk = new AttackManagerImpl();
        CreationManager crea = new CreationManagerImpl();
        Personnage mage = new Personnage(RoleList.MAGE);
        Personnage paladin = new Personnage(RoleList.PALADIN);
        Personnage soigneur = new Personnage(RoleList.SOIGNEUR);
        Personnage guerrier = new Personnage(RoleList.GUERRIER);
        Personnage boss = new Personnage(RoleList.BOSS);


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

        battleRound(tour, atk, boss, mage, paladin, soigneur, guerrier, Heros);


    }

    public static void battleRound(Integer tour, AttackManager atk, Personnage boss, Personnage mage, Personnage paladin, Personnage soigneur, Personnage guerrier, List<Personnage> Heros) {
        System.out.println("___________________________________________________");
        final Scanner userInput = new Scanner(System.in);

        System.out.println("Tour " + tour);
        Boolean isDefense = false;

        atckHero(isDefense, Heros, boss, atk, userInput);
        System.out.println(isDefense);
        atckBoss(isDefense, Heros, boss, atk, paladin);


        System.out.println("___________________________________________________");

        System.out.println("Fin du tour " + tour);
        for (Personnage hero : Heros) {
            System.out.println(hero.getNom() + ": " + hero.getPv() + " Pv restant.");
        }
        System.out.println(boss.getNom() + ": " + boss.getPv() + " Pv restant.");
        System.out.println("___________________________________________________");
        tour++;

        if (boss.getPv() <= 0) {
            System.out.println("Félicitation! Vous êtes venu à bout de cette horrible créature");
        }
        if (Heros.size() <= 0) {
            System.out.println("Le boss vous a anihilé...");
        } else {
            battleRound(tour, atk, boss, mage, paladin, soigneur, guerrier, Heros);
        }
    }

    public static void atckHero(Boolean isDefense, List<Personnage> Heros, Personnage boss, AttackManager atk, Scanner userInput) {
        for (Personnage hero : Heros) {
            System.out.println("Tour de Hero " + hero.getNom());
            System.out.println("Touche 1: Attaque Normale");
            System.out.println("Touche 2: Compétence Spéciale");
            final Integer attackChoice = userInput.nextInt();
            if (attackChoice == 2) {
                if (hero.getRole() == RoleList.PALADIN) {
                    isDefense = true;
                    System.out.println("Le Paladin se prépare à défendre");
                } else {
                    if (hero.getRole() == RoleList.SOIGNEUR) {
                        System.out.println("Qui souhaitez vous soignez?");
                        for (Personnage hero2 : Heros) {
                            Integer i = 0;
                            System.out.println("Touche " + i + ": " + hero2.getNom());
                        }
                        final Integer healChoice = userInput.nextInt();
                        atk.attackSpecial(hero, Heros.get(healChoice));
                    } else {
                        atk.attackSpecial(hero, boss);
                    }
                }

            } else {
                atk.attack(hero, boss);

            }


        }
    }


    public static void atckBoss(Boolean isDefense, List<Personnage> Heros, Personnage boss, AttackManager atk, Personnage paladin) {
        System.out.println("Le boss vous attaque!");
        if (isDefense) {
            atk.attack(boss, paladin);
            if (paladin.getPv() <= 0) {
                System.out.println(paladin.getNom() + " est mort. Paix à son âme.");
                Heros.remove(paladin);
            }
        } else {
            Integer heroAleatoire = 0;
            if (Heros.size() != 0) {
                heroAleatoire = ThreadLocalRandom.current().nextInt(0, (Heros.size()));
            }

            atk.attack(boss, Heros.get(heroAleatoire));
            if (Heros.get(heroAleatoire).getPv() <= 0) {
                System.out.println(Heros.get(heroAleatoire).getNom() + " est mort. Paix à son âme.");
                Heros.remove(Heros.get(heroAleatoire));
            }
        }
    }

}

