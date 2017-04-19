package Designing.ScientificQueries;

public class Query {
	int queryId;
	Scientist scientist;
	BlackHole blackHole;
	QueryType queryType;
	String queryDetails;
}

enum QueryType {
	radius, temperature, size
}
