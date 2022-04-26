package pas.entity;


public class Player {
		   private int playerNo;
		   private String playerName;
		   private String category;
		   private int highestScore;
		   private String bestFigure;
		   private Team team;
		/**
		 * 
		 */
		public Player() {
			// TODO Auto-generated constructor stub
		}
		/**
		 * @param playerNo
		 * @param playerName
		 * @param category
		 * @param highestScore
		 * @param bestFigure
		 * @param team
		 */
		public Player(int playerNo, String playerName, String category, int highestScore, String bestFigure, Team team) {
			this.playerNo = playerNo;
			this.playerName = playerName;
			this.category = category;
			this.highestScore = highestScore;
			this.bestFigure = bestFigure;
			this.team = team;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Player [playerNo=" + playerNo + ", playerName=" + playerName + ", category=" + category + ", highestScore="
					+ highestScore + ", bestFigure=" + bestFigure + ", team=" + team + "]";
		}
		/**
		 * @return the playerNo
		 */
		public int getPlayerNo() {
			return playerNo;
		}
		/**
		 * @param playerNo the playerNo to set
		 */
		public void setPlayerNo(int playerNo) {
			this.playerNo = playerNo;
		}
		/**
		 * @return the playerName
		 */
		public String getPlayerName() {
			return playerName;
		}
		/**
		 * @param playerName the playerName to set
		 */
		public void setPlayerName(String playerName){
			this.playerName = playerName;
		}
		/**
		 * @return the category
		 */
		public String getCategory() {
			return category;
		}
		/**
		 * @param category the category to set
		 */
		public void setCategory(String category){
			this.category = category;
		}
		/**
		 * @return the highestScore
		 */
		public int getHighestScore() {
			return highestScore;
		}
		/**
		 * @param highestScore the highestScore to set
		 */
		public void setHighestScore(int highestScore){
			this.highestScore = highestScore;
		}
		/**
		 * @return the bestFigure
		 */
		public String getBestFigure() {
			return bestFigure;
		}
		/**
		 * @param bestFigure the bestFigure to set
		 */
		public void setBestFigure(String bestFigure) {
			this.bestFigure = bestFigure;
		}
		/**
		 * @return the team
		 */
		public Team getTeam() {
			return team;
		}
		/**
		 * @param team the team to set
		 */
		public void setTeam(Team team) {
			this.team = team;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((bestFigure == null) ? 0 : bestFigure.hashCode());
			result = prime * result + ((category == null) ? 0 : category.hashCode());
			result = prime * result + highestScore;
			result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
			result = prime * result + playerNo;
			result = prime * result + ((team == null) ? 0 : team.hashCode());
			return result;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Player other = (Player) obj;
			if (bestFigure == null) {
				if (other.bestFigure != null)
					return false;
			} else if (!bestFigure.equals(other.bestFigure))
				return false;
			if (category == null) {
				if (other.category != null)
					return false;
			} else if (!category.equals(other.category))
				return false;
			if (highestScore != other.highestScore)
				return false;
			if (playerName == null) {
				if (other.playerName != null)
					return false;
			} else if (!playerName.equals(other.playerName))
				return false;
			if (playerNo != other.playerNo)
				return false;
			if (team == null) {
				if (other.team != null)
					return false;
			} else if (!team.equals(other.team))
				return false;
			return true;
		}
}


