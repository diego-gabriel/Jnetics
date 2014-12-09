
public class ApplicationController {
	
	private ApplicationFrame frame;
	
	public ApplicationController(){
		frame = new ApplicationFrame(this);		
	}
	
	public void init(){
		frame.setVisible(true);
	}

	public boolean isvalide(String input) {
		boolean res = true;
		if(input == null || input.isEmpty())
			res = false;
		else{
			int i = 0;
			while(i < input.length() && res){
				if(!Character.isDigit(input.charAt(i)))
						res = false;
				i++;
			}
		}
		return res;
	}
}
