import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RoundImpl {


    public  void battleRound(String separator, Integer tour, AttackManager atk, Personnage boss, Personnage mage, Personnage paladin, Personnage soigneur, Personnage guerrier, List<Personnage> Heros) {
        System.out.println(separator);
        final Scanner userInput = new Scanner(System.in);

        System.out.println("Tour " + tour);
        Boolean isDefense = false;

        atckHero(isDefense, Heros, boss, atk, userInput);
        System.out.println(isDefense);
        atckBoss(isDefense, Heros, boss, atk, paladin);


        System.out.println(separator);

        System.out.println("Fin du tour " + tour);
        for (Personnage hero : Heros) {
            System.out.println(hero.getNom() + ": " + hero.getPv() + " Pv restant.");
        }
        System.out.println(boss.getNom() + ": " + boss.getPv() + " Pv restant.");
        System.out.println(separator);
        tour++;

        if (boss.getPv() <= 0) {
            System.out.println("Félicitation! Vous êtes venu à bout de cette horrible créature");
        }
        if (Heros.size() <= 0) {
            System.out.println("Le boss vous a anihilé...");
        } else {
            battleRound(separator,tour, atk, boss, mage, paladin, soigneur, guerrier, Heros);
        }
    }

    public  void atckHero(Boolean isDefense, List<Personnage> Heros, Personnage boss, AttackManager atk, Scanner userInput) {
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


    public  void atckBoss(Boolean isDefense, List<Personnage> Heros, Personnage boss, AttackManager atk, Personnage paladin) {
        System.out.println("Le boss vous attaque!");
        if (isDefense == true) {
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
