public class Rec{
	StringBuilder buffer;
	public static void main(String[] args) throws Exception{
		
	}

	public Rec(){
		buffer = new StringBuilder("");
	}

	/**
	*Calcula el n-esimo numero factorial. n=num.
	*como usa int el maximo factorial soportado es 12S!
	*@param int num n-esimo factorial a calcular
	*@author Diego Porras,16001742
	*/
	public int factorial(int num){
		if(num==0 || num==1) return 1;
		return num * factorial(num-1);
	}
	//public int ack(int a,int b){}
	//public String searchPath(int num){}


}