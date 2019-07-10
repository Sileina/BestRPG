import java.util.concurrent.ThreadLocalRandom;

public class AttackManagerImpl implements AttackManager {
    @Override
    public void attack(Personnage att, Personnage cible) {
        cible.setPv(cible.getPv - (att.getAttaque()-cible.getDefense()));
    }

    @Override
    public void attackSpecial(Personnage att, Personnage cible) {
        switch(personnage.getRole()){
            case SOIGNEUR:
                cible.setPv(cible.getMagie());
                break;

            case WORLDBOSS:
                final int percentage = ThreadLocalRandom.current().nextInt(0,3);


                cible.setPv(cible.getPv - (att.getMagie()*1.5-cible.getDefense()));
                break;

            default:
                cible.setPv(cible.getPv - (att.getMagie()*1.5-cible.getDefense()));
                break;
        }

    }
}
