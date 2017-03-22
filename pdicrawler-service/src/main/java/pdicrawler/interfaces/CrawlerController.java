package pdicrawler.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pdicrawler.entities.PDIItem;
import pdicrawler.usecases.FetchPDIs;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pdicrawler")
public class CrawlerController {

	@Autowired
	private FetchPDIs fetchPDIs;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<PDIItem> getAllProducts() {

		List<PDIItem> items = new ArrayList<PDIItem>();
		items.add(new PDIItem(1, "PDIItem 1", "Category A"));

		fetchPDIs.fetchPdi();

		return items;
	}

}