import java.time.LocalDateTime;
import java.util.List;
import org.sql2o.*;

public class Client{
  private String name;
  private String date;
  // SQL calculates this
  private int id;
  //
  private int stylistId;

  public Client(String name, String date, int stylistId){
    this.name = name;
    this.date = date;
    this.stylistId = stylistId;
  }

  public String getName(){
    return name;
  }

  public String getDate(){
    return date;
  }

  public int getStylistId(){
    return stylistId;
  }

  public int getId(){
    return id;
  }

  public static List<Client> all() {
  String sql = "SELECT id, name, date, stylistId FROM tasks";
  try(Connection con = DB.sql2o.open()) {
   return con.createQuery(sql).executeAndFetch(Client.class);
  }
}

  @Override
    public boolean equals(Object otherClient){
      if (!(otherClient instanceof Client)) {
        return false;
      } else {
        Client newClient = (Client) otherClient;
        return this.getId() == newClient.getId() &&
               this.getName().equals(newClient.getName()) &&
               this.getDate().equals(newClient.getDate()) &&
               this.getStylistId() == newClient.getStylistId();
      }
    }

    public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO clients(name, date, stylistId) VALUES (:name, :date, :stylistId)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("date", this.date)
      .addParameter("stylistId", this.stylistId)
      .executeUpdate()
      .getKey();
    }
  }

  public static Client find(int id) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM clients where id=:id";
    Client client = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Client.class);
    return task;
    }
  }

  public void update(String name) {
  try(Connection con = DB.sql2o.open()) {
  String sql = "UPDATE clients SET name = :name WHERE id = :id";
  con.createQuery(sql)
    .addParameter("description", description)
    .addParameter("id", id)
    .executeUpdate();
    }
  }
