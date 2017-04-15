package VeryImportantQuestions;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// m - number of movies , n - recommended movies
// Time Complexity - O(m log n)
// Space Complexity - O(m+n)

// Note: We can also solve the problem using Tree Set with a space complexity of O(m) but time 
// is always O(m log m). As we don't need to sort all the m movies for this requirement I opted 
// for Heap and Set data structures.

public class GetSimilarRatedMovies {
	
	static PriorityQueue<Movie> getMovieRecommendations(Movie movie, int countOfMoviesToRecommend) throws Exception {
		if(movie==null || countOfMoviesToRecommend<=0 || movie.similarMovies.isEmpty()) {
			throw new Exception("No Recommandations Avaliable");
		}
		Set<Movie> visitedMovies = new HashSet<Movie>();
		visitedMovies.add(movie);
		PriorityQueue<Movie> topRatedMoviesList = new PriorityQueue<Movie>();
		getMovieRecommendationsHelper(movie, visitedMovies, topRatedMoviesList, countOfMoviesToRecommend);
		return topRatedMoviesList;
	}
	
	private static void getMovieRecommendationsHelper(Movie movie, Set<Movie> visitedMovies,  
									PriorityQueue<Movie> topRatedMoviesList, int countOfMoviesToRecommend) {

		for (Movie similarMovie: movie.similarMovies) {
			// check if the movie is already visited 
			if(!visitedMovies.contains(similarMovie)) {
				visitedMovies.add(similarMovie);
				// check if the top rated movies list is full
				if(topRatedMoviesList.size()==countOfMoviesToRecommend) {
					// check if current movie rating is more than least rated movie in the list 
					if(topRatedMoviesList.peek().rating < similarMovie.rating) {
						topRatedMoviesList.remove();
						topRatedMoviesList.add(similarMovie);
					}
				}
				else {
					topRatedMoviesList.add(similarMovie);
				}
				getMovieRecommendationsHelper(similarMovie, visitedMovies, topRatedMoviesList, countOfMoviesToRecommend);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Movie A = new Movie("A",1.2);
		Movie B = new Movie("B",3.6);
		Movie C = new Movie("C",2.4);
		Movie D = new Movie("D",4.8);
		Movie E = new Movie("E",2.0);
		A.addSimilarMovie(B);
		B.addSimilarMovie(A);
		A.addSimilarMovie(C);
		C.addSimilarMovie(A);
		B.addSimilarMovie(D);
		D.addSimilarMovie(B);
		try {
			System.out.println(getMovieRecommendations(A,1));
			System.out.println(getMovieRecommendations(A,2));
			System.out.println(getMovieRecommendations(A,3));
			System.out.println(getMovieRecommendations(C,1));
			System.out.println(getMovieRecommendations(E,1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

class Movie implements Comparable<Movie> {
	String movieName;
	double rating;
	Set<Movie> similarMovies;
	
	Movie(String movieName, double rating) {
		this.movieName = movieName;
		this.rating = rating;
		this.similarMovies = new HashSet<Movie>();		
	}
	
	void addSimilarMovie(Movie similarMovie) {
		similarMovies.add(similarMovie);
	}

	@Override
	public String toString() {
		return "(" + movieName + ","+rating+")";
	}

	@Override
	public int compareTo(Movie o) {
		if(this.rating>o.rating) {
			return 1;
		}
		else if(this.rating<o.rating) {
			return -1;
		}
		
		return 0;
	}
	
	
}
