package coffee4dev.finalyz.svc;

import java.util.List;

import coffee4dev.finalyz.model.Tag;

public interface TagService {

	void saveTag(Tag tag);
	
	List<Tag> findAll();
	
	void updateTag(Tag tag);
	
	Tag findByName(String name);
	
}
