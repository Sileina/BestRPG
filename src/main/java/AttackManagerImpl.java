import java.util.concurrent.ThreadLocalRandom;

public class AttackManagerImpl implements AttackManager {
    @Override
    public void attack(Personnage att, Personnage cible) {
        cible.setPv(cible.getPv() - (att.getAttaque()-cible.getDefense()));
        System.out.println(att.getNom()+ " inflige " + (att.getAttaque()-cible.getDefense()) + "de degat à " + cible.getNom());
    }

    @Override
    public void attackSpecial(Personnage att, Personnage cible) {
        switch(att.getRole()){
            case SOIGNEUR:
                cible.setPv(att.getMagie());
                System.out.println(att.getNom()+ " rend  " + (att.getMagie()) + "point de vie à " + cible.getNom());

                break;

            case BOSS:
                final int percentage = ThreadLocalRandom.current().nextInt(0,3);

                switch (percentage){
                    case 0:
                        cible.setPv(cible.getPv() - (att.getMagie()*1.5-cible.getDefense()));
                        System.out.println(att.getNom()+ " inflige avec son attaque magique" + (att.getMagie()*1.5-cible.getDefense()) + "de degat à " + cible.getNom());

                        break;
                    case 1:
                        cible.setPv(cible.getPv() - (att.getAttaque()*2-cible.getDefense()));                        System.out.println(att.getNom()+ " inflige avec son attaque spéciale " + (att.getAttaque()*2-cible.getDefense()) + "de degat à " + cible.getNom());

                        break;
                    case 2:
                        cible.setPv(cible.getPv() - (att.getAttaque()-cible.getDefense()));
                        System.out.println(att.getNom()+ " inflige avec son attaque" + (att.getAttaque()-cible.getDefense()) + "de degat à " + cible.getNom());

                        break;

                }

                break;
            case GUERRIER:

                cible.setPv(cible.getPv() - (att.getAttaque()*2-cible.getDefense()));
                System.out.println(att.getNom()+ " inflige avec son attaque spéciale " + (att.getAttaque()*2-cible.getDefense()) + "de degat à " + cible.getNom());

                break;
            case MAGE:

                cible.setPv(cible.getPv() - (att.getMagie()*2-cible.getDefense()));
                System.out.println(att.getNom()+ " inflige avec son attaque spéciale " + (att.getMagie()*2-cible.getDefense()) + "de degat à " + cible.getNom());

                break;

            default:
                cible.setPv(cible.getPv() - (att.getMagie()*1.5-cible.getDefense()));
                System.out.println(att.getNom()+ " inflige avec son attaque spéciale " + (att.getMagie()*1.5-cible.getDefense()) + "de degat à " + cible.getNom());

                break;
        }


    }
}
