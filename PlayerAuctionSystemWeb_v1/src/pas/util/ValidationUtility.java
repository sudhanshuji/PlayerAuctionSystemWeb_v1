package pas.util;

public interface ValidationUtility {
	public boolean validateCategory(String category);
	public boolean validateHighestScore(int score);
	public boolean validateBestFigure(int score,String bestfigure);
	public boolean isPlayerNameValid(String name);
	public boolean validateTeamName(String teamName);
}
