public class AttackManagerImpl implements AttackManager {
    @Override
    public void attack(Personnage att, Personnage cible) {
        cible.setPv(cible.getPv() - (att.getAttaque()-cible.getDefense()));
    }

    @Override
    public void attackSpecial(Personnage att, Personnage cible) {

        cible.setPv(cible.getPv() - (att.getMagie()*1.5-cible.getDefense()));
    }
}
