package com.proliferay;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexerPostProcessor;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;

/**
 * @author Hamidul Islam
 */
@Component(
	immediate = true,
	property = {
		"indexer.class.name=com.liferay.portal.kernel.model.User",
		"indexer.class.name=com.liferay.portal.kernel.model.UserGroup"
	},
	service = IndexerPostProcessor.class
)
public class IndexerDemo implements IndexerPostProcessor {

	@Override
	public void postProcessContextBooleanFilter(BooleanFilter booleanFilter, SearchContext searchContext)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postProcessContextQuery(BooleanQuery contextQuery, SearchContext searchContext) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postProcessDocument(Document document, Object obj) throws Exception {
		System.out.println("############## Post Processing Document ###############"); 
		User userEntity = (User) obj;
		String indexUserTitle = "";
		
		try{
			indexUserTitle = userEntity.getJobTitle();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(indexUserTitle.length() > 0){
			document.addText(Field.TITLE,indexUserTitle);
		}
	}

	@Override
	public void postProcessFullQuery(BooleanQuery fullQuery, SearchContext searchContext) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter booleanFilter,
			SearchContext searchContext) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, SearchContext searchContext) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postProcessSummary(Summary summary, Document document, Locale locale, String snippet) {
		// TODO Auto-generated method stub
		
	}

	// TODO enter required service methods

}