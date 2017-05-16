package fr.lteconsulting;

public class AnalyseurExpression
{
	public static void main( String[] args )
	{
		testExpressions();

		testTokenizer();

		Expression expression = analyseExpression( "+ 25 - 12 x 17 13" );
		verifieValeurExpression( expression, -184 );
	}

	public static Expression analyseExpression( String expression )
	{
		Tokenizer tokenizer = new Tokenizer( expression );

		return analyseExpression( tokenizer );
	}

	public static Expression analyseExpression( Tokenizer tokenizer )
	{
		String token = tokenizer.getNextToken();
		if( token == null )
			return null;

		if( Character.isDigit( token.charAt( 0 ) ) )
		{
			double value = Double.parseDouble( token );

			return new Expression( value );
		}
		else
		{
			char operator = token.charAt( 0 );
			Expression leftOperand = analyseExpression( tokenizer );
			Expression rightOperand = analyseExpression( tokenizer );

			return new Expression( operator, leftOperand, rightOperand );
		}
	}

	private static void testTokenizer()
	{
		Tokenizer tokenizer = new Tokenizer( " / 50   20" );
		System.out.println( "token: '" + tokenizer.getNextToken() + "'" );
		System.out.println( "token: '" + tokenizer.getNextToken() + "'" );
		System.out.println( "token: '" + tokenizer.getNextToken() + "'" );
	}

	private static void testExpressions()
	{
		Expression expr = new Expression( 52 );
		verifieValeurExpression( expr, 52 );

		verifieValeurExpression( new Expression( '-',
				new Expression( 'x', new Expression( 3 ), new Expression( 2 ) ),
				new Expression( '-', new Expression( 5 ), new Expression( 1 ) ) ), 2 );
	}

	private static void verifieValeurExpression( Expression expression, double expectedValue )
	{
		double value = expression.evaluate();

		if( value == expectedValue )
			System.out.println( "OK, expected value is " + value );
		else
			System.out.println( "ERROR, expected value is " + expectedValue + " but expression evaluated to " + value );
	}
}
