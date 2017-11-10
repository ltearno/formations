package fr.lteconsulting.formations;

public enum Coup
{
	Pierre
	{
		@Override
		public int battle( Coup other )
		{
			switch( other )
			{
				case Pierre:
					return 0;
				case Feuille:
					return -1;
				case Ciseau:
					return 1;
			}
			return 0;
		}
	},
	Feuille
	{
		@Override
		public int battle( Coup other )
		{
			switch( other )
			{
				case Pierre:
					return 1;
				case Feuille:
					return 0;
				case Ciseau:
					return -1;
			}
			return 0;
		}
	},
	Ciseau
	{
		@Override
		public int battle( Coup other )
		{
			switch( other )
			{
				case Pierre:
					return -1;
				case Feuille:
					return 1;
				case Ciseau:
					return 0;
			}
			return 0;
		}
	};

	public abstract int battle( Coup other );
}
