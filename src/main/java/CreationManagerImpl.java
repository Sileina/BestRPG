public class CreationManagerImpl implements CreationManager{
    @Override
    public void creation(Personnage personnage) {
        switch(personnage.getRole()){
            case MAGE:
                personnage.setNom("Mage");
                personnage.setPv(311);
                personnage.setAttaque(400);
                personnage.setDefense(300);
                personnage.setMagie(424);
                break;

            case PALADIN:
                personnage.setNom("Paladin");
                personnage.setPv(311);
                personnage.setAttaque(400);
                personnage.setDefense(300);
                personnage.setMagie(400);
                break;
            case GUERRIER:
                personnage.setNom("Guerrier");
                personnage.setPv(311);
                personnage.setAttaque(400);
                personnage.setDefense(300);
                personnage.setMagie(400);
                break;
            case SOIGNEUR:
                personnage.setNom("Soigneur");
                personnage.setPv(311);
                personnage.setAttaque(400);
                personnage.setDefense(300);
                personnage.setMagie(400);
                break;
                
                default:
                    personnage.setNom("Freelance");
                    personnage.setPv(311);
                    personnage.setAttaque(400);
                    personnage.setDefense(300);
                    personnage.setMagie(400);
                    break;
        }
    }
}
