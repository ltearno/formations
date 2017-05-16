package fr.lteconsulting;

import java.util.Random;

public class Conway implements IConway
{
	private final int width;
	private final int height;

	private boolean board[];

	public Conway( int width, int height )
	{
		this.width = width;
		this.height = height;

		board = new boolean[width * height];
	}

	public void initializeRandomly()
	{
		Random random = new Random();

		for( int i = 0; i < width; i++ )
			for( int j = 0; j < height; j++ )
				board[cellIndex( i, j )] = random.nextInt( 5 ) == 0;
	}

	public void putFigure( int x, int y, String[] pattern )
	{
		for( int p = 0; p < pattern.length; p++ )
		{
			String line = pattern[p];
			for( int i = 0; i < line.length(); i++ )
			{
				if( x + i < 0 || x + i >= width
						|| y + p < 0 || y + p >= height )
					continue;

				board[cellIndex( x + i, y + p )] = line.charAt( i ) != ' ';
			}
		}
	}

	public void putFrog( int x, int y )
	{
		putFigure( x, y, new String[] {
				" XXX",
				"XXX "
		} );
	}

	public void putU( int x, int y )
	{
		putFigure( x, y, new String[] {
				"XXX",
				"X X",
				"X X"
		} );
	}

	public boolean getCell( int x, int y )
	{
		if( x < 0 || x >= width || y < 0 || y >= height )
			return false;

		return board[cellIndex( x, y )];
	}

	@Override
	public void makeCellAlive( int x, int y )
	{
		putU( x, y );
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public void display()
	{
		for( int i = 0; i < width + 2; i++ )
			System.out.print( "_" );
		System.out.println();

		for( int j = 0; j < height; j++ )
		{
			StringBuilder sb = new StringBuilder();

			sb.append( "|" );
			for( int i = 0; i < width; i++ )
				sb.append( getCell( i, j ) ? "#" : " " );
			sb.append( "|" );

			System.out.println( sb.toString() );
		}

		for( int i = 0; i < width + 2; i++ )
			System.out.print( "_" );
		System.out.println();
	}

	public void evolve()
	{
		boolean nextBoard[] = new boolean[width * height];

		for( int i = 0; i < width; i++ )
		{
			for( int j = 0; j < height; j++ )
			{
				int count = countAliveNeighbourCells( i, j );

				if( getCell( i, j ) )
				{
					// cell is alive
					nextBoard[cellIndex( i, j )] = count == 2 || count == 3;
				}
				else
				{
					nextBoard[cellIndex( i, j )] = count == 3;
				}
			}
		}

		board = nextBoard;
	}

	private int countAliveNeighbourCells( int i, int j )
	{
		int count = 0;

		for( int dx = -1; dx <= 1; dx++ )
		{
			for( int dy = -1; dy <= 1; dy++ )
			{
				int x = i + dx;
				int y = j + dy;

				if( x == i && y == j )
					continue;

				if( getCell( x, y ) )
					count++;
			}
		}

		return count;
	}

	private int cellIndex( int i, int j )
	{
		return j * height + i;
	}
}
