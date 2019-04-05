public class Level 
{
		private String level;
		private String[] letters;
		
		public Level(String levelIn, String[] lettersIn)
		{
			level = levelIn;
			letters = lettersIn;
		}
		
		public String getLevel()
		{
			return level;
		}
		
		public String[] getLetterGrades()
		{
			return letters;
		}
}
