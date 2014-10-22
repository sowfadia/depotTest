package vin;

public class Catalogue implements IteratorFactory{
	
	protected Vin[] lesVins;
	protected int dernier=-1;
	
	public Catalogue(int taille){
		this.lesVins=new Vin[taille];
	}
	
	public void addVin(Vin v){
		lesVins[++dernier]=v;
	}
	
	public Vin choisirVin(int i){
		return lesVins[i];
	}
	
	public Iterator iterator(Critere c){
		return new IteratorCritere(c);
	}
	
	class IteratorCritere implements Iterator {
		Critere c ;
		int next = -1;
		
		public IteratorCritere(Critere c){
			this.c=c;
			int i=0;
			while((i<lesVins.length) && !(choisirVin(i).repondA(c))){
				i++;
			}
			
			if(i<lesVins.length){
				next=i;
			}
			
		}
		
		public Vin next() {
			Vin v=choisirVin(next);
			
			int i=next+1;
			while((i<lesVins.length) && !(choisirVin(i).repondA(c))){
				i++;
			}
			
			if(i<lesVins.length){
				next=i;
			}
			else next=-1;
			return v;
		}

		
		public boolean hasNext() {
			return next !=-1;
		}

	}

	
}
