package fr.lteconsulting;

public class Expression
{
	private double value;

	private char operator;
	private Expression leftOperand;
	private Expression rightOperand;

	public Expression( double value )
	{
		this.value = value;
	}

	public Expression( char operator, Expression leftOperand, Expression rightOperand )
	{
		this.operator = operator;
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	public double evaluate()
	{
		if( isLeaf() )
			return value;

		double leftValue = leftOperand.evaluate();
		double rightValue = rightOperand.evaluate();

		switch( operator )
		{
			case '+':
				return leftValue + rightValue;

			case '-':
				return leftValue - rightValue;

			case 'x':
				return leftValue * rightValue;

			case '/':
				return leftValue / rightValue;
		}

		System.out.println( "ERREUR !" );
		// plus tard on lèvera une Exception...
		return 0;
	}

	private boolean isLeaf()
	{
		return operator == 0;
	}
}
