static org.junit.jupiter.api.Assertions.*;

class CreationManagerImplTest {
    @Test
    void creation(){
        //Setup

        //Run
        personnage.getRole()

        //Test
        assertEquals(personnage.getRole, [MAGE, PALADIN, GUERRIER, SOIGNEUR, BOSS])
    };



}