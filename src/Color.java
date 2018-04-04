
public class Color extends Screen{
	 /*B2
     * static method of same name and method signature as existed in super
     * class, this is not method overriding instead this is called
     * method hiding in Java
     */
    public static void show(){
        System.err.println("Child Class in Java");
    }
    
    public void callStatic(){
    	System.out.println("Calling non static method");
    	Color.show();
    	Color.print();
    }
    public static void main(String args[]){
    	Color co = new Color();
    	co.callStatic();
    }
}
