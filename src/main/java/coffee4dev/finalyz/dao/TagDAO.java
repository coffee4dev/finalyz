package coffee4dev.finalyz.dao;

import java.util.List;

import coffee4dev.finalyz.model.Tag;

public interface TagDAO {
	
	void saveTag(Tag tag);
	
	List<Tag> findAllTags();
	
	void updateTag(Tag tag);
	
	Tag findByName(String name);

}
