@Entity
public class Trainer {

    @Id
    private int id;

    private String name;

    @OneToMany
    private List<Pokemon> pokemons;

}

@Repository
public class TrainerJPARepositoryImpl implements TrainerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Trainer> findAll() {
        Query query = entityManager.createQuery("select t from Trainer t");
        return query.getResultList();
    }

    public Trainer save(Trainer trainer) {
        return entityManager.merge(trainer);
    }
}


<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
</dependency>