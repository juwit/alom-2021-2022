@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Integer> {
    List<Trainer> findAll();
    Trainer findById(int id);
    Trainer save(Trainer trainer);
}
