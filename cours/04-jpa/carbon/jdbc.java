public List<Trainer> findAll() throws Exception{
    Class.forName("org.h2.Driver");
    var connection = DriverManager.getConnection("jdbc:h2:mem:test");
    var statement = connection.createStatement();
    var result = statement.executeQuery("select * from trainer");

    var trainers = new ArrayList<Trainer>();
    while(result.next()){
        var id = result.getInt("id");
        var name = result.getString("name");
        trainers.add(new Trainer(id, name));
    }
    statement.close();
    connection.commit();
    connection.close();

    return trainers;
}
