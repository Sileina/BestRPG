public class Personnage {

    private String nom;
    private Double pv;

    public Double getPv() {
        return pv;
    }

    public void setPv(Double pv) {
        this.pv = pv;
    }

    public Double getAttaque() {
        return attaque;
    }

    public void setAttaque(Double attaque) {
        this.attaque = attaque;
    }

    public Double getDefense() {
        return defense;
    }

    public void setDefense(Double defense) {
        this.defense = defense;
    }

    public Double getMagie() {
        return magie;
    }

    public void setMagie(Double magie) {
        this.magie = magie;
    }

    private Double attaque;
    private Double defense;
    private Double magie;
    private RoleList role;

    public Personnage(RoleList role) {
        this.role = role;
    }


    public RoleList getRole() {
        return role;
    }

    public void setRole(RoleList role) {
        this.role = role;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

