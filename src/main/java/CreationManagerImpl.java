public class CreationManagerImpl implements CreationManager{
    @Override
    public void creation(Personnage personnage) {
        switch(personnage.getRole()){
            case MAGE:
                personnage.setNom("Mage");
                personnage.setPv(311.0);
                personnage.setAttaque(400.0);
                personnage.setDefense(300.0);
                personnage.setMagie(400.0);
                break;

            case PALADIN:
                personnage.setNom("Paladin");
                personnage.setPv(311.0);
                personnage.setAttaque(400.0);
                personnage.setDefense(300.0);
                personnage.setMagie(400.0);
                break;
            case GUERRIER:
                personnage.setNom("Guerrier");
                personnage.setPv(311.0);
                personnage.setAttaque(400.0);
                personnage.setDefense(300.0);
                personnage.setMagie(400.0);
                break;
            case SOIGNEUR:
                personnage.setNom("Soigneur");
                personnage.setPv(311.0);
                personnage.setAttaque(400.0);
                personnage.setDefense(300.0);
                personnage.setMagie(400.0);
                break;
            case BOSS:
                personnage.setNom("World Boss");
                personnage.setPv(10000.0);
                personnage.setAttaque(10000.0);
                personnage.setDefense(300.0);
                personnage.setMagie(400.0);
                break;

                default:
                    personnage.setNom("Freelance");
                    personnage.setPv(311.0);
                    personnage.setAttaque(400.0);
                    personnage.setDefense(300.0);
                    personnage.setMagie(400.0);
                    break;
        }
    }
}
