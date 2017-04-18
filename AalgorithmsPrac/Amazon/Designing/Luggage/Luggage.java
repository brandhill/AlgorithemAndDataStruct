package Designing.Luggage;

public class Luggage {
	int token;
	String baggaeDetails;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + token;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Luggage other = (Luggage) obj;
		if (token != other.token)
			return false;
		return true;
	}
	
	
}

class Small extends Luggage {
	Small(int token, String baggageDetails) {
		this.token = token;
		this.baggaeDetails = baggageDetails;
	}
}

class Medium extends Luggage {
	Medium(int token, String baggageDetails) {
		this.token = token;
		this.baggaeDetails = baggageDetails;
	}
}

class Large extends Luggage {
	Large(int token, String baggageDetails) {
		this.token = token;
		this.baggaeDetails = baggageDetails;
	}
}
