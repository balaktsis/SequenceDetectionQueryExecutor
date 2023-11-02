package com.datalab.siesta.queryprocessor.model.Queries.QueryTypes;

import com.datalab.siesta.queryprocessor.model.DBModel.Metadata;
import com.datalab.siesta.queryprocessor.model.Queries.QueryPlans.QueryPlan;
import com.datalab.siesta.queryprocessor.model.Queries.Wrapper.QueryWrapper;


/**
 * This interface is a generic class that describes the different query types (e.g. pattern detection, stats etc).
 * It has only one function that returns a query plan based on the query pattern and the metadata of the log
 * database.
 * This interface is a part of the generic query response procedure that follows the steps below:
 * Endpoint (query wrapper) -> QueryTypes -> creates a QueryPlan -> the QueryPlan is executed -> a QueryResponse is returned
 */
public interface Query {

    QueryPlan createQueryPlan(QueryWrapper qw, Metadata m);

}
