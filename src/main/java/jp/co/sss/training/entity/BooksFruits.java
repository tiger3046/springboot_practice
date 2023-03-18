package jp.co.sss.training.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books_fruits")
public class BooksFruits {
	@Id
	private int id;
	@Column
	private String name;
	@Column
	private int price;
	@Column
	private int genreId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genre_id) {
		this.genreId = genre_id;
	}

}
