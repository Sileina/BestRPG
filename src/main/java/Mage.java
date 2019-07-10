

public class Mage implements AttackManager{
    public Personnage joelle = new Personnage();

    @Override
    public void attack(Personnage att, Personnage cible) {
        cible.setPv(cible.getPv - (att.getAttaque()-cible.getDefense()));
    }

    @Override
    public void attackSpecial(Personnage att, Personnage cible) {
        cible.setPv(cible.getPv - (att.getMagie()*1.5-cible.getDefense()));
    }


    joelle.setNom("Mage");
    joelle.setPv(311);
    joelle.setAttaque(400);
    joelle.setDefense(300);
    joelle.getMagie(400);

}
