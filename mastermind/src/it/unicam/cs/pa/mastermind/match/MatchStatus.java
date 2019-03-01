package it.unicam.cs.pa.mastermind.match;

/**
 * @author Michele Celozzi
 *
 */
public enum MatchStatus {
	INIT,
	PLAYING,
	END;

	@Override
	public String toString() {
		switch(this) {
			case INIT:
				return "Initialized";
			case PLAYING:
				return "Playing";
			case END:
				return "End";
		}
		return super.name();
	}


}
