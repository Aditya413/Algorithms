
public class CanWeOverrideStaticMethod {
	 public static void main(String args[]) {
	      
	        Color scrn = new Color();
	      
	        //if we can  override static , this should call method from Child class
	        scrn.show(); //IDE will show warning, static method should be called from classname
	      
	 }  
}
