package runner.browsers;

public enum Browsers {

	FIREFOX,
	CHROME;

	public static Browsers browserForName(String browser) throws IllegalArgumentException {
		for (Browsers b : values()) {
			if (b.toString().equalsIgnoreCase(browser)) {
				return b;
			}
		}
		throw browserNotFound(browser);
	}

	private static IllegalArgumentException browserNotFound(String outcome) {
		return new IllegalArgumentException(("Invalid browser [" + outcome + "]"));
	}
}
