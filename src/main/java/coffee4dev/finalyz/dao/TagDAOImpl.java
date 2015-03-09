package coffee4dev.finalyz.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import coffee4dev.finalyz.model.Tag;

@Repository("tagDAO")
public class TagDAOImpl extends AbstractDAO implements TagDAO {

	@Override
	public void saveTag(Tag tag) {
		persist(tag);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tag> findAllTags() {
		Criteria cr = getSession().createCriteria(Tag.class);
		return (List<Tag>) cr.list();
	}

	@Override
	public void updateTag(Tag tag) {
		getSession().update(tag);
	}
	
	@Override
	public Tag findByName(String name) {
		Criteria cr = getSession().createCriteria(Tag.class)
				.add(Restrictions.eq("name", name));
		return (Tag) cr.uniqueResult();
	}

}
