public class CreationManagerImpl implements CreationManager{
    @Override
    public void creation(Personnage personnage) {
        switch(personnage.getRole()){
            case MAGE:
                personnage.setNom("Mage");
                personnage.setPv(2500.0);
                personnage.setAttaque(100.0);
                personnage.setDefense(150.0);
                personnage.setMagie(450.0);
                break;

            case PALADIN:
                personnage.setNom("Paladin");
                personnage.setPv(5000.0);
                personnage.setAttaque(100.0);
                personnage.setDefense(350.0);
                personnage.setMagie(50.0);
                break;
            case GUERRIER:
                personnage.setNom("Guerrier");
                personnage.setPv(3500.0);
                personnage.setAttaque(450.0);
                personnage.setDefense(250.0);
                personnage.setMagie(100.0);
                break;
            case SOIGNEUR:
                personnage.setNom("Soigneur");
                personnage.setPv(2500.0);
                personnage.setAttaque(100.0);
                personnage.setDefense(150.0);
                personnage.setMagie(450.0);
                break;
            case BOSS:
                personnage.setNom("World Boss");
                personnage.setPv(10000.0);
                personnage.setAttaque(450.0);
                personnage.setDefense(70.0);
                personnage.setMagie(600.0);
                break;

                default:
                    personnage.setNom("Freelance");
                    personnage.setPv(6666.0);
                    personnage.setAttaque(666.0);
                    personnage.setDefense(66.0);
                    personnage.setMagie(666.0);
                    break;
        }
    }
}
