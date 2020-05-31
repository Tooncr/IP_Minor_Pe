package be.ucll.ip.project.repository;

import be.ucll.ip.project.domain.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubtaskRepository extends JpaRepository<SubTask, Integer> {
}
