package jp.co.sss.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.NamedQuery;
import jp.co.sss.training.entity.TrainingUser;

@NamedQuery(name = "findByUserIdNamedQuery",query = "SELECT u FROM TrainingUser u WHERE u.userId LIKE CONCAT('%', :keyword, '%')")
public interface UserRepository extends JpaRepository<TrainingUser, Long> {
	TrainingUser findByUserIdAndPassword(String userId,String password);
	TrainingUser findById(int id);
}
