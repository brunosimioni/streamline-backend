package pdicrawler.entities;

import lombok.Data;

@Data
public class PDIItem {
	public Integer id;
	public String name;
	public String category;

	public PDIItem() {
	};

	public PDIItem(Integer id, String name, String category) {
		this.id = id;
		this.name = name;
		this.category = category;
	}
}
