package round1;

class Flower {
	public String whats_Your_Name() {
		return "I have many names and types";
	}
}

class Jasmine extends Flower {
	@Override
	public String whats_Your_Name() {
		return "Jasmine";
	}
}

class Lily extends Flower {
	@Override
	public String whats_Your_Name() {
		return "Lily";
	}
}

class Lotus extends Flower {
	@Override
	public String whats_Your_Name() {
		return "Lotus";
	}
}

abstract class State {
	abstract public Flower your_National_Flower();
}

class WestBengal extends State {
	@Override
	public Flower your_National_Flower() {
		return new Jasmine();
	}
}

class Karnataka extends State {
	@Override
	public Flower your_National_Flower() {
		return new Lotus();
	}
}

class AndhraPradesh extends State {
	@Override
	public Flower your_National_Flower() {
		return new Lily();
	}
}