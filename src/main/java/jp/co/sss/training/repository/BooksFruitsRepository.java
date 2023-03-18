package jp.co.sss.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.sss.training.entity.BooksFruits;

public interface BooksFruitsRepository extends JpaRepository<BooksFruits, Integer> {
	List<BooksFruits>  findByPriceAndGenreId(int price,int genre_id);
	List<BooksFruits>  findByPriceOrGenreId(int price,int genre_id);
	@Query("select bf from BooksFruits bf order by bf.price asc")
	List<BooksFruits>  findByOrederByPriceAsc();
	@Query("select bf from BooksFruits bf order by bf.price desc")
	List<BooksFruits> findByTop5ByOrderByDesc();
	@Query("select bf from BooksFruits bf where bf.name LIKE :keyword%")
	List<BooksFruits> findByNameStartingWithKind(@Param("keyword") String keyword);
}
