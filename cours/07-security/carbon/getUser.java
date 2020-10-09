@GetMapping("/otherTrainers")
public List<Trainers> getOtherTrainers(Principal principal) {
    return trainerRepository
        .findOtherTrainers(principal.getName());
}

@GetMapping("/otherTrainers")
public List<Trainers> getOtherTrainers() {
    SecurityContext
    return trainerRepository
    .findOtherTrainers(principal.getName());
}