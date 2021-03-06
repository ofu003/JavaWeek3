import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class StylistTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();


  @Test
  public void Stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Anna Alessandro");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_StylistInstantiatesWithName_Anna_Alessandro() {
    Stylist testStylist = new Stylist("Anna Alessandro");
    assertEquals("Anna Alessandro", testStylist.getName());
  }

 @Test
 public void all_returnsAllInstancesOfStylist_true() {
   Stylist firstStylist = new Stylist("Anna Alessandro");
   firstStylist.save();
   Stylist secondStylist = new Stylist("Carson Cruise");
   secondStylist.save();
   assertEquals(true, Stylist.all().get(0).equals(firstStylist));
   assertEquals(true, Stylist.all().get(1).equals(secondStylist));
 }

 @Test
 public void getId_StylistsInstantiateWithAnId_1() {
   Stylist testStylist = new Stylist("Anna Alessandro");
   testStylist.save();
   assertTrue(testStylist.getId() > 0);
 }

 @Test
 public void find_returnsStylistWithSameId_secondStylist() {
   Stylist firstStylist = new Stylist("Anna Alessandro");
   firstStylist.save();
   Stylist secondStylist = new Stylist("Carson Cruise");
   secondStylist.save();
   assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
 }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Stylist firstStylist = new Stylist("Stylist One");
    Stylist secondStylist = new Stylist("Stylist One");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Stylist myStylist = new Stylist("Stylist One");
    myStylist.save();
    assertTrue(Stylist.all().get(0).equals(myStylist));
  }

  @Test
  public void save_assignsIdToObject() {
    Stylist myStylist = new Stylist("Stylist One");
    myStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(myStylist.getId(), savedStylist.getId());
  }

  @Test
  public void getClients_retrievesALlClientsFromDatabase_ClientsList() {
    Stylist myStylist = new Stylist("Stylist One");
    myStylist.save();
    Client firstClient = new Client("Alice", myStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Carson", myStylist.getId());
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };

    assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
  }

  @Test
  public void delete_deletesStylist_true() {
    Stylist myStylist = new Stylist("Stylist One");
    myStylist.save();
    int myStylistId = myStylist.getId();
    myStylist.delete();
    assertEquals(null, Stylist.find(myStylistId));
  }

  @Test
  public void update_updatesStylist_true(){
    Stylist myStylist = new Stylist("Stylist 3");
    myStylist.save();
    myStylist.update("Stylist 5");
    assertEquals("Stylist 5", Stylist.find(myStylist.getId()).getName());
  }

}
