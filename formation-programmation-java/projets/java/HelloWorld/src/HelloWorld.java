public class HelloWorld
{
	public static void main( String[] args )
	{
		// Les variables
		
		// nom donné à un espace mémoire, contenant une valeur
		
		// déclaration de la variable 'a' 
		// qui est de type "int" (nombre entier)
		int a;
		
		// affectation de la variable 'a' à la valeur 4
		a = 4;
		
		// déclaration + affectation
		int b = a * a;
		
		System.out.println( "La variable a vaut " + a );
		System.out.println( "La variable b vaut " + b );
		
		// les types primitifs
		
		boolean g = false; // booléen (consomme 8 bits généralement)
		boolean h = true;
		
		byte f; // entiers signé sur8 bits
		short d; // entiers signé sur 16 bits
		int c; // entiers signé sur 32 bits
		long e; // entier signé sur 64 bits
		
		float i = 10.424f; // nombre flottant sur 32 bits (norme IEEE754)
		double j = 5.33d; // nombre flottant sur 64 bits (norme IEEE754)
		
		char k = 'a'; // représente un caractère sur 16 bits (unicode UTF-16)
		k = 'b' + 1;
		
		// Conversions entre types primitifs
		byte l = (byte) 2366;
		int m = l;
		
		System.out.println( "l vaut " + l );
		
		// Chaines de caractères
		String n = "Bonjour";
		
		// On a le droit de concaténer les String avec n'importe quoi d'autre
		String o = "La valeur de m est " + m + " et celle de n: " + n;
		
		System.out.println( o );
	}
}









