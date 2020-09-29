@Repository
public class TrainerJDBCRepositoryImpl implements TrainerRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TrainerJDBCRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Trainer> findAll() {
        return jdbcTemplate.query("select * from trainer",  new TrainerRowMapper());
    }

    @Override
    public Trainer save(Trainer trainer) {
        return jdbcTemplate.update("insert into trainer(id,name) values (?,?)", trainer.getId(), trainer.getName());
    }

    static class TrainerRowMapper implements RowMapper<Trainer> {

        @Override
        public Trainer mapRow(ResultSet resultSet, int i) throws SQLException {
            var trainer = new Trainer();
            trainer.setId(resultSet.getInt("id"));
            trainer.setName(resultSet.getString("name"));
            return trainer;
        }
    }
}