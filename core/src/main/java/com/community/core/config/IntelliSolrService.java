package com.community.core.config;

import org.apache.solr.client.solrj.SolrRequest.METHOD;
import org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl;

public class IntelliSolrService extends SolrSearchServiceImpl{
	
	protected METHOD getSolrQueryMethod() {
        return METHOD.GET;
    }

}
