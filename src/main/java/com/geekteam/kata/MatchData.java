package com.geekteam.kata;

public class MatchData {

	private String opponentName;
	private int pointsToWin;
	private int maxRounds;
	private int dynamiteCount;

	public MatchData(String opponentName, int pointsToWin, int maxRounds, int dynamiteCount) {
		this.opponentName = opponentName;
		this.pointsToWin = pointsToWin;
		this.maxRounds = maxRounds;
		this.dynamiteCount = dynamiteCount;
	}

	public String getOpponentName() {
		return opponentName;
	}

	public int getPointsToWin() {
		return pointsToWin;
	}

	public int getMaxRounds() {
		return maxRounds;
	}

	public int getDynamiteCount() {
		return dynamiteCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dynamiteCount;
		result = prime * result + maxRounds;
		result = prime * result
				+ ((opponentName == null) ? 0 : opponentName.hashCode());
		result = prime * result + pointsToWin;
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
		MatchData other = (MatchData) obj;
		if (dynamiteCount != other.dynamiteCount)
			return false;
		if (maxRounds != other.maxRounds)
			return false;
		if (opponentName == null) {
			if (other.opponentName != null)
				return false;
		} else if (!opponentName.equals(other.opponentName))
			return false;
		if (pointsToWin != other.pointsToWin)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MatchData [opponentName=" + opponentName + ", pointsToWin="
				+ pointsToWin + ", maxRounds=" + maxRounds + ", dynamiteCount="
				+ dynamiteCount + "]";
	}

	
	
}
