
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class ClientTest {

  @Rule
public DatabaseRule database = new DatabaseRule();


@Test
public void Client_instantiatesCorrectly_true() {
  Client myClient = new Client("Alice",1);
  assertEquals(true, myClient instanceof Client);
}

@Test
public void Client_instantiatesWithName_Alice() {
  Client myClient = new Client("Alice", 1);
  assertEquals("Alice", myClient.getName());
}

@Test
public void all_returnsAllInstancesofClient_true() {
  Client firstClient = new Client("Alice", 1);
  firstClient.save();
  Client secondClient = new Client("Bob", 2);
  secondClient.save();
  assertEquals (true, Client.all().get(0).equals(firstClient));
  assertEquals (true, Client.all().get(1).equals(secondClient));
}

@Test
public void clear_emptiesAllClientsFromArrayList_0() {
  Client myClient = new Client("Alice",  1);
  assertEquals(Client.all().size(), 0);
}

@Test
public void getId_ClientsInstantiateWithAnID_1() {
  Client myClient = new Client("Alice",  1);
  myClient.save();
  assertTrue(myClient.getId() > 0);
}

@Test
public void find_returnsClientWithSameId_secondClient() {
  Client firstClient = new Client("Alice",  1);
  firstClient.save();
  Client secondClient = new Client("Bob",  2);
  secondClient.save();
  assertEquals(Client.find(secondClient.getId()), secondClient);
}

@Test
public void equals_returnsTrueIfDescriptionsAretheSame() {
  Client firstClient = new Client("Alice", 1);
  Client secondClient = new Client("Alice",  1);
  assertTrue(firstClient.equals(secondClient));
}

@Test
public void save_returnsTrueIfDescriptionsAretheSame() {
  Client myClient = new Client("Alice", 1);
  myClient.save();
  assertTrue(Client.all().get(0).equals(myClient));
}

@Test
public void save_assignsIdToObject() {
  Client myClient = new Client("Alice",  1);
  myClient.save();
  Client savedClient = Client.all().get(0);
  assertEquals(myClient.getId(), savedClient.getId());
}


@Test
public void save_savesStylistIdIntoDB_true() {
  Stylist myStylist = new Stylist("Stylist One");
  myStylist.save();
  Client myClient = new Client("Alice", myStylist.getId());
  myClient.save();
  Client savedClient = Client.find(myClient.getId());
  assertEquals(savedClient.getStylistId(), myStylist.getId());
}

@Test
  public void update_updatesClientName_true() {
    Client myClient = new Client("Alice", 1);
    myClient.save();
    myClient.update("Bob");
    assertEquals("Bob", Client.find(myClient.getId()).getName());
  }

  @Test
  public void delete_deletesClient_true() {
    Client myClient = new Client("Alice", 1);
    myClient.save();
    int myClientId = myClient.getId();
    myClient.delete();
    assertEquals(null, Client.find(myClientId));
  }




} // closes class
