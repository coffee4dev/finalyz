package coffee4dev.finalyz.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coffee4dev.finalyz.dao.TagDAO;
import coffee4dev.finalyz.model.Tag;

@Service("tagService")
@Transactional
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDAO dao;
	
	@Override
	public void saveTag(Tag tag) {
		dao.saveTag(tag);
	}

	@Override
	public List<Tag> findAll() {
		return dao.findAllTags();
	}

	@Override
	public void updateTag(Tag tag) {
		dao.updateTag(tag);
	}

	@Override
	public Tag findByName(String name) {
		return dao.findByName(name);
	}
}
