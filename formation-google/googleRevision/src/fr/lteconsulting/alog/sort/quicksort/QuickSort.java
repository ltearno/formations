package fr.lteconsulting.alog.sort.quicksort;

public class QuickSort
{
	public static void quickSort( int[] table, int from, int to )
	{
		// partition the table, the pivot is returned
		// quickSort each partition around the pivot index
	}

	private static int partition( int[] table, int from, int to )
	{
		int pivot = from;

		int l = from;
		int r = to;

		while( true )
		{
			while( table[r] >= pivot )
				r--;

			while( table[l] <= pivot )
				l++;

			if( l >= r )
				return l;
		}

		// de droite à gauche trouver un plus petit que le pivot
		// de gauche à droite trouver un plus grand que le pivot

		// si index du plus petit est plus grand que l'index du plus grand, les échanger

		// sinon retourner l'index du pivot

		return pivot;
	}
}
