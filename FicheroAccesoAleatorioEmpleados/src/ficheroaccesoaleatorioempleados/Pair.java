package ficheroaccesoaleatorioempleados;

class Pair<U, V>
{
	public final U key;		// first field of a Pair
	public final V value; 	// second field of a Pair

	// Constructs a new Pair with specified values
	public Pair(U key, V value)
	{
		this.key = key;
		this.value = value;
	}
        
        // METODOS AÑADIDOS
        public U getKey (){
            return key;
        }
        
        public V getValue (){
            return value;
        }

	@Override
	// Checks specified object is "equal to" current object or not
	public boolean equals(Object o)
	{
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Pair<?, ?> pair = (Pair<?, ?>) o;

		// call equals() method of the underlying objects
		if (!key.equals(pair.key))
			return false;
		return value.equals(pair.value);
	}

	@Override
	// Computes hash code for an object to support hash tables
	public int hashCode()
	{
		// use hash codes of the underlying objects
		return 31 * key.hashCode() + value.hashCode();
	}

	@Override
	public String toString()
	{
		return "(" + key + ", " + value + ")";
	}

}

